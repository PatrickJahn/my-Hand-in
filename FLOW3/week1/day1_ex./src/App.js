import logo from './logo.svg';
import './App.css';
import upper from "./file1";
import {text1,text2, text3} from "./file1";
import person, {males, females} from "./file2";
import { MultiWelcome } from './file3';
 
const {firstName, email} = person;

const personV2 = person;
personV2.phone = 12345678
personV2.friends = [...males, ...females];

function App() {
  console.log(personV2)
  return (
    <div>
<h2>EX</h2>
    <p>{text1}</p>
    <p>{text2}</p>
    <p>{text3}</p>
    <p>{upper("please uppercase me")}</p>


    <h2>EX2</h2>
  <p>Firstname: {firstName}, Email: {email} </p>
  
  
  <h2>EX3</h2>
    <MultiWelcome/>

    </div>
   

  );
}

export default App;
