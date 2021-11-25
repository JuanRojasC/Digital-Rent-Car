import { useState, useEffect } from "react";
import moment from "moment";

export const useProductCalendar = () => {
	const [calendarLeft, setCalendarLeft] = useState([]);
	const [calendarRight, setCalendarRight] = useState([]);
	const [value, setValue] = useState(moment());
    const [monthLeft, setMonthLeft] = useState(value.clone());
    const [monthRight, setMonthRight] = useState(value.clone().add(1,"month"));

	const startDayLeft = monthLeft.clone().startOf("month").startOf("week");
	const endDayLeft = monthLeft.clone().endOf("month").endOf("week");

    const startDayRight = monthRight.clone().startOf("month").startOf("week");
    const endDayRight = monthRight.clone().endOf("month").endOf("week");

	useEffect(() => {
		const dayLeft = startDayLeft.clone().subtract(1, "day");
        const dayRight = startDayRight.clone().subtract(1,"day");
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
	}, [monthLeft,monthRight]);


    useEffect(() => {
        console.log("funciona");
    }, [value])

	const isSelected = (day) => {
		return value.isSame(day, "day");
	};

	const beforToday = (day) => {
		return day.isBefore(new Date(), "day");
	};

	const isToday = (day) => {
		return day.isSame(new Date(), "day");
	};

	const dayStyles = (day) => {
		if (beforToday(day)) return "product_availability_calendar_day_before";
		if (isSelected(day)) return "product_availability_calendar_day_selected";
		if (isToday(day)) return "product_availability_calendar_day_today";
		return "";
	};

    const minusMonth =()=>{
        setMonthLeft(monthLeft.clone().subtract(1,"month"));
        setMonthRight(monthRight.clone().subtract(1,"month"));
    }

    const plusMonth = () =>{
        setMonthLeft(monthLeft.clone().add(1,"month"));
        setMonthRight(monthRight.clone().add(1,"month"));
    }

	return {
		value,
		calendarLeft,
        calendarRight,
        monthLeft,
        monthRight,
		setValue,
		dayStyles,
        minusMonth,
        plusMonth
	};
};
