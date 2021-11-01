import { useEffect, useState } from "react";
import CategoryCard from "../../components/CategoryCard/CategoryCard";
import categoriesList from "../../Assets/jsons/CategoriesList.json";

export default function CategoriesCards(props){

    let [categoryClicked, setCategoryClicked] = useState(null);

    useEffect(()=>{
        let categoriesCards = Array.from(document.querySelectorAll(".category_card"));
        let categoriesCardsDisable = categoriesCards.filter(card=>card.id!==categoryClicked);
        categoriesCardsDisable.forEach(card=>{
            card.style.border = "1px solid white";
            card.style.backgroundColor = "var(--gray-color)";
        })
    },[categoryClicked])


    return(
        <div className="car_categories_landing_page_options">
            {categoriesList.map((category, index)=>
                <CategoryCard  key={index} id={index} title={category.titulo} image={category.url} setCategoryClicked={setCategoryClicked}/>
                )} 
        </div>
    );
}