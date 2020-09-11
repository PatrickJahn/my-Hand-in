/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.getElementById("form1").addEventListener('click', getInfo);

  function getInfo(){
    var url = "https://jsonplaceholder.typicode.com/users/";
    if (event.target.id !== "fid"){
    event.preventDefault();
    
    var sub2 = false;
     if (event.target.id !== "sub2"){
  var id = document.getElementById("fid").value;
  url += id;
     } else {
         sub2 = true;
     }
fetch(url)
  .then(res => res.json()) //in flow1, just do it
  .then(data => {
   // Inside this callback, and only here, the response data is available
   console.log("data",data);
  /* data now contains the response, converted to JavaScript
     Observe the output from the log-output above
     Now, just build your DOM changes using the data*/   
              if (!sub2){
           document.getElementById("dd").innerHTML = createHtmlById(data);
              } else {
                document.getElementById("dd").innerHTML = createHtmlForAll(data);
              }
     
});


    }

    
   
}


var createHtmlById = function(json){
    var html = "<p> Name: " + json.name + "<br>"+
            "Phone: " + json.phone + "</p> "+
            "<p><b>Adress</b> <br>" +
            "Street: " + json.address.street + "<br>"+ 
              "City: " + json.address.city + "<br>"+
              "Zip: " + json.address.zipcode + "<br>"+
              "Geo (lat,lng): " + json.address.geo.lat + ", " + json.address.geo.lng+ "<br>"+
            "</p>";
                
    return html;
};

var createHtmlForAll = function(json){
    // Using bad string builder... 
     var genHtml = "";
    for (obj in json){
   var res =  genHtml.concat("<tr><td>"+json[obj].name+"</td>"+
                "<td>"+json[obj].phone+"</td></tr>"); 
    genHtml = res;
    }
    
     var table ="<table><thead><tr><th>Name</th><th>Phone</th><tbody>" + genHtml + "</tbody></table>" ;
     
    return table;
};


