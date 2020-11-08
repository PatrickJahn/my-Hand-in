import utils from "./utils";
let URL = "http://localhost:8080/jpareststarter/api/";
//The two methods below, are the utility-methods introduced here (use them if you like):
//https://docs.google.com/document/d/1hF9P65v_AJKCjol_gFkm3oZ1eVTuOKc15V6pcb3iFa8/edit?usp=sharing



function apiFacade() {
  //OBSERVE fetchAny takes a url and a callback. The callback handles the data from the response body.
  function getJokes(callback) {
    // Change me to do something with data
     utils.fetchAny(URL + "jokes",callback);
  }

  function getScrape(person, callback) {
    utils.fetchAny(URL + "scrape",callback);
     
  }

 
  
  return {
    getJokes,
    getScrape
  };
}
const returnValue = apiFacade();
export default returnValue;

