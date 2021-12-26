import { Link } from "react-router-dom";
import "./header.css";

export default function HeaderDesktop({
	userLogged,
	userData,
	logOut,
	headerMain,
	handleClickUserIcon,
}) {
	return !userLogged ? (
		<>
			<div className='btns_nav_header'>
				<Link to='/' className='btn_nav_header'>
					Inicio
				</Link>
				<Link data-testid="login_btn" to='/login' className='btn_nav_header'>
					Login
				</Link>
				<Link to='/registro' className='btn_nav_header'>
					Registrarse
				</Link>
			</div>
			{headerMain ? (
				<div className='form_header'>
					<form>
						<select
							name='select_country_header'
							id='select_country_header'
							className='select_header_landing_page'>
							<option value='Argentina'>Argentina</option>
							<option value='Colombia'>Colombia</option>
						</select>
						<select
							name='select_coin_header'
							id='select_coin_header'
							className='select_header_landing_page'>
							<option value='USD'>USD</option>
							<option value='ARS'>ARS</option>
							<option value='COP'>COP</option>
						</select>
					</form>
				</div>
			) : (
				""
			)}
		</>
	) : (
		<>
			{
			userData?
				<div className='btns_nav_header'>
				<div onClick={handleClickUserIcon} className='nav_header_profile_user'>
					<div className='circle_user_profile'>
						<span>{userData.name.slice(0, 1) + userData.lastName.slice(0, 1)}</span>
					</div>
					<div className='nav_header_profile_text'>
						<p className='user_profile_greeting'>Hola</p>
						<p className='user_title'>
							{userData.name.split(" ")[0] + " " + userData.lastName.split(" ")[0]}
						</p>
					</div>
				</div>
				{
					userData.role.name === "admin"? 
					<Link to="/vehiculos/nuevo" className="btn_nav_header btn_nav_header_simple">
						Productos
					</Link> 
					:
					userData.role.name === "user"?
					<Link to="/reservas" className="btn_nav_header btn_nav_header_simple">
						Reservas
					</Link>
					:
					""
				}
				<Link
					to='/'
					className='btn_nav_header btn_nav_header_simple btn_nav_header_logout'
					onClick={logOut}>
					Cerrar sesion
				</Link>
			</div>
			:
			""
		}
		</>
	);
}