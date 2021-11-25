import { Link } from "react-router-dom";

import engineIcon from "../../Assets/Icons/engine.png";
import airConditionerIcon from "../../Assets/Icons/air-conditioner.png";
import seatIcon from "../../Assets/Icons/seat.png";
import electricIcon from "../../Assets/Icons/electric.png";
import gasolineIcon from "../../Assets/Icons/gasoline.png";
import Icon from "../Icon/Icon";

import "./car_cards.css";

export default function CarCard({ car }) {
	return (
		<div className='car_card'>
			<div className='car_card_div_image_car'>
				<img
					className='car_card_img_car'
					src={car.mainImage.urlImage}
					alt='vehicle'
				/>
			</div>
			<h3 className='car_card_car_name'>{car.name}</h3>
			<div className='car_card_icons_container'>
				{
					//motor
				}
				<Icon
					img={engineIcon}
					text={car.specs.enginePower.value}
					alt='engineIcon'
				/>
				{
					//aireAcondicionado
				}
				<div className='car_card_div_icon_description'>
					<img
						src={airConditionerIcon}
						alt='Air Conditioner Icon'
						className='car_card_icon'
					/>
					<span className='car_card_icon_text'>
						{car.specs.airConditioning.value ? "A/C" : "No"}
					</span>
				</div>
				{
					//Sillas
				}
				<div className='car_card_div_icon_description'>
					<img src={seatIcon} alt='Seat Icon' className='car_card_icon' />
					<span className='car_card_icon_text'>{car.specs.seats.value}</span>
				</div>
				{
					//Combustible
				}
				<div className='car_card_div_icon_description'>
					<img
						src={
							car.specs.combustible.value !== "Electrico"
								? gasolineIcon
								: electricIcon
						}
						alt='Gasoline Icon'
						className='car_card_icon'
					/>
					<span className='car_card_icon_text'>{car.description.type}</span>
				</div>
			</div>
			{
				//Boton ver mas
			}
			<Link className='car_card_btn_more' to={"/producto/" + car.id}>
				Ver más
			</Link>
		</div>
	);
}