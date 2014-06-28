package de.bht.swp.ui_prototype.server.hibernate.Util;

import org.hibernate.Session;

public abstract class Action {
	public abstract Object execute(Session session);
}
