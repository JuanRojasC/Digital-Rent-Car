import React from 'react';

function useLocalStorage() {
  const [logged, setLogged] = React.useState(false);
  const [user, setUser] = React.useState(null);

  window.onbeforeunload = ()=>{
    localStorage.removeItem(user.email)
  }

  React.useEffect(() => {
    if(!logged && user){
      localStorage.removeItem(user.email)
    }
    if(logged && user){
      if(!localStorage.getItem(user.email)){
        localStorage.setItem(user.email , JSON.stringify(user))
      }
    }
  },[user,logged]);

  return {
    user,
    setUser,
    logged,
    setLogged
  };
}

export { useLocalStorage };