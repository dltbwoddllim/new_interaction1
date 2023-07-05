import React, { useEffect, useState } from 'react';

function ChatComponent() {
  const [sockets, setSockets] = useState([]);
  const [messages, setMessages] = useState([]);
  const [inputValue, setInputValue] = useState('');

  useEffect(() => {
    // Function to create a new WebSocket connection
    const createWebSocket = () => {
      const newSocket = new WebSocket('ws://localhost:8080/chat');

      newSocket.onopen = () => {
        console.log('WebSocket connection established');
      };

      newSocket.onmessage = (event) => {
        console.log('Received message:', event.data);
        setMessages((prevMessages) => [...prevMessages, event.data]);
      };

      newSocket.onclose = () => {
        console.log('WebSocket connection closed');
      };

      return newSocket;
    };

    // Create 1000 WebSocket connection
    const newSockets = Array.from({ length: 1000 }, () => createWebSocket());

    // Save the WebSocket instances in state
    setSockets(newSockets);

    // Clean up the WebSocket connections when the component unmounts
    return () => {
      newSockets.forEach((socket) => socket.close());
    };
  }, []);

  const sendMessage = () => {
    if (!inputValue.trim()) {
      return;
    }

    sockets.forEach((socket) => {
      if (socket.readyState === WebSocket.OPEN) {
        socket.send(inputValue);
      }
    });

    setInputValue('');
  };

  return (
    <div>
      <div>
        {messages.map((message, index) => (
          <div key={index}>{message}</div>
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

export default ChatComponent;
