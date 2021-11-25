import React from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";

import "./bookingResum.css";

export default function BookingResum({ car }) {
	console.log(car);
	return (
		<div className='booking_sectionr'>
			<div className='bookin_aside'>
				<h3>Detalle de reserva</h3>
				<img src={car.mainImage.urlImage} alt={car.name} />
				<div className='booking_aside_data'>
					<p>{car.category.title}</p>
					<p>{car.name}</p>
					<p>{car.city.name}</p>
					<div className='product_resum_qualification_text'>
						<p>Muy bueno</p>
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
					</div>
					<div className='booking_checkin'>
						<input type='text' placeholder='recogida' />
					</div>
					<div className='booking_checkout'>
						<input type='text' placeholder='llegada' />
					</div>
				</div>
			</div>
		</div>
	);
}
