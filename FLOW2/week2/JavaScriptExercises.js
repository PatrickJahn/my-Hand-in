

/** ---------- Exercise 1 and 2 ---------- **/

console.log("---------- Exercise 1 and 2 ---------- ");

/* a) Using the filter method */

const myArray = ["Hassan", "Jan", "Peter","Boline","Frederik", "Ulla", "Jørgen"];
let filteredArray = [];
let filteredArray2 = [];
let filteredArray3 = [];

// Using lambda expression:
filteredArray = myArray.filter(element => element.includes("a"));
console.log(filteredArray);

// Using a function
function filterFunc(element){
    return element.includes("a"); 
}
filteredArray2 = myArray.filter(filterFunc);
console.log(filteredArray2);


// Using callback function 
const my_callback = function(element){
    return element.includes("a");
}

function myFilter(array, callback){
    return array.filter(callback)
}

filteredArray3 = myFilter(myArray, my_callback)
console.log(filteredArray3);



/* b) Using the map method */
const myArray2 = ["Hassan", "Jan", "Peter","Boline","Frederik", "Ulla", "Jørgen"];
let mappedArray = [];
let mappedArray2 = [];
let mappedArray3 = [];

// Using lambda expression
mappedArray = myArray2.map(element => element.split("").reverse().join("")); // Splitter hver element i arrayet op i et nyt array med hvert bogstav for så at reverse det array og joine det tilbage til en String
console.log(mappedArray);


// Using a function
 mappedArray2 = myArray2.map( function(element){
    return element.split("").reverse().join("");
 })
 console.log(mappedArray2);

 // Using callback function 
const my_callback2 = function(element){
    return element.split("").reverse().join("");
}

function myMap(array, callback){
    return array.map(callback)
}

mappedArray3 = myMap(myArray2, my_callback2)
console.log(mappedArray3);




    /** ---------- Exercise 3 ---------- **/
console.log("---------- Exercise 3 ---------- ");
// MAP AND FILTER 

  /* a) */
console.log("\n");
console.log("a)");
const numbers = [1, 3, 5, 10, 11];
let mappedNumbers = [];
// Map to get result = [4,8,15,21,11];

const my_callback3 = function(element, index, arr){
    if (index < arr.length - 1){
    return element + arr[index + 1]
    }
    return element
}


mappedNumbers = numbers.map(my_callback3);
console.log(mappedNumbers);

/* b) */
console.log("\n");
console.log("b)");

let navi = "<nav> \n";
const names = ["Hassan", "Jan", "Peter","Boline","Frederik", "Ulla", "Jørgen"]

navi += names.map(element => "<a href\"\">"+element+"</a>").join("\n") + "\n</nav>";
console.log(navi);

/* c) */
// Make two column table of persons data
console.log("\n");
console.log("c)");

let persons = [{name:"Hassan",phone:"1234567"}, {name: "Peter",phone: "675843"}, {name: "Jan", phone: "98547"},{name: "Boline", phone: "79345"}];

var table = "<table>\n<tr><th>Name</th><th>Phone</th></tr>\n";
table += persons.map(element => "<tr><td>"+element.name+"</td><td>"+element.phone+"</td></tr>").join("\n") + "\n</table>";
console.log(table)


    /** ---------- Exercise 4 ---------- **/
    console.log("---------- Exercise 4 ---------- ");
    // REDUCE

    /* a) */
console.log("\n");
console.log("a)");
const names2 = ["Hassan", "Jan", "Peter","Boline","Frederik", "Ulla", "Jørgen"]
let reducedToString = names2.join("#");
console.log(reducedToString);


    /* b) */
    console.log("\n");
    console.log("b)");
    let numbers2 = [2, 3, 67, 33]; 

    const reduceCallback = function(total, numb){
        return total + numb;
    }
    let reducedToSum = numbers2.reduce(reduceCallback);
    console.log(reducedToSum)


    /* c) */
    console.log("\n");
    console.log("c)");
// Return sum of age
    var members = [
        {name : "Peter", age: 18},
        {name : "Jan", age: 35},
        {name : "Janne", age: 25},
        {name : "Martin", age: 22}]

        const reduceCallback2 = function(total, member, index, arr){
            
            if (index == arr.length - 1){
                
            return (total + member.age) / arr.length
            }
         return total+member.age

        }
