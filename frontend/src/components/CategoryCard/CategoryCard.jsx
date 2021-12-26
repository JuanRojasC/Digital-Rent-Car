import { useState, useEffect } from "react";
import "./category_card.css";

export default function CategoryCard(props) {
	let [clicked, setClicked] = useState(false);
	const [idCardCategory] = useState(`category_${props.title}`);
	const [titleCategory] = useState(props.title);

	useEffect(() => {
		if (clicked === true) {
			props.setCategoryClicked(titleCategory);
			document.querySelector(`#${idCardCategory}`).style.border = "1px solid black";
			document.querySelector(`#${idCardCategory}`).style.backgroundColor = "var(--primary-color)";
			setClicked(false);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [clicked]);

	return (
		<div id={idCardCategory} onClick={() => setClicked(true)} data-id={titleCategory} className='category_card'>
			<img src={props.image} alt='Category Visual Reference' className='category_card_image'/>
			<h3>{props.title}</h3>
		</div>
	);
}