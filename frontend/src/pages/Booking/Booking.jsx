import React, { useContext, useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMapMarkedAlt } from "@fortawesome/free-solid-svg-icons";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import { extendMoment } from "moment-range";
import BookingUserData from "../../components/BookingUserData/BookingUserData";
import ProductCalendarB from "../../components/ProductCalendarB/ProductCalendarB";
import BookingData from "../../components/BookingData/BookingData";
import BookingResum from "../../components/BookingResum/BookingResum";
import useApi from "../../Hooks/useApi/useApi";
import Moment from "moment";
import TermsAndConditions from "../../components/TermsAndConditions/TermsAndConditions";
import "./booking.css";

export default function Booking() {

	const moment = extendMoment(Moment);
	const history = useHistory();
	const [ now ]= useState(moment());
	const { productBooking, user, rangeDate, setBookingInfo, setProductBooking } = useContext(UserContext);
	const { response: bookingData, setParamas: setBookingParams } = useApi();

	const handleClick = () =>{
		// console.log({
		// 	method: "POST",
		// 	url: `/bookings/save/new`,
		// 	headers: { authorization: user.jwt },
		// 	data: {
		// 		timeBooking: now.format("YYYY-MM-DDTHH:mm"),
		// 		startTime: rangeDate.start.format("YYYY-MM-DDTHH:mm"),
		// 		finishTime: rangeDate.end.format("YYYY-MM-DDTHH:mm"),
		// 		user:{
		// 			id:user.id
		// 		},
		// 		product:{
		// 			id:productBooking.id
		// 		}
		// 	}
		// });
		setBookingParams({
			method: "POST",
			url: `/bookings/save/new`,
			headers: { authorization: user.jwt },
			data: {
				timeBooking: now.format("YYYY-MM-DDTHH:mm"),
				startTime: rangeDate.start.format("YYYY-MM-DDTHH:mm"),
				finishTime: rangeDate.end.format("YYYY-MM-DDTHH:mm"),
				user:{
					id:user.id
				},
				product:{
					id:productBooking.id
				}
			}
		})
	}
	
	useEffect(()=>{
		if(bookingData){
			console.log("entra");
			console.log(bookingData);
			setBookingInfo(bookingData)
			history.push(`/${user.email}/producto/${productBooking.name}/reserva/exitosa`)
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	},[bookingData])

	useEffect(() => {}, [productBooking])

	useEffect(() => {
		if(localStorage.getItem("resource_object_car") && !productBooking){
			setProductBooking(JSON.parse(localStorage.getItem("resource_object_car")));
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [])

	return ( productBooking?
		<div className='booking_container'>
			<div className='product_navbar'>
				<div className='product_navbar_data'>
					<h2>{productBooking.name}</h2>
					<h4>{productBooking.category.title}</h4>
				</div>
				<div className="product_navbar_location">
					<FontAwesomeIcon className='product_location_icon' icon={faMapMarkedAlt} />
					<p className="product_location_text">{productBooking.city.name}</p>
				</div>
			</div>
			<div className="booking_section">
				<BookingResum car={productBooking}/>
				<div className="booking_sectionl">
					<BookingUserData user ={user} location={productBooking.city.name} />
					<ProductCalendarB />
				</div>
			</div>
			<BookingData />
			<button onClick={handleClick}>Confirmar reserva</button>
			<TermsAndConditions termsAndConditions={productBooking.termsAndConditions} />
			<div className="booking_thanks">
				<h4>Gracias por confiar en nosotros!</h4>
			</div>
		</div>
		:
		null
	);
}
