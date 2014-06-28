package de.bht.swp.ui_prototype.server.hibernate.Service;

import de.bht.swp.ui_prototype.client.DBObject.Image;
import de.bht.swp.ui_prototype.server.hibernate.DAO.ImageDAO;
import de.bht.swp.ui_prototype.server.hibernate.Util.DAOFactory;


/**
 * Service layer for Image
 */
public class ImageService {
	ImageDAO imageDAO = new DAOFactory().getImageDAO();

	/**
	 * Create a new image or update an existing one
	 * 
	 * @param image
	 *            image to be persisted
	 */
	public void saveOrUpdateImage(Image image) {
		imageDAO.saveOrUpdate(image);
	}

	/**
	 * Retrieve an image
	 * 
	 * @param imageId
	 *            identifier of the image to be retrieved
	 * @return image represented by the identifier provided
	 */
	public Image getImage(long imageId) {
		return imageDAO.get(imageId);
	}

	/**
	 * Delete image
	 * 
	 * @param image
	 *            image to be deleted
	 */
	public void deleteImage(Image image) {
		imageDAO.delete(image);
	}
}
