import React from "react";

import "./bookingData.css";

export default function BookingData() {
	return (
		<div className='booking_data_container'>
			<h3 className='booking_data_container_title'>
				Tu hora de llegada y regreso
			</h3>
			<p>indica tu hora de llegada y regreso para tener tu vehiculo listo</p>
			<form className='booking_data_container_form'>
				<input></input>
			</form>
		</div>
	);
}
