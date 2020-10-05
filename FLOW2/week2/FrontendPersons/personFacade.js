
let URL = "https://patrickcph.dk/Persons/api/person/"

function getAll(){
   return fetch(URL + "all")
    .then(res => res)
}


function addPerson(user){
    const options = makeOptions("POST", user)
    return fetch(URL + "add")
    .then(res => fetchWithErrorCheck(res))
}

// Nedestående kan bruges når fx laver POST request
function makeOptions(http_method, body) {
    var options =  {
      method: http_method,
      headers: {
        "Content-type": "application/json"
      }
    }
    if(body){
      options.body = JSON.stringify(body);
    }
    return options;
   }

   function fetchWithErrorCheck(res){
    if(!res.ok){
      return Promise.reject({status: res.status, fullError: res.json() })
    }
    return res.json();
   }
   
   


const personFacades = {
    getAll,
    addPerson
}

export default personFacades;
