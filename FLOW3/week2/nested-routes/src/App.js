import logo from './logo.svg';
import './App.css';
import NRouting from './routing'
import  './style2.css';


function App({info}) {
  return (
    <div className="App">
    <NRouting info={info}/>
    </div>
  );
}

export default App;
