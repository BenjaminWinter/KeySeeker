package de.bht.swp.ui_prototype.client.hibernate.dao;

import org.hibernate.Session;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Item;
import de.bht.swp.ui_prototype.client.hibernate.Util.HibernateUtil;

/**
 * Data Access Object for Item
 */
public class ItemDAO {

	/**
	 * Create a new item or update an existing one
	 * 
	 * @param Item
	 *            item to be persisted
	 */
	public void saveOrUpdateItem(Item item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.saveOrUpdate(item);
	}

	/**
	 * Retrieve an item from the data store
	 * 
	 * @param itemId
	 *            identifier of the item to be retrieved
	 * @return item represented by the identifier provided
	 */
	public Item getItem(long itemId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Item item = (Item) session.get(Item.class, itemId);
		return item;
	}

	/**
	 * Delete item from data store
	 * 
	 * @param item
	 *            item to be deleted
	 */
	public void deleteItem(Item item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(item);
	}
	
}
