import Gallery from "../Gallery/Gallery";
import "./productData.css";
import engineIcon from "../../Assets/Icons/engine.png";
import airConditionerIcon from "../../Assets/Icons/air-conditioner.png";
import seatIcon from "../../Assets/Icons/seat.png";
import electricIcon from "../../Assets/Icons/electric.png";
import gasolineIcon from "../../Assets/Icons/gasoline.png";

export default function ProductData({ car }) {
	return (
		<article className='product_data'>
			<Gallery images={car.images} />
			<div className='product_data_information'>
				<h3>Descripcion</h3>
				<p>
					{car.description}
				</p>
				<h3>Caracteristicas</h3>
				<div className='product_data_car_card_icons_container'>
					{
						//motor
					}
					<div className='product_data_car_card_div_icon_description'>
						<img
							src={engineIcon}
							alt='Engine Icon'
							className='product_data_car_card_icon'
						/>
						<span className='product_data_car_card_icon_text'>
							{car.specs.enginePower.value}
						</span>
					</div>
					{
						//aireAcondicionado
					}
					<div className='product_data_car_card_div_icon_description'>
						<img
							src={airConditionerIcon}
							alt='Air Conditioner Icon'
							className='product_data_car_card_icon'
						/>
						<span className='product_data_car_card_icon_text'>
							{car.specs.airConditioning.value ? "A/C" : "No"}
						</span>
					</div>
					{
						//Sillas
					}
					<div className='product_data_car_card_div_icon_description'>
						<img
							src={seatIcon}
							alt='Seat Icon'
							className='product_data_car_card_icon'
						/>
						<span className='product_data_car_card_icon_text'>
							{car.specs.seats.value}
						</span>
					</div>
					{
						//Combustible
					}
					<div className='product_data_car_card_div_icon_description'>
						<img
							src={
								car.specs.combustible.value !== "Electrico"
									? gasolineIcon
									: electricIcon
							}
							alt='Gasoline Icon'
							className='product_data_car_card_icon'
						/>
						<span className='product_data_car_card_icon_text'>
							{car.specs.combustible.value}
						</span>
					</div>
				</div>
			</div>
		</article>
	);
}
