import ProductCalendar from "../ProductCalendar/ProductCalendar";
import "./productAvailability.css";
import ProductReservation from "../ProductReservation/ProductReservation";

export default function ProductAvailability({car}) {
	
	
	return (
		<div className='product_availability'>
			<h3>Fechas Disponibles</h3>
			<div className='product_availability_interaction'>
				<ProductCalendar bookings ={car.bookings} />
				<ProductReservation id={car.id}/>
			</div>
		</div>
	);
}
