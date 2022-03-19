import axios from 'axios'

const USERS_RESTAPI_URL= "http://localhost:8086/api/user";
const USERS_RESTAPI_URL_Post= "http://localhost:8086/api/return";

class presentation_layer{
   
    createUser(user){
        return axios.post(USERS_RESTAPI_URL_Post,user)
    }
    getPresentation(){
       return axios.get(USERS_RESTAPI_URL);
    }

 
}

export default new presentation_layer();