import React from "react";
import { Link, BrowserRouter as Router } from "react-router-dom";

import { useSignin } from "./useSignin";

import "./signin.css";

export default function Signin() {
	const { handleChange, handleSubmit } = useSignin("");

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
						<input type='text' name='Nombre' required />
					</div>
					<div className='form_registro_group'>
						<label>Apellido</label>
						<input type='text' name='Apellido' required />
					</div>
				</div>
				<div className='form_registro_group'>
					<label>Correo Electronico</label>
					<input type='email' name='email' required />
				</div>
				<div className='form_registro_group'>
					<label>Contraseña</label>
					<input type='password' name='contrasena' required />
				</div>
				<div className='form_registro_group'>
					<label>Confirmar Contraseña</label>
					<input type='password' name='contrasena' required />
				</div>
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
