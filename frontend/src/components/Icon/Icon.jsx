import "./Icon.css"
export default function Icon(props) {
    return (
        <div className="car_card_div_icon_description">
            <img src={props.img} alt={props.alt} className="car_card_icon" />
            <span className="car_card_icon_text">{props.text}</span>
        </div>
    )
}