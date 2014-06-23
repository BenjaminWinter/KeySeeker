package de.bht.swp.ui_prototype.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class StatusView extends Composite {

	@UiField
	ListBox inventoryList;
	
	private static StatusViewUiBinder uiBinder = GWT
			.create(StatusViewUiBinder.class);

	interface StatusViewUiBinder extends UiBinder<Widget, StatusView> {
	}

	public StatusView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