let ageSum = members.reduce(reduceCallback2, 0)
console.log(ageSum)

 /* d) */
 console.log("\n");
 console.log("d)");

 const votes = [ "Biden","Trump","Biden","Biden","Trump","Trump","Biden","None"];

 
 function reduceCallback3(total, name, index, arr){

    if (index == 1){
        let first = total
        total = {}
        total[first] = 1
    } else {
        if (total[name]){
            total[name] += 1
        } else {
            total[name] = 1
        }
    }

    return total;
 }
 // Bedre måde at gøre det på:
let ress = votes.reduce((accu, candidate) => {
    accu[candidate] = accu[candidate] ? accu[candidate] + 1 : 1;
    return accu
})

 console.log(votes.reduce(reduceCallback3))
 console.log(ress)





    /** ---------- CHALLENGES ---------- **/
    console.log("---------- CHALLENGES ---------- ");


    /* Challange 1 */

    let car = {make: "volvo", year: 2011}
console.log(car) //1

let carCopy = {... car}; // Dette er det samme som at skrive {make: "volvo", year: 2011}
console.log(carCopy) //2

carCopy.year = 2018;

console.log(car) //3
console.log(carCopy) //4



    /* Challange 2 */
var numbers3 = [1, 3, 5, 10, 11];

function makeListItem(number) {
  return `<li>${number}</li>`
}

function myMap(data,array){
    let list = [];
    for (n in data){
    list.push(array(n))
    }
    return list;
}

//let listItems = numbers.map(makeListItem); I don’t exist :-( 
let listItems = myMap(numbers3,makeListItem)
console.log(listItems)


   /* Challange 3 */


 let numbers4 = [1, 3, 5, 10, 11];

function makeListItem(number) {
  return `<li>${number}</li>`
}

listItems = numbers4.map(makeListItem).join("\n")
//console.log(listItems)

listItems = numbers4.map(function (number) {
  return `<li>${number}</li>`
}).join("\n")
//console.log(listItems)

listItems = numbers4.map(number => `<li>${number}</li>`).join("\n")
//console.log(listItems)

listItems = numbers4.map(number => {
 return `<li>${number}</li>`
}).join("\n")
//console.log(listItems)

/* Den første gør det mere overskuligt at se hvad map funktionen gør. 
Den anden kan jeg mindst lide.. 
Den tredje ville jeg bruge hvis det var en lille ændring der skulle laves som der bliver gjort.
Den fjerde manglede et return.

*/ 


 /* Challange 4 */

 var members2 = [
    { name: "Peter", age: 14, gender : "male" },
    { name: "Jan", age: 35, gender : "male" },
    { name: "Janne", age: 25,  gender : "female" },
    { name: "Martin", age: 22, gender : "male" }]
  
  const tableRows = members2.map(member => `
  <tr>
  <td>${member.name}</td>
  <td>${member.age}</td>
  <td>${member.gender}</td>
  </tr>
  `).join("\n")

  console.log(tableRows)


   /* Challange 5 */

   let name2 = { name: "Peter", age: 14, gender: "male" }

//https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/entries
function printObjectDetails(obj) {
  const count = Object.keys(obj).length //get the then number of properties
  console.log(`This object has ${count} properties`)
  console.log("Keys and Values for the object are: ")
  
      for (key in obj){
        console.log(key + " : "+ obj[key])
      }
     
  
}
printObjectDetails(name2)


  /* Challange 6 */
  let peter= { name: "Peter", age: 14, gender: "male" }

function addMayDriveProperty(member) {
   let res = {... member}
    if(res.age < 18){
        res["mayDrive"] = false 
    } else{
        res["mayDrive"] = true 
    }
 return res
}
const addJustedMember = addMayDriveProperty(peter)
console.log(addJustedMember)
console.log(peter)


   /* Challange 7 */
function addMayDrivePropertyToAll(member) {
    // Bruger forrige challanges function som callback i map functionen
    return member.map(addMayDriveProperty)
   }
   const addJusted = addMayDrivePropertyToAll(members);
   console.log(members)
   console.log(addJusted)


   

  /* Challange 8 */
  //var members = [...... Taken from the previous challenges
    function removeGenderOnAll(member) {
        
      return member.map(element => {
            let res = {... element}

          delete res.gender
        return res
        })
    }
    
    const addJusted2 = removeGenderOnAll(members2);
    console.log(members2)
    console.log(addJusted2)
    



