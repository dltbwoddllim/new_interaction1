import React, { useState } from 'react';
import axios from 'axios';

const PartnerForm = () => {
    const [selectedMajors, setSelectedMajors] = useState([]);
    const [selectedMbti, setSelectedMbti] = useState([]);
    const [nicknames, setNicknames] = useState([]);
    const [majors, setMajors] = useState([]);
    const [Mbtis, setMbtis] = useState([]);

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

        const headers = {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'http://localhost:3000' // Replace with your React app's origin
        };

        axios.get('http://localhost:8080/partner', {
            headers,
            params: {
                major: parseInt(selectedMajors, 10),
                mbti: parseInt(selectedMbti, 10),
            },
        })
            .then((response) => {
                setNicknames(response.data.map((item) => item.nickname)); // Extract the nicknames from the response data
                setMajors(response.data.map((item) => item.major)); // Extract the nicknames from the response data
                setMbtis(response.data.map((item) => item.mbti)); // Extract the nicknames from the response data
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
            <div>
                <div>
                    {nicknames.map((nickname, index) => (
                        <React.Fragment key={nickname}>
                            <button>{nickname}</button>
                            <span>&nbsp;</span>
                            <button>{Mbtis[index]}</button>
                            <span>&nbsp;</span>
                            <button>{majors[index]}</button>
                            <br />
                        </React.Fragment>
                    ))}
                </div>

            </div>
        </form>
    );
};

export default PartnerForm;
