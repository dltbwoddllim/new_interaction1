import requests
import random
import json

def send_request(major, mbti):
    url = 'http://localhost:8080/partner'   # 실제 서버 URL로 변경해주세요
    params = {
        "major": 3,
        "mbti": 3
    }
    print(params)

    headers = {'Content-Type': 'application/json'}

    response = requests.get(url, params=params, headers=headers)
    if response.status_code == 201:
        user_info_list = response.json()
        for user_info in user_info_list:
            nickname = user_info["nickname"]
            major = user_info["major"]
            mbti = user_info["mbti"]
            print(f"Nickname: {nickname}, Major: {major}, MBTI: {mbti}")
    else:
        print(f"Request failed with status code: {response.status_code}")

if __name__ == "__main__":
    for _ in range(1):
        major = random.randint(1, 10)
        mbti = random.randint(1, 10)
        send_request(major, mbti)
