import { useState } from "react"


const useFiltersFinder = () => {
    
    const [filterData, setFilterData] = useState(null);
    const [formValues, setFormValues] = useState({
        selectLocation: "Ubicacion",
        pickUpDate: "",
        dropOffDate: "",
        category:""
    });

    const handleChange = (e) =>{
        setFormValues({...formValues,[e.target.name]: e.target.value})
    }

    const handleOnSubmit = (e) =>{
        e.preventDefault()    
        setFilterData({...formValues,category:filterData ? filterData.category ? filterData.category: "" : "" });
    }

    return {filterData,setFilterData,handleChange,handleOnSubmit,setFormValues,formValues}
}

export default useFiltersFinder