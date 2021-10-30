import { Link } from 'react-router-dom';
import engineIcon from "../../Assets/Icons/engine.png";
import airConditionerIcon from "../../Assets/Icons/air-conditioner.png";
import seatIcon from "../../Assets/Icons/seat.png";
import electricIcon from "../../Assets/Icons/electric.png";
import gasolineIcon from "../../Assets/Icons/gasoline.png";
import Icon from '../Icon/Icon';
import "./car_cards.css";

export default function CarCard(props) {

    const {car}=props;

    return(
        <div className="car_card">
            <img className="car_card_img_car" src={car.img} alt="vehicle"/>
            <h3 className="car_card_car_name">{car.title}</h3>
            <div className="car_card_icons_container">
                {
                    //motor
                }
                <Icon img={engineIcon} text={car.description.engine}alt="engineIcon"/>
                {
                    //aireAcondicionado
                }
                <div className="car_card_div_icon_description">
                    <img src={airConditionerIcon} alt="Air Conditioner Icon" className="car_card_icon"/>
                    <span className="car_card_icon_text">{car.description.airConditioning?"A/C":"No"}</span>
                </div>
                {
                    //Sillas
                }
                <div className="car_card_div_icon_description">
                    <img src={seatIcon} alt="Seat Icon" className="car_card_icon"/>
                    <span className="car_card_icon_text">{car.description.seats}</span>
                </div>
                {
                    //Combustible
                }
                <div className="car_card_div_icon_description">
                    <img src={car.description.type!=="Electrico"? gasolineIcon : electricIcon} alt="Gasoline Icon" className="car_card_icon"/>
                    <span className="car_card_icon_text">{car.description.type}</span>
                </div>  
            </div>
            {
                //Boton ver mas
            }
            <Link className="car_card_btn_more" to="">Ver más</Link>
        </div>
    )
}