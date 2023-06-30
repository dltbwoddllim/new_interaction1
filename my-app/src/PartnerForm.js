import React, { useState } from 'react';
import axios from 'axios';

const PartnerForm = () => {
    const [selectedMajors, setSelectedMajors] = useState([]);
    const [selectedMbti, setSelectedMbti] = useState([]);

    const majorOptions = [1, 2, 3];
    const mbtiOptions = [1, 2, 3];

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
    const handleSubmit = async (e) => {
        e.preventDefault();

        const userData = {
            major: parseInt(selectedMajors, 10),
            mbti: parseInt(selectedMbti, 10),
          };
        const headers = {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:3000/', // Replace with your React app's origin
          };
            // Send the user data as a POST request to '/userinfo'
            // using your preferred HTTP client (e.g., axios, fetch API)
            // Replace <YOUR_API_ENDPOINT> with your actual API endpoint
            // and include appropriate headers and body data.
            // For example, using axios:
        
            axios.post('http://localhost:8080/partner', userData, { headers })
              .then((response) => {
                // Handle success response
              })
              .catch((error) => {
                // Handle error response
              });
    };

    return (
        <form onSubmit={handleSubmit}>
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
        </form>
    );
};

export default PartnerForm;
