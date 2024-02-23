import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link, useNavigate, useParams } from 'react-router-dom'

function Address() {

    let navigate=useNavigate()

    const {bookId}=useParams()

    const [address,setAddress]=useState({
        bookName:'',
        bookImg:'',
        bookAuthor:'',
        bookPrice:'',
        customerName:'',
        customerMobileNo:'',
        customerAddress:''
    })

    const loadAddress=()=>
    {
      axios.get(`http://localhost:9090/cart/get/${bookId}`)
      .then(res=>
        {
            setAddress(res.data)
        })
      .catch(err=>
        {
            console.log(err)
        })
    }
  
    useEffect(()=>
    {
      loadAddress()
    },[])

    const handleChange=(e)=>
    {
        e.preventDefault()
        setAddress({...address,[e.target.name]: e.target.value})
    }

    const handlePlaceOrder=(event)=>
    {
        event.preventDefault()
        axios.post('http://localhost:9090/address/add',address)
        .then(res=>
            {
                axios.delete(`http://localhost:9090/cart/delete/${bookId}`)
                navigate('/myorders')
                alert("your Order has Placed Successfully")
            })
        .catch(err=>
            {
                console.log(err)
            })
    }

  return (
    <div className='bg-dark pt-4'>
        <div className='bg-light container pt-3 rounded-4 w-50 p-5 minDiv'>
            <h1 className='text-center mb-5'>Address Page</h1>
            <form>
                <label>Name:</label>
                <input type='text' placeholder='Enter Your Name' className='form-control mb-4 border-3' name='customerName'
                value={address.customerName || " "} onChange={handleChange} required/>
                <label>Mobile Number:</label>
                <input type='text' placeholder='Enter Your Mobile Number' className='form-control mb-4 border-3' name='customerMobileNo'
                value={address.customerMobileNo || " "} onChange={handleChange} required/>
                <label>Address:</label>
                <input type='text' placeholder='Enter Your Address to be Delevered' className='form-control mb-4 border-3 addressBox' name='customerAddress'
                value={address.customerAddress || " "} onChange={handleChange} required/>
                <div className='text-center'>
                    <button className='btn btn-primary w-25 mt-4 me-5' onClick={handlePlaceOrder}>Place Order</button>
                    <Link className='btn btn-danger w-25 mt-4' to='/cart'>Cancel</Link>
                </div>
            </form>
        </div>
    </div>
  )
}

export default Address
