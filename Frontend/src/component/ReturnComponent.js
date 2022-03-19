import React, { useState } from 'react'
import UserService from '../services/UserService';
import {Navigate, useNavigate, userNavigate} from 'react-router-dom'

const ReturnComponent = () => {

const [name,setName]=useState('')
const [password,setPassword]=useState('')
const[id,setID]=useState('')
const history=useNavigate();
const auth=useState('');
const createUser =(e)=>{
    e.preventDefault();

    const user={name,password}
    
    UserService.createUser(user).then((response)=>{
        console.log('Hurray');
       
        if(response.data === "authenticated")
      {
        history('/return');
        console.log(response.data)
      
    
    } 
       else{
        console.log(response.data)
        window.location.reload(true)
        history('');
      
       }
        })

}

    return (
    <div>Enter Username Galib and password 1234 the password is encrypted using Bcrypt encryption in mysql
<form>
<label>
    Name:
    <input type="text" name="name"  onChange={(e) => setName(e.target.value)} />
  </label>

  <label>
    Password:
    <input type="password" name="password"  onChange={(e) => setPassword(e.target.value)} />
  </label>


  <input type="submit" value="Submit" onClick={(e) => createUser(e)} />
</form>
  </div>
  )
}

export default ReturnComponent