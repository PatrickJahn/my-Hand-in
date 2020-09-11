/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var boys = ["Peter", "lars", "Ole"];
var girls = ["Janne", "hanne", "Sanne"];
var all; 
// The concat() method is used to merge two or more arrays.
all = boys.concat(girls);
console.log(all); // Prints out

var comma;
var hypohen;
// The join() method is used to reduce an array to a single string
comma = all.join(",");
hypohen = all.join("-");
console.log(comma); 
console.log(hypohen);

// Js can add to an array by push (adds to end) or unshift(adds to start)
all.push("Lone", "Gitte");
all.unshift("Hans", "Kurt");
console.log(all); 

// Js can remove from array by pop(removes from end) or shift(removes from start) 
all.shift();
all.pop();
console.log(all);

// The splice() method can remove/add to an array at an index
// all.splice(3,0, "Knud"); To put name at index 3 without removing anything
all.splice(3,2);
console.log(all);

// The reverse() method reverses the array
all.reverse();
console.log(all);

// The sort() method default sorts alphabetic but dosen't handle capitalazions
all.sort();
console.log("Default sort:");
console.log(all);
// Custom sort functions can be used to fix this 
all.sort(function(n1, n2) {
    var nameA = n1.toUpperCase();
    var nameB = n2.toUpperCase();
    if (nameA < nameB) {
    return -1;
  }
  if (nameA > nameB) {
    return 1;
  }
  return 0;
});
console.log("Custom sort:");
console.log(all);

// The map() method retunere et nyt array med de ting du har kaldt på hver
all = all.map(a => a.toUpperCase());
console.log(all);

// The filter() method creates a new array with all elements that pass the test implemented by the provided callback
var filterArr = all.filter(name => name.charAt(0) === "L" || name.charAt(0) === "l");
console.log(filterArr);