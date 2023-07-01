### **전체 상황**

요청 보내는 프로그램 : 브라우저(크롬).
<br> 
프론트엔드 : http://localhost:3000 
<br> 
백엔드 : localhost:8080
<br> 
### **어디서 어떤 상황에서 어떤 에러가 발생하는가?**

브라우저에서 백엔드로 post 요청을 보낼 때 브라우저에 발생하는 에러 메시지 : <br> 
access to XMLHttpRequest at 'http://localhost:8080/userinfo' from origin 'http://localhost:3000/' has been blocked by CORS policy: <br> 
Response to preflight request doesn't pass access control check: <br> 
No 'Access-Control-Allow-Origin' header is present on the requested resource.<br> 

백엔드로 보낸 요청
<br> 
| status | type | 
| --- | --- | 
| 403 | preflight | 
| CORS error | xhr |
- 403 : 서버에 요청이 전달되었지만 권한 때문에 거절됨.
- CORS error
    - CORS :교차 출처 자원 공유, 서버가 same origin 정책을 완화할 수 있게 해주는 표준으로 일부 교차 출처 요청은 명시적으로 허용하고 다른 요청을 거부하는 데 사용. 다양한 원인이 존재함.
    

### 해결 방법 추론.
1. Response to preflight request doesn't pass access control check: 
    preflight request을 통해 서버로부터 접근 권한을 체크하는 과정이 존재하는데 이를 통과하지 못했음.
    preflight request란?
    - CORS 요청 전에 서버 측에서 그 요청의 메서드와 헤더에 대해 인식하고 있는지 체크하는 것.→ **서버 측에 관련된 요청을 받았을 때 처리하는 코드 추가 필요.**
    - HTTPHeader("Access-Control-Request-Method"), HTTPHeader("Access-Control-Request-Headers"), HTTPHeader("Origin") 총 3가지의 HTTP request headers를 사용하는 HTTPMethod("OPTIONS") 요청.
    - 사전 요청은 브라우저가 자동으로 발생.→**프론트엔드에는 따로 작업이 필요 없음.**
    - 단순 요청일 겨우에는 생략
2. No 'Access-Control-Allow-Origin' header is present on the requested resource.
    request header에 'Access-Control-Allow-Origin'가 빠져 있음.
    Access-Control-Allow-Origin란?
    - response가 주어진 origin(프론트엔드)으로부터 요청 코드와 공유될 수 있는지 나타냄. →**프론트엔드 측 request header에 추가 작업 필요.**
- **백엔드에 preflight request를 받았을 때 접근을 허용하는 코드 추가.**
- **프론트엔드에 Access-Control-Allow-Origin header 추가.**

### 결론
1. 스프링 부트 RestController.
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.*POST*, RequestMethod.*OPTIONS*})
2. 리액트 headers에 추가.
const headers = {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:3000' 
        };

### 레퍼런스
https://developer.mozilla.org/ko/docs/Web/HTTP/CORS/Errors<br> 
https://developer.mozilla.org/ko/docs/Glossary/Preflight_request<br> 
https://developer.mozilla.org/ko/docs/Web/HTTP/Headers/Access-Control-Allow-Origin