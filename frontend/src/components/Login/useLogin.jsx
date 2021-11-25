import { useState, useContext } from "react";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import { useHistory } from "react-router-dom";
import axios from "axios";


export const useLogin = (userList) => {
	const history = useHistory();
	const [showPass, setShowPass] = useState({ type: "password", icon: faEye });
	const [error, setError] = useState(false);
	const { setUser, setLogged } = useContext(UserContext);

	const handlePass = () => {
		if (showPass.type === "password") {
			setShowPass({ type: "text", icon: faEyeSlash });
		} else {
			setShowPass({ type: "password", icon: faEye });
		}
	};

	const handleSubmit = (e) => {
		e.preventDefault();

		const userEmail = e.target[0].value;
		const userPass = e.target[1].value;

		if (userPass.length >= 6) {
			const data = JSON.stringify({
				email: userEmail,
				password: userPass,
			});

			const headerTokenRequest = {
				method: "POST",
				url: "http://localhost:8080/auth/login",
				headers: {
					"Content-Type": "application/json",
				},
				data: data,
			};

			const userDataRequest = function (user) {
				return {
					method: "GET",
					url: `http://localhost:8080/users/find/email/${user.email}`,
					headers: {
						"authorization": user.authorization,
						"userAuth": user.authorization
					}
				};
			};

			axios(headerTokenRequest)
			.then((res) => {
				const email = JSON.parse(res.config.data).email
				return { email:email, authorization: res.data.jwt}
			}).catch(()=>{
				setError(true)
			})
			.then((userLogged)=>{
				axios(userDataRequest(userLogged))
				.then((res)=>{
					console.log(res.data);
					const auth = res.config.headers
					const user = {
						name: res.data.name,
						lastName:res.data.lastName,
						email:res.data.email,
						authorization: auth.userAuth
					}
					setUser(user)
					setLogged(true)
					history.push("/")
				})
				.catch(()=>{
					setError(true)
				})
			})
		}else{
			setError(true)
		}
	};

	return {
		showPass,
		error,
		handleSubmit,
		handlePass,
	};
};
