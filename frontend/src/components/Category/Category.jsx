import { useState } from 'react';
import { Link } from 'react-router-dom';
import categoriesList from "../../Assets/jsons//CategoriesList.json";
import "./Category.css";

export default function Category() {

    let [categories] = useState(categoriesList);

    return (
        <nav class="car_card_car_type_menu">
            <ul>
                {categories.map((category, index) =>
                    <li key={index} className="car_type_menu_category">
                        <Link className="car_type_menu_category_link" to=""><span>{category.titulo}</span></Link>
                    </li>
                )}                         
            </ul>
        </nav>
    )
}