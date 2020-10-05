
let URL = "https://patrickcph.dk/Persons/api/person/"
const tableBody = document.getElementById("tableBody");

const reloadBtn = document.getElementById("reloadBtn");


const addBtn =document.getElementById("addBtn");
addBtn.addEventListener("click", addNewPersonToDB)

reloadBtn.addEventListener("click", getAllPersons)


function getAllPersons(){
    fetch((URL + "all"))
    .then(res => res.json())
   .then(data => {
       console.log(data)
      let body = data["all"].map(person => `<tr><td>${person.id}</td>`+
                           `<td>${person.firstName}</td>` + 
                           `<td>${person.lastName}</td>` +
                           `<td>${person.phone}</td>` +
      `<td><a href="#" class="btndelete" id="${person.id}">delete</a> / <a href="#" class="btnedit" id="${person.id}">edit</a> </td></tr>`
                                    ).join("");
          tableBody.innerHTML = body                          
   let deleteBtns = document.getElementsByClassName("btndelete");

   for (var i = 0; i < deleteBtns.length; i++) {
    deleteBtns[i].addEventListener('click', deletePerson, false);
    
}
   
    }).catch(err => {
        console.log(err)
    }) 
}

getAllPersons()


function addNewPersonToDB(){
    let newPerson = {
         firstName : document.getElementById("fname").value,
     lastName : document.getElementById("lname").value,
     phone : document.getElementById("fphone").value
    }
  
    const options = makeOptions("POST", newPerson)
    fetch(URL + "add", options)
    .then(res => fetchWithErrorCheck(res))
    .then(data => console.log("Added this person " + newPerson))
    .catch(err => {
        if (err.status) {
          err.fullError.then(e =>  console.log(e.msg))
        } else {
       console.log( "Network Error")
        }
      })

}



function deletePerson(event){
  
    let id = event.target.id
    console.log(id)
    let options = makeOptions("DELETE")
    let deleteURL = (URL + "delete/" + id)
    fetch(deleteURL, options)
    .then(res => res.json())
    .then(data => {
        console.log(data)
        getAllPersons()
    }).catch(err => console.log(err))
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
   
