import React, { createContext } from "react";
import useProductList from "./useProductList";

const ProductListContext = createContext(null);

function ProductListProvider(props) {
	const {
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
	} = useProductList();
	return (
		<ProductListContext.Provider
			value={{
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
			}}>
			{props.children}
		</ProductListContext.Provider>
	);
}

export { ProductListContext, ProductListProvider };
