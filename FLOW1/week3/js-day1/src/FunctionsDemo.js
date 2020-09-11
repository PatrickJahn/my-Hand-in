/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Function Declaration
       //Observe: no return type, no type on parameters
function add(n1, n2){
   return n1 +n2;
}

//Function Expression or anonymois function
var sub = function(n1,n2){
  return n1 - n2;
} 

function mul(n1, n2){
    return n1 * n2; 
}

var div = function(n1,n2){
    return n1/n2;
}


//Callback example
var cb = function(n1 ,n2, callback){
    try {
        if (typeof n1 !== "number" ||typeof n2 !== "number" ){
         throw new Error("n1 or n2 is not a number");
        } 
        if (typeof callback !== "function"){
           throw new Error("callback not a function"); 
        }
    } catch (e){ 
        
        return e.name +" "+  e.message;
    }
  return "Result from the two numbers: "+n1+"+"+n2+"="+callback(n1,n2);
};

console.log( add(1,2) ) ;    // What will this print?
console.log( add );          // What will it print and what does add represent?
console.log( add(1,2,3) ) ; // What will it print
console.log( add(1) );	  // What will it print 	
console.log( cb(3,3,add) ); // What will it print
console.log( cb(4,3,sub) ); // What will it print
console.log(cb(3,3,add())); // What will it print (and what was the problem)
console.log(cb(3,"hh",add));// What will it print
console.log(cb(3,2,mul));
console.log(cb(10,2,div));


/** ARRAY FUNCTIONS    **/

var arr = ["Peter", "Lars", "Ole", "Sanne", "Hans", "Bo"];
var filterdArr = arr.filter(name => name.length <= 3);

console.log("Normal array:")
arr.forEach(name => console.log(name));
console.log("Filtered array:")
filterdArr.forEach(name => console.log(name));

var uppercaseArr = arr.map(name => name.toUpperCase());
console.log(uppercaseArr);

// Array to html list with map and 
var i = 0;
var htmlArr = arr.map(function(name){
    if (i === 0){
            i++;
        return "<ul><li>" + name;
    }
    if (i === arr.length - 1){
            i++;
        return "<li>"+name+"</li><ul>"
    }
    i++;
    return "<li>" +name; 
});
var htmlString = htmlArr.join("</li>");
console.log(htmlString);


/** 4. Filter excercise  */
var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
];

// Cars newer than 1999
var arr1 = cars.filter(car => car.year > 1999);
console.log(arr1);

// Al  Volvo’s
var arr2 = cars.filter(car => car.make === "Volvo");
console.log(arr2);
// All cars with a price below 5000
var arr3 = cars.filter(car => car.price < 5000);
console.log(arr3);


/** 4a  */

var sqlString = cars.map(function(car){
    return "INSERT INTO cars (id,year,make,model,price) VALUES (" + 
            car.id+","+
            car.year+","+
            "'"+car.make+"',"+
            "'"+car.model+"',"+
            car.price+");";
            
}).join("\n");
console.log(sqlString);




/** Asynchronous Callbacks  **/
var msgPrinter = function(msg,delay){
  setTimeout(function(){
    console.log(msg);
  },delay);
};
console.log("aaaaaaaaaa");
msgPrinter ("bbbbbbbbbb",2000);
console.log("dddddddddd");
msgPrinter ("eeeeeeeeee",1000);
console.log("ffffffffff");

/*
function Person(name){
  this.name = name;  
  console.log("Name: "+ this.name);
  setTimeout(function(){
    console.log("Hi  "+this.name);  
  }.bind(this),2000);
}

//call it like this (do it, even if you know it’s silly ;-)
Person("Kurt Wonnegut");  //This calls the function
console.log("I'm global: "+ name);  //Explain this

var p = new Person("Kurt Wonnegut");  //Create an instance using the constructor function
console.log("I'm global: "+ name);  //What’s different ?

*/

var greeter = function(){
  console.log(this.message);
};
var comp1 = { message: "Hello World" };
var comp2 = { message: "Hi" };

var g1 = greeter.bind(comp1 );//We can store a reference, with a specific “this” to use
var g2 = greeter.bind(comp2 );//And here another “this”
setTimeout(g1,500);
setTimeout(g2,1000);



function Car(id, year, model, make, price){
    this.id = id; 
    this.year = year;
    this.model = model; 
    this.make = make;
    this.price = price;
}
var car1 = new Car(1, 1992, "x6", "BMW", 200000);

for (val in car1){
    console.log(val, car1[val]);
}

delete car1.price;
// OR delete car1["price"]
console.log(car1);
car1["price"] = 300000;
console.log(car1);


function Person(firstname, lastname, age){
    var privname = firstname +" "+ lastname;
    var privAge = age;
    
   
    return {
        getInfo: function(){
           return privname + " age: " + privAge},
         setName: function(name){privname = name },
         setAge: function(age){privAge = age }
        }
    }
   
    


var p = new Person("Bo", "Hansen", 58);

console.log(p.getInfo());
p.setName("Dylan");
p.setAge(66);
console.log(p.getInfo());