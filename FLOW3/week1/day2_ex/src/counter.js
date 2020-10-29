import {useEffect, useState } from 'react';



export default function Counter({factor, numb}){
    
    const [count, setCount] = useState(numb);
  
    const increment = () => setCount(Number(count) + factor);
      
    const decrement = () => setCount(Number(count) - factor);

    useEffect(() => {
        setCount(localStorage.getItem("count"));
       },[numb]) 

    useEffect(() => {
      localStorage.setItem("count", count);
    },[count])

    
  
    return (
  
      <div>
     <button className='inc' onClick={increment}>Increment!</button>
     <button className='dec' onClick={decrement}>decrement!</button>
      <h1 id="counter">Current Count: {count}</h1>
     </div>
    )
  
  }