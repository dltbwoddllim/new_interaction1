
import requests
import json
import threading
import random

# Set the URL of the local server
url = 'http://localhost:8080/userinfo'  # Replace with your local server URL

# Function to send a request
def send_request(data):
    # Convert the data to JSON format
    json_data = json.dumps(data)
    headers = {'Content-Type': 'application/json'}

    # Send the request
    response = requests.post(url, data=json_data, headers=headers)
    
    if response.status_code == 200:
        print("Request sent successfully!")
    else:
        print("Request failed with status code:", response.status_code)

# Generate and send requests
for i in range(101,110):
    # Generate random data
    data = {
        "nickname": "User" + str(i+1),
        "major": random.randint(1, 10),
        "mbti": random.randint(1, 10)
    }
    
    # Send the request in a new thread
    thread = threading.Thread(target=send_request, args=(data,))
    thread.start()
    thread.join()

print("All requests completed.")