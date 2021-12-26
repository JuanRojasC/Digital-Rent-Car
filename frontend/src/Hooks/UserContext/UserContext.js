import React, { useState } from "react";
import { useLocalStorage } from "./useLocalStorage";
import useUserContext from "./useUserContext";

const UserContext = React.createContext(null);

function UserProvider(props) {
	const { user, setUser, logged, setLogged } = useLocalStorage();
	const { productBooking, setProductBooking, rangeDate, setRangeDate } = useUserContext();
	const [ bookingInfo, setBookingInfo ] = useState([]);

	return (
		<UserContext.Provider
			value={{
				user,
				setUser,
				logged,
				setLogged,
				productBooking,
				setProductBooking,
				rangeDate,
        		setRangeDate,
				setBookingInfo,
				bookingInfo
			}}>
			{props.children}
		</UserContext.Provider>
	);
}

export { UserContext, UserProvider };