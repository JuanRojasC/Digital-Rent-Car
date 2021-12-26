import { faTimes } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import ReactImageGallery from "react-image-gallery";
import Modal from "../Modal/Modal";
import "./galleryModal.css";

export default function GalleryModal({ images, show, handleModal }) {

	const imagesGallery = images.map(function(image){ return {original: image.urlImage, thumbnail: image.urlImage} })

	return (
		<Modal show={show}>
			<button onClick={()=>handleModal()} className='galleryModal_exitbtn'>
				<FontAwesomeIcon icon={faTimes} />
			</button>
			<ReactImageGallery items={imagesGallery} showPlayButton={false} showFullscreenButton={false} />
		</Modal>
	);
}
