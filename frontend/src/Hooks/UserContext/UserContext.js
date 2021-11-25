import React from "react";
import { useLocalStorage } from "./useLocalStorage";
import useUserContext from "./useUserContext";

const UserContext = React.createContext(null);

function UserProvider(props) {
	const { user, setUser, logged, setLogged } = useLocalStorage();
	const {productBooking,setProductBooking,rangeDate,setRangeDate} = useUserContext();

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
        		setRangeDate
			}}>
			{props.children}
		</UserContext.Provider>
	);
}

export { UserContext, UserProvider };