import { useContext } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar, faCalendarAlt} from "@fortawesome/free-solid-svg-icons";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import "./bookingResum.css";

export default function BookingResum({ car }) {

	const { rangeDate } = useContext(UserContext);

	return (
		<div className='booking_sectionr'>
			<div className='bookin_aside'>
				<h3>Detalle de reserva</h3>
				<div className="image_car_booking">
					<img src={car.images.find(image => image.title === car.name + " White").urlImage} alt={car.name} />
					<div className='booking_circle_yellow'></div>
				</div>
				<div className='booking_aside_data'>
					<p>{car.category.title}</p>
					<h3>{car.name}</h3>
					<p>{car.city.name}</p>
					<div className='product_resum_qualification_text'>
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
						<FontAwesomeIcon className='product_icon_start' icon={faStar} />
					</div>
					<div className='line_calendar'></div>
					<div className='booking_checkin'>
						<FontAwesomeIcon className='product_icon_calendar' icon={faCalendarAlt} />
						<p className='p_booking_checkin'>Check In: </p>
						<p>{rangeDate?.start?.format("DD/MM/YYYY") || ""}</p>
					</div>
					<div className='line_calendar'></div>
					<div className='booking_checkout'>
						<FontAwesomeIcon className='product_icon_calendar' icon={faCalendarAlt} />
						<p className='p_booking_checkout' >Check Out: </p>
						<p>{rangeDate?.end?.format("DD/MM/YYYY") || ""}</p>
					</div>
				</div>
			</div>
		</div>
	);
}
