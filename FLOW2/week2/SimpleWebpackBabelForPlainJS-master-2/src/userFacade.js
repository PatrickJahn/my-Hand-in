
const URL = "http://localhost:3333/api/users/";



function getUsers(){
    return fetch(URL)
    .then(res => res.json());
}

function getUser(id){
    return fetch(URL + id)
    .then(res => fetchWithErrorCheck(res));
}

function addUser(user){
    const options = makeOptions("POST", user)
    return fetch(URL, options)
    .then(res => fetchWithErrorCheck(res));
    
}

function editUser(user){
    const options = makeOptions("PUT", user)
    return fetch(URL + user.id, options)
    .then(res => fetchWithErrorCheck(res));
}

function deleteUser(id){
    const options = makeOptions("DELETE")
    return fetch(URL + id, options)
    .then(res => fetchWithErrorCheck(res));
    
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
   


const userFacade = {
    getUsers,
    getUser,
    addUser,
    editUser,
    deleteUser
}

export default userFacade;