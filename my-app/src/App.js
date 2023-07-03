import './App.css';
import UserForm from './UserForm';
import PartnerForm from './PartnerForm';
import ChatComponent from './chat';

const App = () => {
  return (
    <div>
      <UserForm />
      <PartnerForm />
      <ChatComponent />
    </div>
  );
};

export default App;
