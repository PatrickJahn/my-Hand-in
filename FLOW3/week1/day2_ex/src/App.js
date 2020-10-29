import logo from './logo.svg';
import './App.css';
import {useEffect, useState } from 'react';
import Counter from './counter';
import Chuck from './ChuckJoke';
import ListDemo from './ListDemo';



var number = 1;
 if (localStorage.getItem("count") != null) {
  number = localStorage.getItem("count")
 }

function App() {
  const [app, setapp]= useState("Counter");

  function Toshow() {

    switch (app){
      case "Counter":
        return <Counter factor={1} numb={1}/>;
        
      case "Chuck":
        return <Chuck/>;

        case "List":
          return <ListDemo/>;

        default: 
        return <Counter factor={1} numb={1}/>;
    }
  

  
  }


  return (
   <div  id="App">
     <a href="#" onClick={()=> {setapp("Counter")}}>Counter </a>
     <a href="#" onClick={()=> {setapp("Chuck")}}>Chuck </a>
     <a href="#" onClick={()=> {setapp("List")}}>List </a>
     <br></br>
     <br></br>
      <Toshow />
   </div>
  );
}








export default App;
