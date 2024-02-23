import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'

function Wishlist() {

  const [wishlist,setWishlist]=useState([])

  let navigate=useNavigate()

  function loadWishlist()
  {
    axios.get('http://localhost:9090/wishlist/getAll').then(res=>{setWishlist(res.data)}).catch(err=>{console.log(err)})
  }

  useEffect(()=>
  {
    loadWishlist()
  },[])

  const handleCart=(bookId)=>
    {
        axios.get(`http://localhost:9090/wishlist/get/${bookId}`)
        .then(res=>
        {
            axios.post('http://localhost:9090/cart/add',res.data).then(res=>navigate('/cart')).catch(err=>{console.log(err)})
        })
        .catch(err=>
        {
            console.log(err)
        })
    }

    const handleRemove=(bookId)=>
    {
      axios.delete(`http://localhost:9090/wishlist/delete/${bookId}`)
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
            <Link className='btn btn-warning text-dark me-4' to='/cart'>cart</Link>
            <Link className='btn btn-success text-dark me-4' to='/myorders'>My Orders</Link>
        </div>
      <div className='fluid-container'>
        <h1 className='text-center mb-5'><u>Wish List Items</u></h1>
        <div className='mainDiv'>
          {
            wishlist.map(data=>(
              <div className='wldiv w-25 rounded-5 text-center p-4'>
                <h3><b>{data.bookName}</b></h3>
                <img src={data.bookImg} className='wlimg mt-4 mb-4'/>
                <h4><b>Author: </b>{data.bookAuthor}</h4>
                <h2><b>Price: </b>{data.bookPrice}</h2>
                <button className='btn btn-warning mt-3' onClick={()=>handleCart(data.bookId)}>Add to Cart</button>
                <button className='btn btn-danger ms-4 mt-3' onClick={()=>handleRemove(data.bookId)}>Remove</button>
              </div>
            ))
          }
        </div>
      </div>
    </div>
  )
}

export default Wishlist
