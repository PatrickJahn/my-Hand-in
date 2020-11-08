import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import "./style2.css"
import facade from "./apiFacade"

function App() {
  return (
    <Router>
    <div >
      <ul className="header"> 
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/jokes">Jokes</Link>
        </li>
        <li>
          <Link to="/scrape">Scrape</Link>
        </li>
         <li>
          <Link to="/login">Login</Link>
        </li>
      </ul>

      <hr />

      {/*
        A <Switch> looks through all its children <Route>
        elements and renders the first one whose path
        matches the current URL. Use a <Switch> any time
        you have multiple routes, but you want only one
        of them to render at a time
      */}
      <Switch>
        <Route exact path="/">
      <Home/>
        </Route>
        <Route path="/jokes">
          <Jokes />
        </Route>
        <Route path="/scrape">
        <Scrape />
        </Route>
        <Route path="/login">
        <Login />
        </Route>
      </Switch>
    </div>
  </Router>
);
}

function Home(){
  return (<h3>Home</h3>);
}
function Jokes(){


  const emptyJoke = {joke1: "", joke2: "",joke1reference:"",joke2reference:"" }
  const [jokes, setJokes] = useState(emptyJoke)
  
  function getJokes(){
    facade.getJokes((data) =>{
      setJokes(data)
    } )
    
  }
 
  return (<div>
    <h3>Jokes</h3>
    <h4>Joke1: <p>{jokes.joke1} </p> </h4>
    <h4>Joke2: <p>{jokes.joke2}</p> </h4>
    <h4>Joke1reference: {jokes.joke1Reference} </h4>
    <h4>Joke2reference: {jokes.joke2Reference} </h4>
    <button onClick={getJokes}>Get new jokes</button>
  </div>);
}





function Scrape(){
  return (<div>
    <h3>Scrape</h3>
  </div>);
}

function Login(){
  return (<div>
    <h3>Login</h3>
  </div>);
}
export default App;
