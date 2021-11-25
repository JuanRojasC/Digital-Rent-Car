import { faTimes } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import ReactImageGallery from "react-image-gallery";

import Modal from "../Modal/Modal";

import "./galleryModal.css";

export default function GalleryModal({ img, show, handleModal }) {
	const handleClick = () => {
		handleModal();
	};

	const images = img;

	return (
		<Modal show={show}>
			<button onClick={handleClick} className='galleryModal_exitbtn'>
				<FontAwesomeIcon icon={faTimes} />
			</button>
			<ReactImageGallery
				items={images}
				showPlayButton={false}
				showFullscreenButton={false}
			/>
		</Modal>
	);
}
