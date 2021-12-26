import { useState, useEffect } from "react";
import useApi from "../useApi/useApi";

const useCategoriesCards = () => {
	const [categoryClicked, setCategoryClicked] = useState(false);
	const [categoriesList, setCategoriesList] = useState([]);
	const {
		response: categoriesData,
		setParamas: setCategoriesParams,
	} = useApi();

	useEffect(() => {
		let categoriesCards = Array.from(
			document.querySelectorAll(".category_card")
		);
		let categoriesCardsDisable = categoriesCards.filter(
			(card) => card.id !== categoryClicked
		);
		categoriesCardsDisable.forEach((card) => {
			card.style.border = "1px solid white";
			card.style.backgroundColor = "var(--gray-color)";
		});
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [categoryClicked]);
	
	useEffect(() => {
		setCategoriesParams({
			method: "GET",
			url: `/categories/find/all`
		})
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	useEffect(()=>{
		if(categoriesData){
			setCategoriesList(categoriesData)
		}
	},[categoriesData])

	return { categoryClicked, setCategoryClicked, categoriesList };
};

export default useCategoriesCards;
