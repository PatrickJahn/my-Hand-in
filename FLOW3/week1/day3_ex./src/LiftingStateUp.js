import { useState } from "react";





const AddpersonForm = ({person, changeH,sumbitH }) => {


    
    function handleChange(e) {
        const target = e.target
        const name = target.name;
        const value = target.value
       changeH(value)
    }

    function handleSubmit(e) {
      e.preventDefault();
        sumbitH()
    }
    return (<div id="formdiv">
    <h3>Add person</h3>
      <form >
      <input
          name="name"
          value={person.name}
          onChange={handleChange}
          placeholder="Name"
        />
      <button onClick={handleSubmit}>Add</button>
      </form>

    </div>);
}


const PersonList = ({persons}) => {

    const personlist = persons.map((p, index) => {
        return <li key={index}>{p.name}</li>
    })

    return ( <div id="personsdiv">
    <h3>All persons</h3>
        {personlist}
  </div>);
}

export default function Demo() {
    const initialPersons = [{name:"Kurt"}, {name:"Hans"}]

    
    
     const [persons, setPersons] = useState(initialPersons)
    const [newPerson, setnewPerson] = useState({name:""});
    
   const changeNewPerson = (name) => {
       const person = {...newPerson, name: name}
        setnewPerson(person)
    }
    const submitNewPerson = () => {
        if (newPerson.name == ""){
            alert("No name typed in")
        } else {
            setPersons([...persons, newPerson])
        }
   
     }

    return (
      <div id="outerdiv" style={{marginTop:25}}>
      <PersonList  persons={persons}/>
      <AddpersonForm person={newPerson} changeH={changeNewPerson} sumbitH={submitNewPerson}/>
      </div>
    );
  }
   