import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';

import UserComponent from './component/UserComponent';
import ReturnComponent from './component/ReturnComponent';
function App() {
  return (
      <Router>
    <div className="App">
    
        <Routes>
          
          <Route exact path="/return" element={<UserComponent/>}></Route>
          <Route exact path="" element={<ReturnComponent/>}></Route>
        </Routes>

        </div>
 
</Router>
  );
}

export default App;
