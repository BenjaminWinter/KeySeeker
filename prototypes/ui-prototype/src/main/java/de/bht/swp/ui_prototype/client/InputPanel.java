package de.bht.swp.ui_prototype.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class InputPanel extends Composite {

	@UiField
	Button loginButton;
	@UiField
	Button confirmButton;
	@UiField
	DivElement loginDiv;
	@UiField
	DivElement characterCreationDiv;
	@UiField
	HorizontalPanel gameDiv;
	@UiField
	ListBox classListBox;
	@UiField
	Label attackValue;
	@UiField
	Label movesPerTurnValue;
	@UiField
	Label lifeValue;
	
	prototype proto = new prototype();
	
	private static InputPanelUiBinder uiBinder = GWT
			.create(InputPanelUiBinder.class);

	interface InputPanelUiBinder extends UiBinder<Widget, InputPanel> {
	}

	public InputPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		classListBox.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				ListBox listBox = (ListBox) event.getSource();
				String selectedClass = listBox.getItemText(listBox.getSelectedIndex());
				if (selectedClass.equals("Krieger")) {
					attackValue.setText("3");
					movesPerTurnValue.setText("1");
					lifeValue.setText("2");
				} else if (selectedClass.equals("Jäger")) {
					attackValue.setText("2");
					movesPerTurnValue.setText("2");
					lifeValue.setText("2");
				} else if (selectedClass.equals("Magier")) {
					attackValue.setText("1");
					movesPerTurnValue.setText("2");
					lifeValue.setText("1");
				}
//				Window.alert(selectedClass);
			}
		});
//		loginDiv.getStyle().setDisplay(Display.NONE);
//		proto.onStartGame(gameDiv);
	}
	
	  @UiHandler("loginButton")
	  void onLogin(ClickEvent e) {
		  loginDiv.getStyle().setDisplay(Display.NONE);
		  characterCreationDiv.getStyle().setDisplay(Display.BLOCK);
	  }
	  
	  @UiHandler("confirmButton")
	  void onConfirm(ClickEvent e) {
		  characterCreationDiv.getStyle().setDisplay(Display.NONE);
		  proto.onStartGame(gameDiv);
		  proto.draw();
	  }
}