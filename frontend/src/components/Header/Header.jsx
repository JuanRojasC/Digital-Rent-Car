import { useContext, useState, useEffect } from "react";
import { Link, useHistory } from "react-router-dom";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import { isMobile } from "react-device-detect";
import HeaderDesktop from "./HeaderDesktop";
import HeaderMobile from "./HeaderMobile";
import logo from "../../Assets/Digital Rent Car Company - Full.png";
import "./header.css";
import MenuMobile from "../MenuMobile/MenuMobile";
import useMenuMobile from "../../Hooks/UseMenuMobile/useMenuMobile";

export default function Header(props) {
	let { user, logged, setLogged, setUser } = useContext(UserContext);
	let [deployMenu, setDeployMenu] = useMenuMobile(".header_menu_mobile");
	let history = useHistory();
	let [isPhone] = useState(isMobile && window.innerWidth < 480);

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
		};
	};

	const storeScroll = () => {
		document.documentElement.dataset.scroll = window.scrollY;
	};
	// Listen for new scroll events, here we debounce our `storeScroll` function
	document.addEventListener("scroll", debounce(storeScroll), { passive: true });
	// Update scroll position for first time
	storeScroll();

	const logOut = () => {
		setLogged(false);
		localStorage.clear();
		sessionStorage.clear();
	};

	const handleClickUserIcon = ()=>{
		if(user.role.name === "user"){
			history.push(`/reservas`)
		}else{
			history.push(`/vehiculos/nuevo`)
		}
	}

	useEffect(() => {}, [logged]);

	useEffect(() => {
		if(!user && localStorage.getItem("login")){
			setUser(JSON.parse(localStorage.getItem("login")));
			setLogged(true);
		}
	})

	return (
		<>
			<div className='header_landing_page'>
				<Link to=''>
					<img src={logo} alt='Logo de la Compa??ia' className='logo_company_header' />
				</Link>
				{isPhone ? (
					<HeaderMobile setMenuDeploy={setDeployMenu} />
				) : (
					<HeaderDesktop
						userLogged={logged}
						userData={user}
						logOut={logOut}
						headerMain={props.headerMain}
						handleClickUserIcon ={handleClickUserIcon}
					/>
				)}
			</div>
			{/*-----Out becuase has position absolute-----*/}
			<MenuMobile
				deployMenu={deployMenu}
				setMenuDeploy={setDeployMenu}
				userLogged={logged}
				userData={user}
				logOut={logOut}
				handleClickUserIcon={handleClickUserIcon}
			/>
		</>
	);
}
