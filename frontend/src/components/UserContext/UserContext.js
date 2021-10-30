import React from "react";
import { useLocalStorage } from "./useLocalStorage";

const UserContext = React.createContext(null);

function UserProvider (props){
    
    const {user,setUser,logged,setLogged} = useLocalStorage();

    return(
        <UserContext.Provider value={{
                user,
                setUser,
                logged,
                setLogged
            }}>
            {props.children}
        </UserContext.Provider>
    )
}


export {UserContext, UserProvider};