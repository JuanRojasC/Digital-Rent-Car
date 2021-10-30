import React , {useState} from "react";
import { Link } from "react-router-dom";

import "./signin.css";

export default function Signin() {

    const [formValues, setFormValues] = useState('');


    const handleChange = (e) =>{
        setFormValues({...formValues, 
            [e.target.name] : e.target.value})
    }

    const handleSubmit = (e)=>{
        e.preventDefault()
        console.log(e);
        if(e.target[2].value !== e.target[3].value){
            alert('los correos deben coincidir')
        }
    }

	return (
		<div className='container_form_registro'>
			<h1>Registro</h1>

			<form onChange={handleChange} onSubmit={handleSubmit} className='form_registro'>
				<div className='form_registro_divider'>
					<div className='form_registro_group'>
						<label>Nombre</label>
						<input type='text' name='Nombre' required/>
					</div>
					<div className='form_registro_group'>
						<label>Apellido</label>
						<input type='text' name='Apellido' required/>
					</div>
				</div>
				<div className='form_registro_group'>
					<label>Correo Electronico</label>
					<input type='email' name='email' required/>
				</div>
				<div className='form_registro_group'>
					<label>Confirmacion Correo Electronico</label>
					<input type='email' name='Verificacion' required/>
				</div>
				<div className='form_registro_group'>
					<label>Contraseña</label>
					<input type='password' name='contrasena' required/>
				</div>
				<button type='submit'>Registrarse</button>
			</form>
			<p className="form_login_text">¿Ya tienes cuenta? <Link to="/login">Inicia Sesión</Link></p>
		</div>
	);
}
