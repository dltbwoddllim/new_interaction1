import requests
import json
import threading
import random

# Set the URL of the local server
url = 'http://localhost:8080/user'  # Replace with your local server URL

# Function to send a request
def send_request():
    # Generate random data
    data = {
        "nickname": "John",
        "major": "Computer Science",
        "mbti": "INTJ", 
        "hobbies": "playing guitar"
    }
    
    # Convert the data to JSON format
    json_data = json.dumps(data)
    headers = {'Content-Type': 'application/json'}

    # Send the request
    response = requests.post(url, data=json_data, headers=headers)
    
    if response.status_code == 200:
        print("Request sent successfully!")
    else:
        print("Request failed with status code:", response.status_code)

# Create a list to hold the threads
threads = []

# Create and start 10 threads
for _ in range(100):
    thread = threading.Thread(target=send_request)
    thread.start()
    threads.append(thread)

# Wait for all threads to complete
for thread in threads:
    thread.join()
