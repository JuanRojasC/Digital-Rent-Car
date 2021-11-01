import { useState, useEffect } from "react";
import "./category_card.css";

export default function CategoryCard(props){

    let [ clicked, setClicked ] = useState(false);
    let [ idCardCategory ] = useState("category_card_"+props.id);

    useEffect(()=>{
        if(clicked!==false){
            props.setCategoryClicked(idCardCategory);
            document.querySelector("#"+idCardCategory).style.border = "1px solid black";
            document.querySelector("#"+idCardCategory).style.backgroundColor = "var(--primary-color)";
            setClicked(false)
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    },[clicked])

    return (
        <>
            <div className="category_card" id={idCardCategory} onClick={()=>setClicked(true)}>
                <img src={props.image} alt="Category Visual Reference" className="category_card_image"/>
                <h3>{props.title}</h3>
            </div>
        </>
    );
}