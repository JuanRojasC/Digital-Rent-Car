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
		carsData
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
				carsData
			}}>
			{props.children}
		</ProductListContext.Provider>
	);
}

export { ProductListContext, ProductListProvider };
