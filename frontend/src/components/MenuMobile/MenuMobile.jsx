import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTimes } from "@fortawesome/free-solid-svg-icons";
import { faFacebook, faTwitter, faInstagram, faYoutube } from "@fortawesome/free-brands-svg-icons";

import "./menu_mobile.css";

export default function MenuMobile({ userLogged, userData, logOut, setMenuDeploy,handleClickUserIcon }) {
	return !userLogged ? (
		<div className='header_menu_mobile'>
			<div className='header_menu_mobile_div'>
				<FontAwesomeIcon
					icon={faTimes}
					className='header_close_menu_mobile'
					onClick={() => setMenuDeploy(false)}
				/>
				<h3 className='menu_title_nav_header_mobile'>MENU</h3>
				<Link
					to='/'
					className='btn_nav_header_mobile'
					onClick={() => setMenuDeploy(false)}>
					Inicio
				</Link>
				<hr className='line_horizontal_menu_mobile' />
				<Link
					to='/login'
					className='btn_nav_header_mobile'
					onClick={() => setMenuDeploy(false)}>
					Login
				</Link>
				<hr className='line_horizontal_menu_mobile' />
				<Link
					to='/registro'
					className='btn_nav_header_mobile'
					onClick={() => setMenuDeploy(false)}>
					Registrarse
				</Link>
				<div className='social_networks_logos_mobile_menu'>
					<Link to=''>
						<FontAwesomeIcon
							icon={faFacebook}
							className='icon_social_network_mobile_menu'
						/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon
							icon={faYoutube}
							className='icon_social_network_mobile_menu'
						/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon
							icon={faInstagram}
							className='icon_social_network_mobile_menu'
						/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon
							icon={faTwitter}
							className='icon_social_network_mobile_menu'
						/>
					</Link>
				</div>
			</div>
		</div>
	) : (
		<div className='header_menu_mobile'>
			<div className='header_menu_mobile_div'>
				<FontAwesomeIcon
					icon={faTimes}
					className='header_close_menu_mobile'
					onClick={() => setMenuDeploy(false)}
				/>
				<div className='menu_title_nav_header_mobile'>
					<div onClick={handleClickUserIcon}  className='nav_header_profile_user'>
						<div className='circle_user_profile'>
							{userData.name.slice(0, 1) + userData.lastName.slice(0, 1)}
						</div>
						<p className='user_profile_greeting'>Hola</p>
						<p className='user_title'>
							{userData.name.split(" ")[0] + " " + userData.lastName.split(" ")[0]}
						</p>
					</div>
				</div>
				<Link to='/' className='btn_nav_header_mobile' onClick={() => setMenuDeploy(false)}>
					Inicio
				</Link>
				<hr className='line_horizontal_menu_mobile' />
				{
					userData.role.name === "admin"? 
					<Link to="/vehiculos/nuevo" className='btn_nav_header_mobile' onClick={() => setMenuDeploy(false)}>
						Productos
					</Link> 
					:
					userData.role.name === "user"?
					<Link to="/reservas" className='btn_nav_header_mobile' onClick={() => setMenuDeploy(false)}>
						Reservas
					</Link>
					:
					""
				}
				<hr className='line_horizontal_menu_mobile' />
				<Link to='/' className='btn_nav_header_mobile' id='btn_logout_mobile' onClick={() => {
						setMenuDeploy(false);
						logOut();
					}}>
					Cerrar sesion
				</Link>
				<hr className='line_horizontal_menu_mobile' />
				<div className='social_networks_logos_mobile_menu'>
					<Link to=''>
						<FontAwesomeIcon icon={faFacebook} className='icon_social_network_mobile_menu'/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon icon={faYoutube} className='icon_social_network_mobile_menu'/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon icon={faInstagram} className='icon_social_network_mobile_menu'/>
					</Link>
					<Link to=''>
						<FontAwesomeIcon icon={faTwitter} className='icon_social_network_mobile_menu'/>
					</Link>
				</div>
			</div>
		</div>
	);
}
