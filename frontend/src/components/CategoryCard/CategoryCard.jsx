import "./category_card.css";

export default function CategoryCard(props){
    return (
        <div className="category_card">
            <img src={props.image} alt="Category Visual Reference" className="category_card_image"/>
            <h3>{props.title}</h3>
        </div>
    );
}