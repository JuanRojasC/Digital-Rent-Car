import { useState } from "react";

const useUserContext = () => {
    const [productBooking,setProductBooking] = useState();
    const [rangeDate,setRangeDate] = useState();
    
    return{
        productBooking,
        setProductBooking,
        rangeDate,
        setRangeDate
    }
}

export default useUserContext