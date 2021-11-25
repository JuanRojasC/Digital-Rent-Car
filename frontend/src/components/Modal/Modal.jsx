import ReactDOM from "react-dom";

import "./modal.css";

export default function Modal(props) {
	if (!props.show) {
		return null;
	}
	return (
		<div>
			{ReactDOM.createPortal(
				<div className='Modal'>
					<div className='Modal_container'>{props.children}</div>
				</div>,
				document.getElementById("modal")
			)}
		</div>
	);
}
