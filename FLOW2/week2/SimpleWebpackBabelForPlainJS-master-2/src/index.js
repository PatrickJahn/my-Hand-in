import "./style.css"
import "bootstrap/dist/css/bootstrap.css"
import "./jokeFacade"
import jokeFacade from "./jokeFacade"
import userFacade from "./userFacade"

/* 
  Add your JavaScript for all exercises Below or in separate js-files, which you must the import above
*/

/* JS For Exercise-1 below */

  // Tilføjer alle jokes til liste
const ul = document.getElementById("jokes");
let liste = jokeFacade.getJokes().map(joke => `<li>${joke}</li>`).join("");
ul.innerHTML = liste

const p = document.getElementById("jokeByID");
const findbtn = document.getElementById("findBtn");

  // Finder og tilføjer jokebyId til paragraf
findbtn.onclick = function(){
  let id = document.getElementById("fname").value;
  let foundJoke = jokeFacade.getJokeById(id);
  p.innerHTML = foundJoke
}

  // Tilføjer ny joke til listen
 const p2 = document.getElementById("confP");
 const addBtn = document.getElementById("addBtn");

 addBtn.addEventListener("click", addjoke); // anden måde at tilføje click funtion på
 
 function addjoke(){
  let newJoke = document.getElementById("ftext").value;
  jokeFacade.addJoke(newJoke);
  ul.innerHTML += `<li>${newJoke}</li>`
 
}

//s

/* JS For Exercise-2 below */

const qBtn = document.getElementById("quoteBtn");
let qP = document.getElementById("quoteP");

qBtn.addEventListener("click", hentQuote);

function hentQuote(){
  fetch("https://studypoints.info/jokes/api/jokes/period/hour")
  .then(function(response) {
    return response.json();
  })
  .then(function(data) {
    qP.innerHTML = data.joke;
  })
}

    // Her sætter jeg siden til at hente quote hver time
    window.setInterval(hentQuote, 3600000)
    // tallet er en time angivet i miliseconder

/* JS For Exercise-3 below */


// Get all users functionality here 
let allUserRows = document.getElementById("allUserRows");

userFacade.getUsers()
.then(function(userData){
 let rows = userData.map(user => 
    "<tr>" +
    "<td>" + user.id + "</td>" +
    "<td>" + user.age + "</td>" +
    "<td>" + user.name + "</td>" +
    "<td>" + user.gender + "</td>" +
    "<td>" + user.email + "</td>" +
    "</tr>"
    ).join("");
  allUserRows.innerHTML = rows;
})



// Find user by ID functionality here 

let findByIdBtn = document.getElementById("findBtn3");
let userParagraf1 =  document.getElementById("personByID")

findByIdBtn.onclick = function(){
  let id = document.getElementById("fid").value;
  userFacade.getUser(id)
  .then(function(user){
    userParagraf1.innerHTML = `Name: ${user.name}, age: ${user.age}, gender: ${user.gender}, email: ${user.email}`
  })
  .catch(error => {
    if (error.status) {
      error.fullError.then(e =>  userParagraf1.innerHTML = e.msg)
    } else {
      userParagraf1.innerHTML = "Network Error"
    }
  })

}


// Add user functionality here 

let addBtn2 = document.getElementById("addBtn2");
let addedP =  document.getElementById("addedP");

addBtn2.onclick = function(){
  let addUser = {
     name : document.getElementById("addName").value,
     age : document.getElementById("addAge").value,
   gender :document.getElementById("addGender").value,
   email : document.getElementById("addEmail").value
  }
 
  userFacade.addUser(addUser)
  .then(res => addedP.innerHTML = JSON.stringify(addUser))
  .catch(err => {
    if (err.status) {
      err.fullError.then(e =>  addedP.innerHTML = e.msg)
    } else {
      addedP.innerHTML = "Network Error"
    }
  })
}


// Edit user functionality here 

let editBtn = document.getElementById("editBtn");
let editedP =  document.getElementById("editedP");

editBtn.onclick = function(){
  let editUser = {
      id : document.getElementById("editId").value,
     name : document.getElementById("editName").value,
     age : document.getElementById("editAge").value,
   gender :document.getElementById("editGender").value,
   email : document.getElementById("editEmail").value
  }
 
  userFacade.editUser(editUser)
  .then(res => editedP.innerHTML = JSON.stringify(editUser))
  .catch(err => {
    if (err.status) {
      err.fullError.then(e =>  editedP.innerHTML = e.msg)
    } else {
      editedP.innerHTML = "Network Error"
    }
  })
}


// Delete user functionality here
let deleteBtn = document.getElementById("delBtn");
let delParagaf = document.getElementById("delP");

deleteBtn.onclick = function(){
  let id = document.getElementById("delId").value;
  userFacade.deleteUser(id)
  .then(res => delParagaf.innerHTML = "User with id: " + id + " deleted")
  .catch(err => {
    if (err.status) {
      err.fullError.then(e =>  delParagaf.innerHTML = e.msg)
    } else {
      delParagaf.innerHTML = "Network Error"
    }
  })

}


/* 
Do NOT focus on the code below, UNLESS you want to use this code for something different than
the Period2-week2-day3 Exercises
*/

function hideAllShowOne(idToShow) {
  document.getElementById("about_html").style = "display:none"
  document.getElementById("ex1_html").style = "display:none"
  document.getElementById("ex2_html").style = "display:none"
  document.getElementById("ex3_html").style = "display:none"
  document.getElementById(idToShow).style = "display:block"
}

function menuItemClicked(evt) {
  const id = evt.target.id;
  switch (id) {
    case "ex1": hideAllShowOne("ex1_html"); break
    case "ex2": hideAllShowOne("ex2_html"); break
    case "ex3": hideAllShowOne("ex3_html"); break
    default: hideAllShowOne("about_html"); break
  }
  evt.preventDefault();
}
document.getElementById("menu").onclick = menuItemClicked;
hideAllShowOne("about_html");



