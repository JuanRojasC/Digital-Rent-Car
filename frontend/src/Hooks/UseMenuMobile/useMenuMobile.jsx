import { useState, useEffect } from "react";


export default function useMenuMobile(classNameMenuMobile){

    let [deployMenu, setDeployMenu] = useState(false);

    useEffect(()=>{
        if(deployMenu) document.querySelector(classNameMenuMobile).style.display = "flex";
        else document.querySelector(classNameMenuMobile).style.display = "none";
        // eslint-disable-next-line react-hooks/exhaustive-deps
    },[deployMenu])
    
    return [deployMenu, setDeployMenu];
}