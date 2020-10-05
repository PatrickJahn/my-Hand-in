
let URL = "https://patrickcph.dk/devops-starter/api/movie/all"


let btn = document.getElementById("getBtn");
btn.onclick = function(){

fetch(URL)
.then(res=> res.json())
.then(data => {
    console.log(data)
const table = document.getElementById("tbody");
data.map(movie => 
    table.innerHTML += `<tr><td>${movie.id}</td>
<td>${movie.year}</td>
<td>${movie.title}</td>
<td>${movie.genre}</td>
</tr> `)


})

}



