import React from "react"
import PropTypes from 'prop-types';

export default function AllPersons(props) {
  const { persons,editPerson,deletePerson} = props;
      const personList = persons.map((p) => {
      return (<tr key={p.id}>
            <td>{p.age}</td>
            <td>{p.name}</td>
            <td>{p.gender}</td>
            <td>{p.email}</td>
            <td>
            <a onClick={() => {deletePerson(p.id)}}>delete</a> / 
            <a onClick={() => {editPerson(p)}}> edit</a> 
            </td>
            </tr>);
      })
  
  return (
    <div>
      <table className="table">
        <thead>
          <tr><th>Age</th><th>Name</th><th>Gender</th><th>Email</th></tr>
        </thead>
        <tbody>
          {personList}
        </tbody>
      </table>
      
      <p>Please make me show all persons in the table above</p>
      <p>Also, update me when new items are added/edited </p>
      
    </div>
  )
}

AllPersons.propTypes = {
  persons : PropTypes.array.isRequired,
  editPerson: PropTypes.func.isRequired,
  deletePerson: PropTypes.func.isRequired
}
