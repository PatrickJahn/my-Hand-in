

import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from "react";

import {
  BrowserRouter as Router,
  Prompt
} from "react-router-dom";

function AddBook({bookFacade}){

    const emptyBook = {id: "", title: "", info: ""};
    const [book, setBook] = useState({...emptyBook});
    const [isBlocking, setIsBlocking] = useState(false);
    
    const handleChange = (evt) => { 
      const {name, value} = evt.target;
      setBook({...book,[name]:value})
      setIsBlocking(value.length > 0)
     
    }
    function handleSubmit(evt){
      evt.preventDefault()
     bookFacade.addBook(book)
      setBook({...emptyBook})
      setIsBlocking(false)
    }
    


return (<div><h3>Add book</h3>
<form onSubmit={handleSubmit}>
<Prompt
      when={isBlocking}
      message={location =>
        `Are you sure you want to go to ${location.pathname}`
      }
    />

    <p>
      Blocking?{" "}
      {isBlocking ? "Yes, click a link or the back button" : "Nope"}
    </p>
    <input type="text"
           name="title" 
          value={book.title}
          placeholder="Title"
          onChange={handleChange }/>
              <br></br>
    <input type="text" 
            name="info"
            value={book.info}
           placeholder="Info" 
           onChange={handleChange}/>
    <br></br>
    <button type="submit" >Save</button>
    </form>
  </div>)
}


function FindBook({bookFacade}){
    const emptyBook = {id:"", title:"", info:""}
    const [bookID, setBookID] = useState();
    const [book, setBook] = useState({...emptyBook});

    function handleChange(evt){
        setBookID(evt.target.value)
    }

    function handleSubmit(evt){
    evt.preventDefault()
        const foundBook = bookFacade.findBook(bookID)
        setBook(foundBook ? {...foundBook}  : {title:"No book found"})
       
    }

    const callback = () => {setBook({title:"Book now deleted"})}


    return (<div>
            <form onSubmit={handleSubmit}>
             <h3>Find book</h3>
                <input placeholder="Id"
                type="number"
                name="id"
                value={bookID}
                onChange={handleChange}
                        />
                <button type="submit">Find</button>
            </form>
            <Detail book={book} bookFacade={bookFacade} callback={callback}/>
           </div>)
}

function Detail({book, bookFacade, callback}){

  if (book.title == "No book found"){
    return (<div className="detailsBox" id="dtail">
          <h4>Title: {book.title}</h4>
          <h4>Id: {book.id}</h4>
          <h4>Info: {book.info}</h4>
       </div>)
  }


      function handleDelete(){
        bookFacade.deleteBook(book.id)
        callback()
      }


 
    return (<div className="detailsBox" id="dtail">
          <h4>Title: {book.title}</h4>
          <h4>Id: {book.id}</h4>
          <h4>Info: {book.info}</h4>
          <button onClick={handleDelete}>Delete book</button>
       </div>)
     
  }



export {AddBook, FindBook}



