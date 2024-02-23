import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

function Myorders() {

  const [myorders,setMyorders]=useState([])

  function loadMyOrders()
  {
    axios.get('http://localhost:9090/address/getAll').then(res=>{setMyorders(res.data)}).catch(err=>{console.log(err)})
  }

  useEffect(()=>
  {
    loadMyOrders()
  },[])

  const handleRemove=(bookId)=>
    {
      axios.delete(`http://localhost:9090/address/delete/${bookId}`)
      .then(res=>
        {
          loadMyOrders()
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
        </div>
      <div className='fluid-container'>
        <h1 className='text-center mb-5'><b>Orders</b></h1>
        <div className='moDiv'>
          {
            myorders.map(data=>(
              <div className='modiv rounded-5 text-center p-4'>
                <h1><b>{data.bookName}</b></h1>
                <h4><b>Author: </b>{data.bookAuthor}</h4>
                <h3><b>Price: </b>{data.bookPrice}</h3>
                <img src={data.bookImg} className='moimg mt-4 mb-4'/>
                <h4><b>Name: </b>{data.customerName}</h4>
                <h4><b>Mobile Number: </b>{data.customerMobileNo}</h4>
                <h4><b>Address of delivery: </b>{data.customerAddress}</h4>
                <button className='btn btn-danger ms-4 mt-3' onClick={()=>handleRemove(data.bookId)}>Cancel Order</button>
              </div>
            ))
          }
        </div>
      </div>
    </div>
  )
}

export default Myorders
