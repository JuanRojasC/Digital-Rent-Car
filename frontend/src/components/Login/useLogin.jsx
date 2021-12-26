import { useState, useContext, useEffect } from "react";
import { UserContext } from "../../Hooks/UserContext/UserContext";
import { faEye, faEyeSlash } from "@fortawesome/free-solid-svg-icons";
import { useHistory } from "react-router-dom";
import useApi from "../../Hooks/useApi/useApi";

export const useLogin = () => {
	const history = useHistory();
	const [showPass, setShowPass] = useState({ type: "password", icon: faEye });
	const [loginForm, setLoginForm] = useState({ email: "", password: "" });
	const [error, setError] = useState(undefined);
	const { setUser, setLogged } = useContext(UserContext);
	const {
		response: loginData,
		error: loginError,
		loading: loadingLoggin,
		setLoading: setLoadingLogin,
		setParamas: setLoginApi,
	} = useApi();

	useEffect(() => {
		setLoadingLogin(false);
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);

	//request userData
	useEffect(() => {
		if (loginData !== undefined) {
			setUser({
				id: loginData.user.id,
				name: loginData.user.name,
				lastName: loginData.user.lastName,
				email: loginData.user.email,
				role: loginData.user.role,
				jwt: loginData.jwt,
			});
			setLogged(true);
			localStorage.setItem("login",JSON.stringify({...loginData.user, jwt: loginData.jwt, role: loginData.user.role}))
			history.push(localStorage.getItem("resource_object_car")? `/reservacion/${JSON.parse(localStorage.getItem("resource_object_car")).name.replace(" ", "-")}` : `/`);
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [loginData]);

	useEffect(() => {
		const loginError500 = loginError && loginError.response.status === 500;
		const loginError404 = loginError && loginError.response.status === 404;
		const loginError400 = loginError && loginError.response.status === 400;

		if (loginError500) {
			setError("Ohh, a ocurrido un error intenta mas tarde");
		} else if (loginError404) {
			setError("Credenciales invalidas, intentalo de nuevo");
		} else if (loginError400) {
			setError("Esta cuenta aun no a sido verficada");
		}
	}, [loginError]);

	const handleSubmit = (e) => {
		e.preventDefault();
		//request jwt
		if (loginForm.password.length >= 6) {
			e.target[0].disabled = true;
			e.target[1].disabled = true;
			setLoadingLogin(true);
			setLoginApi({
				method: "POST",
				url: "/auth/login",
				headers: { "Content-Type": "application/json" },
				data: JSON.stringify(loginForm),
			});
			e.target[0].disabled = false;
			e.target[1].disabled = false;
		} else {
			setError("Credenciales invalidas");
		}
	};

	const handlePass = () => {
		if (showPass.type === "password") {
			setShowPass({ type: "text", icon: faEyeSlash });
		} else {
			setShowPass({ type: "password", icon: faEye });
		}
	};

	const handleChange = (e) => {
		setLoginForm({ ...loginForm, [e.target.name]: e.target.value });
	};

	return {
		showPass,
		error,
		loadingLoggin,
		handleSubmit,
		handlePass,
		handleChange,
	};
};
