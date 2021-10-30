import { useEffect } from "react/cjs/react.development";
import { useContext } from "react";
import { Link } from "react-router-dom";
import { UserContext } from "../UserContext/UserContext";
import { isMobile } from "react-device-detect";
import HeaderDesktop from "./HeaderDesktop";
import HeaderMobile from "./HeaderMobile";
import logo from "../../Assets/Digital Rent Car Company - Full.png";
import "./header.css";

export default function Header() {
	const { user, logged, setLogged } = useContext(UserContext);

	// The debounce function receives our function as a parameter
	const debounce = (fn) => {
		// This holds the requestAnimationFrame reference, so we can cancel it if we wish
		let frame;
		// The debounce function returns a new function that can receive a variable number of arguments
		return (...params) => {
			// If the frame variable has been defined, clear it now, and queue for next frame
			if (frame) { 
				cancelAnimationFrame(frame);
			}
			// Queue our function call for the next frame
			frame = requestAnimationFrame(() => {
				// Call our function and pass any params we received
				fn(...params);
			});
		} 
  	};

	const storeScroll = () => {
		document.documentElement.dataset.scroll = window.scrollY;
	}
	// Listen for new scroll events, here we debounce our `storeScroll` function
	document.addEventListener('scroll', debounce(storeScroll), { passive: true });	
	// Update scroll position for first time
	storeScroll();

	const logOut = () => {
		setLogged(false);
	}

	useEffect(()=>{},[logged])

	return (
		<div className='header_landing_page'>
			<Link to="" >
				<img src={logo} alt='Logo de la Compañia' className='logo_company_header' />
			</Link>
			{isMobile && window.innerWidth < 480? <HeaderMobile userLogged={logged} userData={user} logOut={logOut}/> 
						: 
					   <HeaderDesktop userLogged={logged} userData={user} logOut={logOut}/>}
		</div>
	);
}
