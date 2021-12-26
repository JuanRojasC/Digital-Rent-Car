import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import { Link } from "react-router-dom";
import { useLogin } from "./useLogin";

import "./login.css";

export default function Login(props) {
	const { showPass, error,loadingLoggin, handleSubmit, handlePass, handleChange } =
		useLogin();

	return (
		<div data-testid="login_component" className='container_form_login'>
			<div className='icon_group'>
				<FontAwesomeIcon icon={faUser} className='icon_user_logIn' />
				<h1>Iniciar sesión</h1>
			</div>
			<form
				onChange={handleChange}
				onSubmit={handleSubmit}
				className='form_login'>
				<div className='form_login_group'>
					<label htmlFor='email'>Correo electrónico</label>
					<input type='email' name='email' required />
				</div>
				<div className='form_login_group'>
					<label htmlFor='password'>Contraseña</label>
					<input type={showPass.type} name='password' />
					<FontAwesomeIcon
						icon={showPass.icon}
						className='show_hide_password_icon'
						onClick={handlePass}
					/>
				</div>
				{(loadingLoggin) && <div className="form_login_bar"></div>}
				{error && <p className='login_error'>{error}</p>}
				<button type='submit'>Ingresar</button>
			</form>
			<div className='form_login_text_signup'>
				<p>¿Aun no estas registrado?</p>
				<Link to='/registro'>Registrate</Link>
			</div>
		</div>
	);
}
