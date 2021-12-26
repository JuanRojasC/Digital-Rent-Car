import { useState, useEffect } from "react";
import { isMobile } from "react-device-detect";

import useCategoriesCards from "./useCategoriesCards";
import useFiltersFinder from "./useFiltersFinder";
import Moment from "moment";
import { extendMoment } from 'moment-range';
import useApi from "../useApi/useApi";

const useProductList = () => {

	const moment = extendMoment(Moment);
	const { categoryClicked, setCategoryClicked, categoriesList } = useCategoriesCards();
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
	const [carsData, setCarsData] = useState([]);
	const [carList, setCarList] = useState([]);
	const [carsShow, setCarsShow] = useState(carList.slice(0, itemsNumber));
	const {
		response: productsData,
		//error: productsError,
		//loading: productsLoading,
		//setLoading: setProductsLoading,
		setParamas: setProductsParams,
	} = useApi();
	
	useEffect(() => {
		setProductsParams({
			method: "GET",
			url: "/products/find/all"
		})
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	useEffect(()=>{
		if(productsData){
			setCarsData(productsData)
			setCarList(productsData)
		}
	},[productsData])

	useEffect(() => {
		setCarsShow(carList.slice(lastPosition - itemsNumber, lastPosition));
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [lastPosition, carList]);

	//filter Finder

	useEffect(() => {
		if (filterData) {
			let newCarList = carsData;
			if (filterData.category) {
				newCarList = newCarList.filter(car => car.category.title === filterData.category);
				console.log(newCarList)
			}
			if (filterData.selectLocation && filterData.selectLocation !== "Ubicacion") {
				newCarList = newCarList.filter(car => filterData.selectLocation === car.city.name);
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
		setCarList(carsData);
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
		carsData
	};
};

export default useProductList;
