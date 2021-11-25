import { useContext } from "react";
import CategoryCard from "../../components/CategoryCard/CategoryCard";
import { ProductListContext } from "../../Hooks/ProductListContext/ProductListContext";

export default function CategoriesCards(props) {
	
	const {categoriesList,setCategoryClicked} = useContext(ProductListContext);

	return (
		<div className='car_categories_landing_page_options'>
			{categoriesList.map((category, index) => (
				<CategoryCard
					key={index}
					id={index}
					title={category.title}
					image={category.image.urlImage}
					setCategoryClicked={setCategoryClicked}
				/>
			))}
		</div>
	);
}
