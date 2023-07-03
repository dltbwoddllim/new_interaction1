import React, { useEffect, useRef } from 'react';

function ChatComponent() {
  const socketRef = useRef(null);

  useEffect(() => {
    // Create a new WebSocket connection
    socketRef.current = new WebSocket('ws://localhost:8080/chat');

    // Connection established event
    socketRef.current.onopen = () => {
      console.log('Connection established');
    };

    // Message received event
    socketRef.current.onmessage = (event) => {
      const message = event.data;
      console.log(`Received message: ${message}`);
    };

    // Connection closed event
    socketRef.current.onclose = () => {
      console.log('Connection closed');
    };

    return () => {
      // Clean up the WebSocket connection on component unmount
      socketRef.current.close();
    };
  }, []);

  // Function to send a message to the server
  const sendMessage = (message) => {
    socketRef.current.send(message);
  };

  // Example usage: send a message to the server
  useEffect(() => {
    sendMessage('Hello, server!');
  }, []);

  return (
    <div>
      {/* Your chat component UI */}
    </div>
  );
}

export default ChatComponent;
