import logo from './logo.svg';
import './App.css';
import Form from './FormDemo'
import FormMultiple from './FormDemoMultiple'
import LiftDemo from './LiftingStateUp'
import { useState } from 'react';





function App(props) {
  const [app, setapp]= useState("Form");

  function Toshow() {

    switch (app){
      case "Form":
        return <Form />;
        
      case "FormM":
        return <FormMultiple/>;

        case "LiftingState":
          return <LiftDemo/>;

        default: 
        return <Form />;
    }
  }

  return (
    <div>
      <a href="#" onClick={() => {setapp("Form")}}>Form</a>
      <a href="#" onClick={() => {setapp("FormM")}}>Form-Multiple</a>
      <a href="#" onClick={() => {setapp("LiftingState")}}>LiftingState</a>
     <Toshow/>
    </div>
    
  )
}

export default App;
