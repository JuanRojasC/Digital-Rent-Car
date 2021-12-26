import { useState, useEffect, useContext } from "react";
import Moment from "moment";
import { extendMoment } from "moment-range";
import { UserContext } from "../../Hooks/UserContext/UserContext";

export const useProductCalendar = () => {
	const moment = extendMoment(Moment);
	
	const {productBooking,rangeDate,setRangeDate} =useContext(UserContext);

	const rangebookings = productBooking.bookings.map((booking, i) => {
		const bookingStartDate = moment(booking.startTime);
		const bookingEndDate = moment(booking.finishTime);
		const bookingRange = moment.range(bookingStartDate, bookingEndDate);
		return bookingRange
	});

	const [calendarLeft, setCalendarLeft] = useState([]);
	const [calendarRight, setCalendarRight] = useState([]);
	const [value, setValue] = useState(moment());
	const [range,setRange] = useState({});
	const [count, setCount] = useState(0);
	const [monthLeft, setMonthLeft] = useState(value.clone());
	const [monthRight, setMonthRight] = useState(value.clone().add(1, "month"));

	const startDayLeft = monthLeft.clone().startOf("month").startOf("week");
	const endDayLeft = monthLeft.clone().endOf("month").endOf("week");

	const startDayRight = monthRight.clone().startOf("month").startOf("week");
	const endDayRight = monthRight.clone().endOf("month").endOf("week");

	useEffect(()=>{
		if(rangeDate) setRange({range:rangeDate})
		// eslint-disable-next-line react-hooks/exhaustive-deps
	},[])

	useEffect(() => {
		const dayLeft = startDayLeft.clone().subtract(1, "day");
		const dayRight = startDayRight.clone().subtract(1, "day");
		const a = [];
		const b = [];
		while (dayLeft.isBefore(endDayLeft, "day")) {
			a.push(
				Array(7)
					.fill(0)
					.map(() => dayLeft.add(1, "day").clone())
			);
		}
		while (dayRight.isBefore(endDayRight, "day")) {
			b.push(
				Array(7)
					.fill(0)
					.map(() => dayRight.add(1, "day").clone())
			);
		}
		setCalendarLeft(a);
		setCalendarRight(b);
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [monthLeft, monthRight]);

	useEffect(() => {
		if(range.range) setRangeDate(range.range)
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [range]);

	const handleClick = (day) => {
		if(count === 0){
			if(range.range){
				setRange({})
				setRange({rangeOne: day})
				setCount(1)
			}else{
				setRange({rangeOne: day})
				setCount(1)	
			}
		}else{
			const rangeTwo = moment(day)
			const rangeSelected = moment.range(range.rangeOne,rangeTwo)
			setRange({range:rangeSelected})
			setCount(0)
		}
	};

	const isSelected = (day) => {
		return range.range ? range.range.contains(day) : false;
	};

	const beforToday = (day) => {
		return day.isBefore(new Date(), "day");
	};

	const isToday = (day) => {
		return day.isSame(new Date(), "day");
	};

	const isNotAvalable = (day) => {
		return rangebookings.find((bookingRange)=>{
			return bookingRange.contains(day)
		})
	};
	const isOtherMonth = (day,month) =>{
		if(month === "left"){
			if(day.format("MM") !== monthLeft.format("MM")) return true;
		}else{
			if(day.format("MM") !== monthRight.format("MM")) return true;
		}
	}

	const dayStyles = (day,month) => {
		if(range.range){
			if(isNotAvalable(day) && isSelected(day)) {
				setRange({})
				console.log("solo puedes seleccionar dias habilidtados")
			}
		}
		if (beforToday(day) || isNotAvalable(day)|| isOtherMonth(day,month)) return "product_availability_calendar_day_before";
		if (isSelected(day)) return "product_availability_calendar_day_selected";
		if (isToday(day)) return "product_availability_calendar_day_today";
		return "";
	};

	const minusMonth = () => {
		setMonthLeft(monthLeft.clone().subtract(1, "month"));
		setMonthRight(monthRight.clone().subtract(1, "month"));
	};

	const plusMonth = () => {
		setMonthLeft(monthLeft.clone().add(1, "month"));
		setMonthRight(monthRight.clone().add(1, "month"));
	};

	return {
		value,
		calendarLeft,
		calendarRight,
		monthLeft,
		monthRight,
		setValue,
		dayStyles,
		minusMonth,
		plusMonth,
		handleClick,
	};
};
