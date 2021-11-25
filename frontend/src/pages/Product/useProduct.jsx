import { useState, useEffect } from "react";
import { isMobile } from "react-device-detect";
import { useParams } from "react-router";
import { useContext } from "react";
import { ProductListContext } from "../../Hooks/ProductListContext/ProductListContext";


export const useProduct = () => {
	const { id } = useParams();
	const {carData} = useContext(ProductListContext);
	const car = carData.find((ele) => ele.id === parseInt(id));
	const [product, setProduct] = useState(car);
	const [error, setError] = useState({ is: false, text: "" });
	let [isPhone] = useState(isMobile && window.innerWidth < 480);

	useEffect(() => {
		const car = carData.find((ele) => ele.id === parseInt(id));
		if (car) {
			setProduct(car);
		} else {
			setError({ is: true, text: "No se encontro producto" });
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [id]);

	return {
		error,
		product,
		isPhone,
	};
};
