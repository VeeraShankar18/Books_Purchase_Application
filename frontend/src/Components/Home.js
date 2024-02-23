import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import axios from 'axios'
function Home() {

    const [books,setBooks]=useState([])

    let navigate=useNavigate()

    function loadUsers()
    {
        axios.get('http://localhost:9090/book/getAll')
        .then(res=>
            {
                setBooks(res.data) 
                console.log(res)
            })
        .catch(err=>
            {
                console.log(err)
            })
    }

    useEffect(()=>{
        loadUsers()
    },[])

    const handleWishlist=(bookId)=>
    {
        axios.get(`http://localhost:9090/book/get/${bookId}`)
        .then(res=>
        {
            axios.post('http://localhost:9090/wishlist/add',res.data).then(res=>navigate('/wishlist')).catch(err=>{console.log(err)})
        })
        .catch(err=>
        {
            console.log(err)
        })
    }  
    
    const handleCart=(bookId)=>
    {
        axios.get(`http://localhost:9090/book/get/${bookId}`)
        .then(res=>
        {
            axios.post('http://localhost:9090/cart/add',res.data).then(res=>navigate('/cart')).catch(err=>{console.log(err)})
        })
        .catch(err=>
        {
            console.log(err)
        })
    }

  return (
    <div className='bg-dark text-light'>
        <div className='navbar bg-secondary headr'>
            <h3 className='navbar-brand text-dark ms-3'><b>Books Store</b></h3>
            <Link className='me-4 ms-auto btn btn-info text-dark' to='/wishlist'>Wishlist</Link>
            <Link className='btn btn-warning text-dark me-4' to='/cart'>cart</Link>
            <Link className='btn btn-success text-dark me-4' to='/myorders'>My Orders</Link>
        </div>
        <h1 className='text-center mt-4 text-primary'>Available Books</h1>
        <div className='mainBody text-center ms-5 mt-4'>
            {
                books.map((data,index)=>(
                    <div className='childBody pt-3 ps-2 pe-2' key={index}>
                        <h3><b>{data.bookName}</b></h3>
                        <img src={data.bookImg} className='img mt-4'/>
                        <h4 className='mt-3'><b>Author: </b>{data.bookAuthor}</h4>
                        <p><b>Description: </b>{data.bookDescription}</p>
                        <h1>Price: {data.bookPrice}/-</h1>
                        <h4>Genre: {data.bookGenre}</h4>
                        <button className='btn btn-info mt-3 me-4' onClick={()=>handleWishlist(data.bookId)}>Add to WishList</button>
                        <button className='btn btn-warning mt-3' onClick={()=>handleCart(data.bookId)}>Add to cart</button>
                    </div> 
                ))
            }
        </div>
    </div>
  )
}

export default Home
