import React, { useState } from 'react';
import axios from 'axios';

const UserForm = () => {
  const [nickname, setNickname] = useState('');
  const [selectedMajors, setSelectedMajors] = useState([]);
  const [selectedMbti, setSelectedMbti] = useState([]);

  const majorOptions = [1, 2, 3];
  const mbtiOptions = [1, 2, 3];

  const handleNicknameChange = (event) => {
    setNickname(event.target.value);
  };

  const handleMajorSelection = (event) => {
    const selectedItems = Array.from(event.target.options)
      .filter((option) => option.selected)
      .map((option) => option.value);
    setSelectedMajors(selectedItems);
  };

  const handleMbtiSelection = (event) => {
    const selectedItems = Array.from(event.target.options)
      .filter((option) => option.selected)
      .map((option) => option.value);
    setSelectedMbti(selectedItems);
  };

  const handleSubmit = () => {
    // Create an object to represent the user data
    const userData = {
      nickname,
      major: parseInt(selectedMajors, 10),
      mbti: parseInt(selectedMbti, 10),
    };
    // const jsonData = JSON.stringify(userData);
  // Set headers for the request
  const headers = {
    'Content-Type': 'application/json'
    // 'Access-Control-Allow-Origin': 'http://localhost:3000', // Replace with your React app's origin
  };
    // Send the user data as a POST request to '/userinfo'
    // using your preferred HTTP client (e.g., axios, fetch API)
    // Replace <YOUR_API_ENDPOINT> with your actual API endpoint
    // and include appropriate headers and body data.
    // For example, using axios:

    axios.post('http://localhost:8080/userinfo', userData, { headers })
      .then((response) => {
        // Handle success response
      })
      .catch((error) => {
        // Handle error response
      });

    // Alternatively, you can navigate to a success page
  };

  return (
    <div>
      <label htmlFor="nickname">Nickname</label>
      <input
        type="text"
        id="nickname"
        value={nickname}
        onChange={handleNicknameChange}
        placeholder="Enter nickname"
      />

      <label htmlFor="major">Major</label>
      <select
        id="major"
        multiple
        value={selectedMajors}
        onChange={handleMajorSelection}
      >
        {majorOptions.map((option) => (
          <option key={option} value={option}>
            {option}
          </option>
        ))}
      </select>

      <label htmlFor="mbti">MBTI</label>
      <select
        id="mbti"
        multiple
        value={selectedMbti}
        onChange={handleMbtiSelection}
      >
        {mbtiOptions.map((option) => (
          <option key={option} value={option}>
            {option}
          </option>
        ))}
      </select>

      <button type="button" onClick={handleSubmit}>
        Submit
      </button>
    </div>
  );
};

export default UserForm;
