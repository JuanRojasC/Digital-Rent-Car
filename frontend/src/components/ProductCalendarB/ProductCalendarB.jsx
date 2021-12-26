import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import "./productCalendar.css";
import {
	faChevronRight,
	faChevronLeft,
} from "@fortawesome/free-solid-svg-icons";
import { useProductCalendar } from "./useProductCalendar";

export default function ProductCalendarB() {

	const {
		calendarLeft,
		calendarRight,
		monthLeft,
		monthRight,
		handleClick,
		dayStyles,
		minusMonth,
		plusMonth,
	} = useProductCalendar();

	return (
		<div className='product_availability_calendars'>
			<div
				onClick={minusMonth}
				className='product_availability_calendar_leftbtn'>
				<FontAwesomeIcon icon={faChevronLeft} />
			</div>
			<div className='product_availability_calendar'>
				<div className='product_availability_calendar_header_month'>
					{monthLeft.format("MMMM") + " " + monthLeft.format("YYYY")}
				</div>
				<div className='product_availability_calendar_header_days'>
					{["D", "L", "M", "M", "J", "V", "S"].map((day,i) => (
						<div key={"headerleft"+day+i}>
							<p>{day}</p>
						</div>
					))}
				</div>
				<div className='product_availability_calendar_weeks'>
					{calendarLeft.map((week,i)=>(
						<div key={"weekleft"+i} className='product_availability_calendar_week'>
							{week.map((day,i)=>(
								<div key={"dayleft"+i} onClick={() =>{ handleClick(day)}} className={dayStyles(day)}>{day.format("D")}</div>
							))}
						</div>
					))}
				</div>
			</div>
			<hr />
			<div className='product_availability_calendar'>
				<div className='product_availability_calendar_header_month'>
					{monthRight.format("MMMM") + " " + monthRight.format("YYYY")}
				</div>
				<div className='product_availability_calendar_header_days'>
					{["D", "L", "M", "M", "J", "V", "S"].map((day,i) => (
						<div key={"headerright"+day+i}>
							<p>{day}</p>
						</div>
					))}
				</div>
				<div className='product_availability_calendar_weeks'>
					{calendarRight.map((week,i)=>(
						<div key={"weekright"+i} className='product_availability_calendar_week'>
							{week.map((day,i)=>(
								<div key={"dayright"+i} onClick={() =>{ handleClick(day)}} className={dayStyles(day)}>{day.format("D").toString()}</div>
							))}
						</div>
					))}
				</div>
			</div>
			<div
				onClick={plusMonth}
				className='product_availability_calendar_rightbtn'>
				<FontAwesomeIcon icon={faChevronRight} />
			</div>
		</div>
	);
}
