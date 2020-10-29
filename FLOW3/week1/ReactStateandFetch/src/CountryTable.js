import React, { useEffect, useState } from "react";
import Facade from "./countryFacade"

const CountryTable = (props) => {

  const {countries, labels } = props
    
  const [sortedCountries, setSortedCountries] = useState()
    
  
  
    const MakeThead = () => {
    
        const thead = labels.map((l)=>{
            return <th key={l} onClick={()=> {sortCountries(formatLabel(l.toLowerCase()))}}>{l}</th>
                   
        })
        return thead;
    }

    const MakeTbody = () => {
      const arr = sortedCountries ? sortedCountries : [...countries]
      const tbody = arr.map((c, index)=>{
       return (<tr key={c.name}>{labels.map((l)=>{
       let  s = formatLabel(l.toLowerCase());
       let td = checkForArray(c[s])
          return <td>{td}</td>
                })}</tr> 
              )          
      })
      return tbody;
  }

  function sortCountries(name){
        const arr = [...countries]
        arr.sort((c1, c2)=>{return c1[name] > c2[name]})
        setSortedCountries([...arr])
  }
    


    
    return (
      <div>
      <p>Replace the thead section with a row generated from the Labels endpoint</p>
      <p>Replace the tbody section with rows generated from the countries endpoint</p>
      <table className="table">
        <thead>
          <tr><MakeThead/></tr>
        </thead>
        
        <tbody>
         <MakeTbody/>
        </tbody>
      </table>
      </div>
    );
};
export default CountryTable;

function checkForArray(obj) {
  let newObj = obj;

  if (Array.isArray(obj) && obj.length > 1){
    newObj = obj[0] + " (+" + obj.length+")";;
  }
  return newObj 
}

function formatLabel(s) {
  s.toLowerCase();
  if (s === "time zones") {
    s = "timezones";
  } else if (s === "tl-domain") {
    s = "topLevelDomain";
  }
  return s;
}


