import axios from "axios";
import { useState, useEffect } from "react";

const useCategoriesCards = () => {
	const [categoryClicked, setCategoryClicked] = useState(null);
	const [categoriesList, setCategoriesList] = useState([]);

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
		axios
			.get(
				"http://localhost:8080/categories/find/all"
			)
			.then((res) => {
				setCategoriesList(res.data);
			});
	}, []);

	return { categoryClicked, setCategoryClicked, categoriesList };
};

export default useCategoriesCards;
