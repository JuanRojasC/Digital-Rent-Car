import axios from "axios";
import { useContext, useState } from "react";
import { useHistory } from "react-router";
import { UserContext } from "../../Hooks/UserContext/UserContext";

export const useSignin = (initialValue) => {
	const [formValues, setFormValues] = useState(initialValue);
	const history = useHistory();
	const {setUser, setLogged} = useContext(UserContext);

	const handleChange = (e) => {
		setFormValues({ ...formValues, [e.target.name]: e.target.value });
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		if (e.target[3].value !== e.target[4].value) {
			alert("los contraseñas deben coincidir");
		} else {
			const userData = JSON.stringify({
				name: e.target[0].value,
				lastName: e.target[1].value,
				email: e.target[2].value,
				password: e.target[3].value,
			});

			const userRegisterRequest = {
				method: "post",
				url: "http://localhost:8080/auth/save/new",
				headers: {
					"Content-Type": "application/json",
				},
				data: userData
			};

			const headerTokenRequest = function (data) {
				return {
					method: "POST",
					url: "http://localhost:8080/auth/login",
					headers: {
						"Content-Type": "application/json",
					},
					data: data,
				};
			};

			axios(userRegisterRequest)
			.then((res) => {
				console.log(res.data);
				return res.data
			})
			.catch((e)=>{
				alert("error en el registro")
			})
			.then((data)=>{
				const user = {
					email : data.email,
					password : e.target[3].value
				}
				axios(headerTokenRequest(user))
				.then((res)=>{
					const user = {
						name: data.name,
						lastName:data.lastName,
						authorization: res.data.jwt
					}
					setUser(user)
					setLogged(true)
					history.push("/")
				})
				.catch((e)=>{
					alert("error en el registro")
				})
			})
		}
	};

	return {
		handleChange,
		handleSubmit,
	};
};
