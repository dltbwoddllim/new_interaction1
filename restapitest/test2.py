import requests
import random
import json

def send_request(major, mbti):
    url = 'http://localhost:8080/partner'   # Replace with the actual server URL
    data = {
        "nickname" : "s",
        "major": major,
        "mbti": mbti
    }
    print(data)
    json_data = json.dumps(data)

    headers = {'Content-Type': 'application/json'}

    response = requests.get(url, data=json_data, headers=headers)

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
