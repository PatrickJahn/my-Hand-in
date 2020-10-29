import React, { useEffect, useState } from 'react';
import CountryTable from "./CountryTable";
import Facade from "./countryFacade";
import './App.css';

const App = (props) => {

  const [countries, setCountries] = useState([{name: ""}])
  const [labels, setLabels] = useState([""])
  const [reload, setReaload] = useState(false)


    useEffect(() => {
     loadData()
      setInterval(() => {
        loadData()
      }, 3000);
    },[])

    function loadData(){
      Facade.getLabels((data) => {setLabels([...data])})
      Facade.getCountries((data) => {setCountries([...data])})
  
    }
    

    return (
      <div>
        <div className="App-header">
          <h2>React, State, Fetch</h2>
        </div>
        <div className="App-intro">
          <p>Your initial task is to fetch data from the server (see exercise for how to start it),
           and create a table below, with these data</p>          
          <CountryTable countries={countries} labels={labels}/>
        </div>
      </div>
    );
};


export default App;
