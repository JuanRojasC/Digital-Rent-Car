import { useState, useEffect } from "react";
import { isMobile } from "react-device-detect";

import axios from "axios";

import useCategoriesCards from "./useCategoriesCards";
import useFiltersFinder from "./useFiltersFinder";
import Moment from "moment";
import { extendMoment } from 'moment-range';

const useProductList = () => {

	const moment = extendMoment(Moment);

	const { categoryClicked, setCategoryClicked, categoriesList } =
		useCategoriesCards();
	const {
		filterData,
		setFilterData,
		handleChange,
		handleOnSubmit,
		setFormValues,
		formValues,
	} = useFiltersFinder();

	//CategoryList
	useEffect(() => {
		if (categoryClicked)
			setFilterData({ ...filterData, category: categoryClicked });
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [categoryClicked]);

	//Car list

	const itemsNumber = isMobile && window.innerWidth < 1000 ? 3 : 4;

	const [lastPosition, setLastPosition] = useState(itemsNumber);
	const [carData, setCarData] = useState([]);
	const [carList, setCarList] = useState([]);
	const [carsShow, setCarsShow] = useState(carList.slice(0, itemsNumber));

	useEffect(() => {
		axios
			.get(
				"http://localhost:8080/products/find/all"
			)
			.then((res) => {
				const data = res.data;
				setCarList(data);
				setCarData(data);
			});
	}, []);

	useEffect(() => {
		setCarsShow(carList.slice(lastPosition - itemsNumber, lastPosition));
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [lastPosition, carList]);

	//filter Finder

	useEffect(() => {
		if (filterData) {
			let newCarList = carData;
			if (filterData.category) {
				newCarList = newCarList.filter((car, i) => {
					if (filterData.category === "category_card_0")
						return car.category.title === "SUV";
					if (filterData.category === "category_card_1")
						return car.category.title === "Sedan";
					if (filterData.category === "category_card_2")
						return car.category.title === "Deportivo";
					if (filterData.category === "category_card_3")
						return car.category.title === "Pick-up";
					else return false;
				});
			}
			if (filterData.selectLocation && filterData.selectLocation !== "Ubicacion") {
				newCarList = newCarList.filter((car, i) => {
					return filterData.selectLocation === car.city.name;
				});
			}
			if(filterData.pickUpDate && filterData.dropOffDate){
				const filterDateStart = moment(filterData.pickUpDate)
				const filterDataEnd = moment(filterData.dropOffDate)
				const rangeFilter =  moment.range(filterDateStart, filterDataEnd)
				console.log(newCarList);
				if(filterDateStart.isBefore(filterDataEnd, "day")){
					newCarList = newCarList.filter((car,i)=>{
						return car.bookings.every((booking)=>{
							const bookingStartDate = moment(booking.startTime)
							const bookingEndDate = moment(booking.finishTime)
							const bookingRange = moment.range(bookingStartDate,bookingEndDate)
							console.log(bookingStartDate.format('YYYY-MM-DD'));
							console.log(bookingEndDate.format('YYYY-MM-DD'));
							console.log(rangeFilter.intersect(bookingRange));
							return !rangeFilter.intersect(bookingRange)? true : false;
						})
					})
				}else{
					alert("escoge una fecha de retiro y devolución coherentes")
				}
			}
			setCarList(newCarList);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [filterData]);

	const handleRemoveFilterData = () => {
		setFilterData(null);
		setCategoryClicked(null);
		setCarList(carData);
		setFormValues({
			selectLocation: "Ubicacion",
			pickUpDate: null,
			dropOffDate: null,
			category: null,
		});
	};

	const clickSlideLeft = () => {
		if (lastPosition === itemsNumber) return;
		else if (lastPosition > itemsNumber) setLastPosition(lastPosition - 1);
	};
	const clickSlideRight = () => {
		if (lastPosition === carList.length) return;
		else if (lastPosition < carList.length) setLastPosition(lastPosition + 1);
	};

	return {
		categoriesList,
		setCategoryClicked,
		carsShow,
		clickSlideLeft,
		clickSlideRight,
		filterData,
		setFilterData,
		handleChange,
		handleOnSubmit,
		handleRemoveFilterData,
		formValues,
		carData
	};
};

export default useProductList;
