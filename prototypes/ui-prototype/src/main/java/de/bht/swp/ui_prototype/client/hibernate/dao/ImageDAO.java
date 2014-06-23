package de.bht.swp.ui_prototype.client.hibernate.dao;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Image;
import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;

/**
 * Data Access Object for Image
 */
public class ImageDAO {

	/**
	 * Create a new image or update an existing one
	 * 
	 * @param Image
	 *            image to be persisted
	 */
	public void saveOrUpdateImage(Image image) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(image);
	}

	/**
	 * Retrieve an image from the data store
	 * 
	 * @param imageId
	 *            identifier of the image to be retrieved
	 * @return image represented by the identifier provided
	 */
	public Image getImage(long imageId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Image image = (Image) session.get(Image.class, imageId);
		return image;
	}

	/**
	 * Delete image from data store
	 * 
	 * @param image
	 *            image to be deleted
	 */
	public void deleteImage(Image image) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(image);
	}
	
}
