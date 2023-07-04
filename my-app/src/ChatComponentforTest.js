import React, { useEffect, useState } from 'react';

function ChatComponent() {
  const [sockets, setSockets] = useState([]);

  useEffect(() => {
    // Function to create a new WebSocket connection
    const createWebSocket = () => {
      const newSocket = new WebSocket('ws://localhost:8080/chat');

      newSocket.onopen = () => {
        console.log('WebSocket connection established');
      };

      newSocket.onmessage = (event) => {
        console.log('Received message:', event.data);
      };

      newSocket.onclose = () => {
        console.log('WebSocket connection closed');
      };

      return newSocket;
    };

    // Create 100 WebSocket connections
    const newSockets = Array.from({ length: 100 }, () => createWebSocket());

    // Save the WebSocket instances in state
    setSockets(newSockets);

    // Clean up the WebSocket connections when the component unmounts
    return () => {
      newSockets.forEach((socket) => socket.close());
    };
  }, []);

  const sendMessage = (message) => {
    sockets.forEach((socket) => {
      if (socket.readyState === WebSocket.OPEN) {
        socket.send(message);
      }
    });
  };

  return (
    <div>
      {/* Your chat component UI */}
      <button onClick={() => sendMessage('Hello, server!')}>
        Send Message
      </button>
    </div>
  );
}

export default ChatComponent;
