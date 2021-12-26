import Moment from "moment";
import { extendMoment } from "moment-range";
import { useEffect, useState } from "react";
//import { UserContext } from "../../Hooks/UserContext/UserContext";

const useBookingData = () => {

    const moment = extendMoment(Moment);
    //const {rangeDate} = useContext(UserContext);
    const [value,/*setValue*/] = useState(moment());
    const [pickUpHoursOptions,setPickUpHoursOptions] =useState([]);
    const [dropOffHoursOptions,setDropOffHoursOptions] =useState([]);

    const pickUpEndDay = value.clone().endOf("day").startOf("hour");
    const dropOffEndDay = value.clone().endOf("day").startOf("hour");  
    
    useEffect(()=>{
        const pickUpHours = value.clone().startOf("day").startOf("hour");
        const dropOffHours = value.clone().startOf("day").startOf("hour");  
        const a = []
        const b = []
        while(pickUpHours.isBefore(pickUpEndDay,"hour")){
            a.push(pickUpHours.add(1, "hour").clone())
        }
        while(dropOffHours.isBefore(dropOffEndDay,"hour")){
            b.push(dropOffHours.add(1, "hour").clone())
        }
       setPickUpHoursOptions(a);
       setDropOffHoursOptions(b);
       // eslint-disable-next-line react-hooks/exhaustive-deps
    },[])
    
    return{
        value,
        pickUpHoursOptions,
        dropOffHoursOptions
    }
}

export default useBookingData