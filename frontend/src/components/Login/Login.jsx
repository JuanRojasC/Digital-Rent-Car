import { useState, useContext} from "react";
import { UserContext } from "../UserContext/UserContext";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEye, faEyeSlash, faUser } from "@fortawesome/free-solid-svg-icons";
import { Link, useHistory } from "react-router-dom";
import userList from "../../Assets/jsons/userList.json";
import "./login.css";

export default function Login(props) {
	const history = useHistory();
	const [showPass, setShowPass] = useState({ type: "password", icon: faEye });
	const [error, setError] = useState(false);
	const { setUser, setLogged} = useContext(UserContext);

	const handlePass = () => {
		if (showPass.type === "password") {
			setShowPass({ type: "text", icon: faEyeSlash });
		} else {
			setShowPass({ type: "password", icon: faEye });
		}
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		setTimeout(() => {
			const userEmail = e.target[0].value;
			const userPass = e.target[1].value;
			if (userPass.length >= 6) {
				const user = userList.find(
					(ele) => ele.email === userEmail.toLowerCase()
				);
				if (user) {
					if (user.email === userEmail && user.password === userPass) {
						setUser(user)
						setLogged(true)
						setError(false)
						history.push("/")
					} else {
						setError(true)
					}
				} else {
					setError(true)
				}
			} else {
				setError(true)
			}
		}, 1000);
	};

	return (
		<div className='container_form_login'>
			<div className='icon_group'>
				<FontAwesomeIcon icon={faUser} className="icon_user_logIn"/>
				<h1>Iniciar sesión</h1>
			</div>
			<form onSubmit={handleSubmit} className='form_login'>
				<div className='form_login_group'>
					<label>Correo electrónico</label>
					<input type='email' />
				</div>
				<div className='form_login_group'>
					<label>Contraseña</label>
					<input type={showPass.type} />
					<FontAwesomeIcon icon={showPass.icon} className="show_hide_password_icon" onClick={handlePass}/>
				</div>
				{error && (
					<p className="login_error">credenciales inválidas*</p>
				)}
				<button type='submit'>Ingresar</button>
			</form>
			<div className='form_login_text_signup'>
				<p>¿Aun no estas registrado?</p>
				<Link to='/registro'>Registrate</Link>
			</div>
		</div>
	);
}
