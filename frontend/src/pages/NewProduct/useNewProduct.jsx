import { useContext, useEffect, useState } from "react";
import useApi from "../../Hooks/useApi/useApi";
import {UserContext} from "../../Hooks/UserContext/UserContext";

const useNewProduct = () => {

    const { user, setUser } = useContext(UserContext)
    const [ newProductData, setNewProductData] = useState("");
    const [ clean ,setClean ] = useState(false); 
    const {
		response: productResponse,
		setParamas: setProductApi,
	} = useApi();

    useEffect(() => {
		if(!user && localStorage.getItem("login")){
			setUser(JSON.parse(localStorage.getItem("login")));
		}
	})

    const handleSubmit =()=>{
        console.log(JSON.stringify(newProductData? newProductData : {}))
        setProductApi({
			method: "POST",
			url: `/products/save/new`,
			headers: { authorization: user.jwt },
			data: {...newProductData}
		})
        alert("Producto Creado Exitosamente");
        setClean(true);
    }

    useEffect(() => {console.log(productResponse)}, [productResponse])

    return {
        handleSubmit,
        newProductData,
        setNewProductData,
        clean,
        setClean
    }

}

export default useNewProduct
