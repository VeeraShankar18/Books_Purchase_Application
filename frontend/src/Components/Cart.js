import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

function Cart() {

  const [cart,setCart]=useState([])

  function loadWishlist()
  {
    axios.get('http://localhost:9090/cart/getAll').then(res=>{setCart(res.data)}).catch(err=>{console.log(err)})
  }

  useEffect(()=>
  {
    loadWishlist()
  },[])

  const handleRemove=(bookId)=>
    {
      axios.delete(`http://localhost:9090/cart/delete/${bookId}`)
      .then(res=>
        {
          loadWishlist()
          console.log(res)
        })
      .catch(err=>
        {
          console.log(err)
        })
    }

  return (
    <div className='bg-dark text-light'>
      <div className='navbar pt-4'>
            <Link className='ms-4 me-auto btn btn-primary text-dark' to='/'>Back to Home</Link>
            <Link className='btn btn-info text-dark me-4' to='/wishlist'>Wish List</Link>
            <Link className='btn btn-success text-dark me-4' to='/myorders'>My Orders</Link>
        </div>
      <div className='fluid-container'>
        <h1 className='text-center mb-5'><b>Cart Items</b></h1>
        <div className='mainDiv'>
          {
            cart.map(data=>(
              <div className='cdiv w-25 rounded-5 text-center p-4'>
                <h3><b>{data.bookName}</b></h3>
                <img src={data.bookImg} className='wlimg mt-4 mb-4'/>
                <h4><b>Author: </b>{data.bookAuthor}</h4>
                <h2><b>Price: </b>{data.bookPrice}</h2>
                <Link className='btn btn-warning mt-3' to={`/address/${data.bookId}`}>Buy</Link>
                <button className='btn btn-danger ms-4 mt-3' onClick={()=>handleRemove(data.bookId)}>Remove</button>
              </div>
            ))
          }
        </div>
      </div>
    </div>
  )
}

export default Cart
