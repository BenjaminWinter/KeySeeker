package de.bht.swp.ui_prototype.client.hibernate.Service;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Image;
import de.bht.swp.ui_prototype.client.hibernate.dao.ImageDAO;


/**
 * Service layer for Image
 */
public class ImageService {
	ImageDAO imageDAO = new ImageDAO();

	/**
	 * Create a new image or update an existing one
	 * 
	 * @param image
	 *            image to be persisted
	 */
	public void saveOrUpdateImage(Image image) {
		imageDAO.saveOrUpdateImage(image);
	}

	/**
	 * Retrieve an image
	 * 
	 * @param imageId
	 *            identifier of the image to be retrieved
	 * @return image represented by the identifier provided
	 */
	public Image getImage(long imageId) {
		return imageDAO.getImage(imageId);
	}

	/**
	 * Delete image
	 * 
	 * @param image
	 *            image to be deleted
	 */
	public void deleteImage(Image image) {
		imageDAO.deleteImage(image);
	}
}
