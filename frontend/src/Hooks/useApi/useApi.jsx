import { useState, useEffect } from "react";
import axios from "axios";


const useApi = () => {
	axios.defaults.baseURL = "http://3.139.103.7";
	
	const [response, setResponse] = useState(undefined);
	const [error, setError] = useState("");
	const [loading, setLoading] = useState(true);
	const [params, setParamas] = useState(undefined);

	const fetchData = async (params) => {
		if (params !== undefined) {
			try {
				const result = await axios.request(params);
				setResponse(result.data);
			} catch (error) {
				setError(error);
			} finally {
				setLoading(false);
			}
		}
	};

	useEffect(() => {
		fetchData(params);
	}, [params]);

	return { response, error, loading, setLoading, setParamas };
};

export default useApi;
