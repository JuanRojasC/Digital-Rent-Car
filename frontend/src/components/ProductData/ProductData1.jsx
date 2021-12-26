import Gallery from "../Gallery/Gallery";
import "./productData.css";

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
							src={car.specs.enginePower.icon.urlImage}
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
							src={car.specs.airConditioning.icon.urlImage}
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
							src={car.specs.seats.icon.urlImage}
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
							src={car.specs.combustible.icon.urlImage}
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
