package de.bht.swp.ui_prototype.client.hibernate.Service;

import de.bht.swp.ui_prototype.client.hibernate.Mapping.Item;
import de.bht.swp.ui_prototype.client.hibernate.dao.ItemDAO;


/**
 * Service layer for Item
 */
public class ItemService {
	ItemDAO itemDAO = new ItemDAO();

	/**
	 * Create a new item or update an existing one
	 * 
	 * @param item
	 *            item to be persisted
	 */
	public void saveOrUpdateItem(Item item) {
		itemDAO.saveOrUpdateItem(item);
	}

	/**
	 * Retrieve an item
	 * 
	 * @param itemId
	 *            identifier of the item to be retrieved
	 * @return item represented by the identifier provided
	 */
	public Item getItem(long itemId) {
		return itemDAO.getItem(itemId);
	}

	/**
	 * Delete item
	 * 
	 * @param item
	 *            item to be deleted
	 */
	public void deleteItem(Item item) {
		itemDAO.deleteItem(item);
	}
}
