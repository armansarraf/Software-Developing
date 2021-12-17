
import React, { Component } from 'react'
import { useState } from 'react'
import './App.css';


function App() {
  const [data, setData] = useState("");
  const [print, setPrint] = useState(false);

  function increment() {
    setData(parseInt(data) + 1)

  }
  function decrement() {
    setData(parseInt(data) - 1)
  }

  function getData(event){
    setData(event.target.value)
    setPrint(false)
    }

  return (
    <div class="container">
      <div><p> This is the number : {print?<strong>{data}</strong> :<strong>0</strong> }</p></div>
      <input id="inputNumber" type="number"  onChange={getData} />
      <button id="submit" onClick={(e) => setPrint(true)}>Submit </button>
      <br />
      
      <button onClick={decrement} class="button" id="decrement" >Down</button>
      <button onClick={increment} class="button" id="increment" >Up</button>
    </div>
  );
}

export default App;