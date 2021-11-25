import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import { useLogin } from "./useLogin";

import userList from "../../Assets/jsons/userList.json";

import "./login.css";

export default function Login(props) {
	const { showPass, error, handleSubmit, handlePass } = useLogin(userList);

	return (
		<div className='container_form_login'>
			<div className='icon_group'>
				<FontAwesomeIcon icon={faUser} className='icon_user_logIn' />
				<h1>Iniciar sesión</h1>
			</div>
			<form onSubmit={handleSubmit} className='form_login'>
				<div className='form_login_group'>
					<label>Correo electrónico</label>
					<input type='email' required />
				</div>
				<div className='form_login_group'>
					<label>Contraseña</label>
					<input type={showPass.type} />
					<FontAwesomeIcon
						icon={showPass.icon}
						className='show_hide_password_icon'
						onClick={handlePass}
					/>
				</div>
				{error && <p className='login_error'>credenciales inválidas*</p>}
				<button type='submit'>Ingresar</button>
			</form>
			<div className='form_login_text_signup'>
				<p>¿Aun no estas registrado?</p>
				<Link to='/registro'>Registrate</Link>
			</div>
		</div>
	);
}
