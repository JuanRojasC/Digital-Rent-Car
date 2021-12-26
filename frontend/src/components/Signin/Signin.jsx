import React from "react";
import { Link, BrowserRouter as Router } from "react-router-dom";

import { useSignin } from "./useSignin";

import "./signin.css";

export default function Signin() {
	const { handleChange, handleSubmit, loadingRegister, error } =
		useSignin("");

	return (
		<div className='container_form_registro'>
			<h1>Registro</h1>

			<form
				onChange={handleChange}
				onSubmit={handleSubmit}
				className='form_registro'>
				<div className='form_registro_divider'>
					<div className='form_registro_group'>
						<label>Nombre</label>
						<input id='name' type='text' name='name' required />
					</div>
					<div className='form_registro_group'>
						<label>Apellido</label>
						<input id='lastName' type='text' name='lastName' required />
					</div>
				</div>
				<div className='form_registro_group'>
					<label>Correo Electronico</label>
					<input id='email' type='email' name='email' required />
				</div>
				<div className='form_registro_group'>
					<label>Contraseña</label>
					<input id='password' type='password' name='password' required />
				</div>
				<div className='form_registro_group'>
					<label>Confirmar Contraseña</label>
					<input
						id='password_confirm'
						type='password'
						name='passwordConfirm'
						required
					/>
				</div>
				{loadingRegister && <div className='form_login_bar'></div>}
				{error && <p className='login_error'>{error}</p>}
				<button type='submit'>Registrarse</button>
			</form>
			<div className='form_registro_text'>
				<p>¿Ya tienes cuenta? </p>
				<Router>
					<Link to='/login'>Inicia Sesión</Link>
				</Router>
			</div>
		</div>
	);
}
