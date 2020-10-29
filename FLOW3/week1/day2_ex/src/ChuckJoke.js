import { useEffect, useState } from "react";



export default function GetChuckNorris(){

  var [joke, setJoke] = useState("Loading...");
  var [dadjoke, setDadjoke] = useState("Loading...");
  var [g, setJokeGetter] = useState(false);
  var [dad, setdadGetter] = useState(false);


  useEffect(()=> {
    fetch("https://api.chucknorris.io/jokes/random")
    .then(response => response.json())
    .then(data => {
     setJoke(data.value)
      } );
  },[g])


 useEffect(() => {

   function getDadJoke(){ fetch("https://icanhazdadjoke.com/", {
        "headers": {
         'Accept': 'application/json'
        }
     })
     .then(response => response.json())
     .then(data => {
      setDadjoke(data.joke)
       });

    }

    const interval = setInterval(() => {
        getDadJoke();
    }, 10000);
    
    return () => {
        clearInterval(interval)
    }
  })
    


 

  
    return (
      <div>
      <h2>Chuck Norris Joke: <button onClick={() => {setJokeGetter(!g)}}>Get new joke</button> </h2>
      <h3>{joke}</h3>
      <h2>Dad Joke: </h2>
    <h3>{dadjoke}</h3>
      </div>
    )
}