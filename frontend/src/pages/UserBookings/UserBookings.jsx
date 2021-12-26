import { useEffect, useContext, useState } from 'react'
import { UserContext } from "../../Hooks/UserContext/UserContext";
import MainBooking from '../../components/MainBooking/MainBooking';
import useApi from "../../Hooks/useApi/useApi";
import BookingCard from '../../components/BookingCard/BookingCard';
import "./user_bookings.css";
import NotBookings from '../../components/NotBookings/NotBookings';

export default function UserBookings() {

    let { user, setLogged, setUser } = useContext(UserContext);
    const { response, setParamas } = useApi();
    const [ bookings, setBookings ] = useState([])

	useEffect(() => {
		if(user === null && localStorage.getItem("login")){
			setUser(JSON.parse(localStorage.getItem("login")));
			setLogged(true);
		}
        // eslint-disable-next-line react-hooks/exhaustive-deps
	})

    useEffect(() => {
        if(user !== null){
            setParamas({
                method: "GET",
                url: `/bookings/find/user/${user.id}`,
                headers: { authorization: user.jwt },
            })
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [user])

    useEffect(() => {
        if(response){
            setBookings(response.sort((a, b) => b.id - a.id));
        }
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [response])

    useEffect(() => {}, [bookings])

    return (
        bookings.length > 0?
        <div>
            <div className='bookings_navbar product_navbar'>
				<div className='product_navbar_data'>
					<h2>Mis Reservas</h2>
				</div>
			</div>
            <MainBooking booking={bookings[0]}/>
            <h3 className="my_bookings_title">Mis Reservas</h3>
            <div className="user_bookings_cards">
                {bookings.slice(1, bookings.length - 1).map((booking, index) => <BookingCard booking={booking} key={index} />)}
            </div>
            <div className="bookings_customer_service_div">
                <img src="/s3-bucket/icons/customer-service.png" alt="Customer Service" className="bookings_customer_service_icon" />
            </div>
        </div>
        :
        <NotBookings />
    )
}
