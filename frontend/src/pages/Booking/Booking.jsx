import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChevronLeft } from "@fortawesome/free-solid-svg-icons";
import "./booking.css";
import BookingUserData from "../../components/BookingUserData/BookingUserData";
import ProductCalendarB from "../../components/ProductCalendarB/ProductCalendarB";
import BookingData from "../../components/BookingData/BookingData";
import BookingResum from "../../components/BookingResum/BookingResum";
import SupportInfo from "../../components/SupportInfo/SupportInfo";
import { UserContext } from "../../Hooks/UserContext/UserContext";

export default function Booking() {
	const {productBooking,rangeDate,user} = useContext(UserContext);

	return (
		<div className='booking_container'>
			<div className='booking_navbar'>
				<div className='booking_navbar_data'>
					<h4>{productBooking.category.title}</h4>
					<h2>{productBooking.name}</h2>
				</div>
				<Link className='booking_navbar_btn' to='/'>
					<FontAwesomeIcon
						className='booking_navbar_backbtn'
						icon={faChevronLeft}
					/>
				</Link>
			</div>
			<div className="booking_section">
				<div className="booking_sectionl">
					<BookingUserData user ={user} location={productBooking.city.name} />
					<ProductCalendarB rangeDate ={rangeDate} />
					<BookingData/>
				</div>
                <BookingResum car={productBooking}/>
			</div>
			<Link to={`/${user.email}/producto/${productBooking.name}/reserva/exitosa`} >Confirmar reserva</Link>
			<SupportInfo/>
		</div>
	);
}
