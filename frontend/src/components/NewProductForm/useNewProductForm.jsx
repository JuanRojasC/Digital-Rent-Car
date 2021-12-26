import { useState, useEffect, useContext } from "react";
import useApi from "../../Hooks/useApi/useApi";
import { UserContext } from "../../Hooks/UserContext/UserContext";

const useNewProductForm = (setNewProductData) => {

	const [termsAndConditionsSelected, setTermsAndConditionsSelected] = useState([]);
	const {user, setUser, setLogged} = useContext(UserContext)
	const [formValues, setFormValues] = useState("");
	const [categories, setCategories] = useState();
	const [cities, setCities] = useState();
    const [specs,setSpecs] = useState();
	const [termsAndConditions, setTermsAndConditions] = useState();
	const [combustibleIcon, setCombustibleIcon] = useState();
	const [error, setError] = useState(undefined);
	const [imageIndex, setImageIndex] =  useState(1);
	const {
		response: categoriesData,
		error: categoriesError,
		loading: loadingCategories,
		setLoading: setLoadingCategories,
		setParamas: setCategoriesApi,
	} = useApi();
	const {
		response: citiesData,
		error: citiesError,
		loading: loadingCities,
		setLoading: setLoadingCities,
		setParamas: setCitiesApi,
	} = useApi();

	const {
		response: specsData,
		error: specsError,
		loading: loadingSpecs,
		setLoading: setLoadingSpecs,
		setParamas: setSpecsApi,
	} = useApi();
	const {
		response: termAndConditionsData,
		error: termAndConditionsError,
		loading: loadingTermAndConditions,
		setLoading: setLoadingTermAndConditions,
		setParamas: setTermAndConditionsApi,
	} = useApi();

	useEffect(() => {
		if(!user && localStorage.getItem("login")){
			setUser(JSON.parse(localStorage.getItem("login")));
			setLogged(true);
		}
	})

	useEffect(() => {
		if(user){
			setLoadingCategories(true);
			setCategoriesApi({
				method: "get",
				url: "/categories/find/all",
			});
			setLoadingCities(true);
			setCitiesApi({
				method: "get",
				url: "/cities/find/all",
			});
			setLoadingSpecs(true)
			setSpecsApi({
				method:"get",
				url:"/specs",
				headers:{"Authorization":user.jwt}
			})
			setLoadingTermAndConditions(true)
			setTermAndConditionsApi({
				method: "get",
				url: "/terms-and-coditions/find/all",
				headers: { "Authorization": user.jwt },
			});
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [user]);

	useEffect(() => {
		if(categoriesData) setCategories(categoriesData);
		if(citiesData) setCities(citiesData);
		if(specsData) setSpecs(specsData);
		if(termAndConditionsData) setTermsAndConditions(termAndConditionsData);
		matchValuesFormToObject();
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [categoriesData, citiesData, specsData, termAndConditionsData]);

	useEffect(()=>{
		if(categoriesError && citiesError && specsError&& termAndConditionsError) setError("Algo a salido mal")
	},[categoriesError,citiesError,specsError,termAndConditionsError])

	useEffect(()=>{
		if(formValues !== ""){
			if(specs.combustible.find(spec => spec.name === formValues.combustible)!==undefined) {
				setCombustibleIcon(specs.combustible.find(spec => spec.name === formValues.combustible))
			}
			matchValuesFormToObject();
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	},[formValues])

	/*----------Fuction For update Product Object----------*/
	const handleChange = (e) => {
		const termsAndConditionsOptions = document.querySelectorAll('.form_new_product_divider_terms_and_conditions_item input[type="checkbox"]');
		setTermsAndConditionsSelected((Array.from(termsAndConditionsOptions)).map(tyc => tyc.checked? parseInt(tyc.getAttribute("data-id")) : ""))
		setFormValues({ ...formValues, [e.target.name]: e.target.value });
	};

	/*----------Fuction Creator of product Object----------*/
	const matchValuesFormToObject = () =>{

		const managmentImagesForm = () => {
			let images = [];
			const inputsImagesColor = [				
				{title: "White", urlImage: formValues.image_vehicle_White},
				{title: "Black", urlImage: formValues.image_vehicle_Black},
				{title: "Red", urlImage: formValues.image_vehicle_Red},
				{title: "Blue", urlImage: formValues.image_vehicle_Blue}
			];
			const inputsImagesGallery = Array.apply(null, Array(imageIndex)).map((e, index) => formValues[`image_vehicle_${index+1}`])
			inputsImagesColor.forEach(img => img.urlImage? images.push(img) : "");
			inputsImagesGallery.forEach(img => img? images.push({title: "", urlImage: img}) : "");
			return images;
		}

		managmentImagesForm();

		setNewProductData({ 
			name: formValues.name? formValues.model? formValues.name + " " + formValues.model : formValues.name : "",
			description: formValues.description,
			category: categories?.find(c => c.id === parseInt(formValues.categories)),
			city: cities?.find(c => c.id === parseInt(formValues.cities)),
			specs: {
				enginePower: {
					name: "enginePower",
					value: formValues.enginePower,
					icon: specs?.enginePower.icon
				},
				airConditioning: {
					name: "airConditioning",
					value: formValues.airConditioning,
					icon: specs?.airConditioning.icon
				},
				seats: {
					name: "seats",
					value: formValues.seats,
					icon: specs?.seats.icon
				},
				combustible: {
					name: "combustible",
					value: formValues.combustible,
					icon: formValues.combustible === "electric"? specs?.combustible[2].icon : specs?.combustible[0].icon
				}
			},
			images: managmentImagesForm(),
			termsAndConditions: termsAndConditions?.filter(tyc => termsAndConditionsSelected.find(t => tyc.id === t? tyc : ""))
		});
	}

	return {
		handleChange,
		setFormValues,
		categories,
		cities,
		specs,
		termsAndConditions,
		loadingCategories,
		loadingCities,
		loadingSpecs,
		loadingTermAndConditions,
		formValues,
		combustibleIcon,
        error,
		imageIndex,
		setImageIndex,
	};
};

export default useNewProductForm;
