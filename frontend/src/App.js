import React from 'react'
import {BrowserRouter as Router,Routes,Route} from "react-router-dom"
import Home from './Components/Home'
import './App.css'
import Wishlist from './Components/Wishlist'
import Cart from './Components/Cart'
import Myorders from './Components/Myorders'
import Address from './Components/Address'

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path='/' Component={Home}></Route>
          <Route path='/wishlist' Component={Wishlist}></Route>
          <Route path='/cart' Component={Cart}></Route>
          <Route path='/myorders' Component={Myorders}></Route>
          <Route path='/address/:bookId' Component={Address}></Route>
        </Routes>
      </Router>
    </div>
  )
}

export default App
