import React, { useEffect, useState } from 'react';

function ChatComponent_2() {
  const [sockets, setSockets] = useState([]);
  const [messages, setMessages] = useState([]);
  const [inputValue, setInputValue] = useState('');
  const [nickname, setNickname] = useState('');
  const [tonickname, setToNickname] = useState('');
  const [isConnected, setIsConnected] = useState(false);

  const createWebSocket = () => {
    const newSocket = new WebSocket(`ws://localhost:8080/IndividualChat?nickname=${nickname}`);

    newSocket.onopen = () => {
      console.log('WebSocket connection established');
      setIsConnected(true);
    };

    newSocket.onmessage = (event) => {
      console.log('Received message:', event.data);
      const message = event.data;
      setMessages((prevMessages) => [...prevMessages, message]);
    };

    newSocket.onclose = () => {
      console.log('WebSocket connection closed');
      setIsConnected(false);
    };

    return newSocket;
  };

  const handleNicknameSubmit = () => {
    if (nickname.trim() === '') {
      return;
    }

    const newSocket = createWebSocket();
    setSockets([newSocket]);
  };

  const sendMessage = () => {
    if (!inputValue.trim()) {
      return;
    }

    const message = {
      from: nickname,
      to: tonickname,
      text: inputValue,
    };

    sockets.forEach((socket) => {
      if (socket.readyState === WebSocket.OPEN) {
        socket.send(JSON.stringify(message));
      }
    });

    setInputValue('');
  };

  return (
    <div>
      <input
        type="text"
        value={nickname}
        onChange={(e) => setNickname(e.target.value)}
        placeholder="Enter your nickname"
      />
      {!isConnected && (
        <button onClick={handleNicknameSubmit}>Connect</button>
      )}
      {isConnected && (
        <input
          type="text"
          value={tonickname}
          onChange={(e) => setToNickname(e.target.value)}
          placeholder="Enter recipient's nickname"
        />
      )}
      <div>
        {messages.map((message, index) => (
          <div key={index}>
            {tonickname} : {message.text}
          </div>
        ))}
      </div>
      <input
        type="text"
        value={inputValue}
        onChange={(e) => setInputValue(e.target.value)}
      />
      <button onClick={sendMessage}>Send Message</button>
      
    </div>
  );
}

export default ChatComponent_2;