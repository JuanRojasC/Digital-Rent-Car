import { useState, useEffect } from "react";
import { isMobile } from "react-device-detect";
import useApi from "../../Hooks/useApi/useApi";

export const useProduct = () => {

	const [ error ] = useState({ is: false, text: "" });
	const [ product, setProduct ] = useState(undefined);
	const [ isPhone ] = useState(isMobile && window.innerWidth < 480);
	const { response: productData, setParamas: setProductParams } = useApi();
	const [ id ] = useState(parseInt(localStorage.getItem("resource_car_id")));
	const [ storagedProduct ] = useState(JSON.parse(localStorage.getItem("resource_object_car")));
	

	useEffect(() => {
		/*ProductData is modified*/
		if(id !== null && !id !== undefined){
			setProductParams({
				method: "GET",
				url: `/products/find/${id}`,
			});
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	useEffect(() => {
		if(productData === undefined || productData === null){
			setProduct(storagedProduct)
		}else{
			setProduct(productData);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [productData]);

	return {
		error,
		product,
		isPhone,
	};
};
