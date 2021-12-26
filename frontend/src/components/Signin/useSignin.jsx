import { useEffect, useState } from "react";
import { useHistory } from "react-router";
import useApi from "../../Hooks/useApi/useApi";

export const useSignin = (initialValue) => {
	const [formValues, setFormValues] = useState(initialValue);
	const [error,setError] = useState(undefined);
	const history = useHistory();
	const {
		response: registerData,
		error: registerError,
		loading: loadingRegister,
		setLoading: setLoadingRegister,
		setParamas: setRegisterApi,
	} = useApi();

	useEffect(()=>{
		setLoadingRegister(false)
		// eslint-disable-next-line react-hooks/exhaustive-deps
	},[])

	useEffect(() => {
		if (registerData !== undefined) {
			if(!error){
				history.push("/login")
				alert("verfica tu cuenta a través de tu correo electronico")
			}
		}
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, [registerData]);

	useEffect(()=>{
		const registerError500 = registerError && registerError.response.status === 500;
		const registerError400 = registerError && registerError.response.status === 400;

		if (registerError500) {
			setError("Ohh, a ocurrido un error intenta mas tarde");
		} else if(registerError400){
			setError("este correo ya esta siendo usado, intenta con otro")
		}
	},[registerError])

	const handleChange = (e) => {
		setFormValues({ ...formValues, [e.target.name]: e.target.value });
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		setError(undefined)
		if (formValues.password !== formValues.passwordConfirm) {
			setError("los contraseñas deben coincidir");
		} else {
			e.target.disabled = true;
			const userData = JSON.stringify({
				name: formValues.name,
				lastName: formValues.lastName,
				email: formValues.email,
				password: formValues.password,
			});
			setLoadingRegister(true)
			setRegisterApi({
				method: "post",
				url: "/auth/save/new",
				headers: {
					"Content-Type": "application/json",
				},
				data: userData,
			});
			e.target.disabled=false;
		}
	};

	return {
		handleChange,
		handleSubmit,
		loadingRegister,
		error
	};
};
