 import {persons} from "./file2";
 import PropTypes from 'prop-types';
 
 function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}


function WelcomePerson(props){
    const {person} = props;
    return <h1>Hello, {person.firstName} {person.lastName}, {person.email}</h1>; 
}


WelcomePerson.propTypes = {
   person: PropTypes.shape({
    firstName: PropTypes.string.isRequired,
    lastName: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired
   })
}


export function MultiWelcome() {
  return (
    <div>
      <Welcome name="Sara" />
      <Welcome name="Patrick" />
      <Welcome name="Edith" />

      {persons.map((person)=><WelcomePerson key={person.email}person={person} />)}

    </div>
  );
}
