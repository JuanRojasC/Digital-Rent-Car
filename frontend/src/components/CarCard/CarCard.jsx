import { Link } from "react-router-dom";
import Icon from "../Icon/Icon";
import "./car_cards.css";

export default function CarCard({ car }) {

	const storageData = (car) => {
		localStorage.setItem("resource_object_car", JSON.stringify(car));
		localStorage.setItem("resource_car_id", car.id);
	} 

	return (
		(car && (
			<div className='car_card'>
				<div className='car_card_div_image_car'>
					<img
						className='car_card_img_car'
						src={car.images.find(image => image.title === car.name + " White")? car.images.find(image => image.title === car.name + " White").urlImage : ""}
						alt='vehicle'
					/>
				</div>
				<h3 className='car_card_car_name'>{car.name}</h3>
				<div className='car_card_icons_container'>
					{
						//motor
					}
					<Icon
						img={car.specs.enginePower.icon.urlImage}
						text={car.specs.enginePower.value}
						alt='engineIcon'
					/>
					{
						//aireAcondicionado
					}
					<div className='car_card_div_icon_description'>
						<img
							src={car.specs.airConditioning.icon.urlImage}
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
						<img
							src={car.specs.seats.icon.urlImage}
							alt='Seat Icon'
							className='car_card_icon'
						/>
						<span className='car_card_icon_text'>{car.specs.seats.value}</span>
					</div>
					{
						//Combustible
					}
					<div className='car_card_div_icon_description'>
						<img
							src={car.specs.combustible.icon.urlImage}
							alt='Gasoline Icon'
							className='car_card_icon'
						/>
						<span className='car_card_icon_text'>
							{car.specs.combustible.value}
						</span>
					</div>
				</div>
				<Link className='car_card_btn_more' to={"/autos/" + car.name.replace(" ", "-")} onClick={() => storageData(car)}>
					Ver más
				</Link>
			</div>
		)) || <></>
	);
}
