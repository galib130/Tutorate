import React from "react";
import UserService from "../services/UserService";
import {Navigate, useNavigate, userNavigate} from 'react-router-dom'


class UserComponent extends React.Component{

    constructor(props){
        super(props)
        this.state={
            users:[],
            getName:''
        }
    }

   

    
    componentDidMount(){
        UserService.getPresentation().then((response)=>{
            this.setState({users: response.data})
        })
    }
    
    handleChange = event => {
        this.setState({ getName: event.target.value });
      }

      
        saveUser =(e)=>{
            const history=useNavigate();
        e.preventDefaut();
        const user={getName:this.state.getName}
        UserService.createUser(user).then((response) =>{
            console.log(response.data)
               history('');
            
        })


    }

    render(){
       
        return(
            <div>

            

{this.state.users.map(
        user => 
        <tr key={user.id}>
            <td>{user.name}js</td>
            <td>{user.last_name}td</td>

        </tr>



)}

<form onSubmit={this.saveUser}>
  <label>
    Name:
    <input type="text" name="first_name"  onChange={this.handleChange} />
  </label>
  <input type="submit" value="Submit" />
</form>
</div>
        

        )


    }

}

export default UserComponent