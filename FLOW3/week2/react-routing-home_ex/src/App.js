import './App.css';
import React, { useEffect, useState } from "react";
import {AddBook, FindBook, DeleteBook} from './bookComponents'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  NavLink,
  useRouteMatch,
  useParams,
  Prompt
} from "react-router-dom";

function App({bookFacade}) {

const [loggedin, setLoggedin] = useState(false);

const handleLogin = () => {
  setLoggedin(!loggedin)
}
  

  return (
    <div>
    <Header loggedin={loggedin} />
    <Switch>
      <Route exact path="/">
        <Home />
      </Route>
      <Route path="/products">
        <Products bookFacade={bookFacade}/>
      </Route>
      <Route path="/products">
        <Products bookFacade={bookFacade}/>
      </Route>
      <Route path="/company">
        <Company />
      </Route>
      <Route path="/add-book">
        <AddBook bookFacade={bookFacade} />
      </Route>
      <Route path="/find-book">
        <FindBook bookFacade={bookFacade} />
      </Route>
      <Route path="/login">
        <Login callback={handleLogin} loggedin={loggedin}/>
      </Route>
      <Route >
        <NoMatch />
      </Route>
    </Switch>
  </div>
  
  );
}

function Header({loggedin}){

    useEffect(() => {
      if (loggedin == true){
        document.getElementById("addbook").style.display = "none"
        document.getElementById("findbook").style.display = "none"

      } else{
        document.getElementById("addbook").style.display = "block"
        document.getElementById("findbook").style.display = "block"

      }
    }, [loggedin])

  return (<ul className="header">
  <li><NavLink exact activeClassName="active" to="/">Home</NavLink></li>
  <li><NavLink activeClassName="active" to="/products">Products</NavLink></li>
  <li id="addbook"><NavLink activeClassName="active" to="/add-book">Add Book</NavLink></li>
  <li id="findbook"><NavLink activeClassName="active" to="/find-book">Find Book</NavLink></li>
  <li><NavLink activeClassName="active" to="/company">Company</NavLink></li>
  <li><NavLink activeClassName="active" to="/login">Login</NavLink></li>
</ul>
  )
}

function Home(){
  return (<div> <h3>Home</h3></div>)
}

function Products({bookFacade}){

  const { path, url } = useRouteMatch();
  const books = bookFacade.getBooks();

  const ulListe = books.map((b) => {
    return <li key={b.id}>{b.title} <NavLink activeClassName="false" to={url + '/' + b.id} >details</NavLink></li>})

  return ( <div>
          <h3>Products</h3>
         <ul>{ulListe}</ul>
         <Switch>
        <Route path={`${path}/:id`}>
          <Detail bookFacade={bookFacade} />
        </Route>
      </Switch>
         </div>
    )

}

function Detail({bookFacade}){
  let { id } = useParams();
  let book = bookFacade.findBook(id);
  return (<div className="detailsBox">
        <h4>Title: {book.title}</h4>
        <h4>Id: {id}</h4>
        <h4>Info: {book.info}</h4>
     </div>)
}
function Company(){
  return (<div> <h3>Company</h3></div>)
}


function Login({callback, loggedin}){

  let option = loggedin ? "Login" : "Logout"

  return (<div> <h3>Login</h3> <button onClick={callback}>{option}</button></div>)
}



function NoMatch(){
  return (<h3>This path leads to absolutely nothing</h3>)
}

export default App;
