package de.bht.swp.ui_prototype.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


public class RegistrationPanel extends Composite {

	@UiField
	DivElement registerDiv;
	@UiField
	DivElement logoDiv;
	
	@UiField
	TextBox registerNameTextBox;
	@UiField
	PasswordTextBox registerPasswordTextBox;
	@UiField
	TextBox registerEMailTextBox;
	
	/**
	* Create a remote service proxy to talk to the server-side Greeting service.
	*/
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	
	prototype proto = new prototype();
	
	private static RegistrationPanelUiBinder uiBinder = GWT
			.create(RegistrationPanelUiBinder.class);

	interface RegistrationPanelUiBinder extends
			UiBinder<Widget, RegistrationPanel> {
	}

	public RegistrationPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	

	@UiHandler("registerButton")
	  void onRegister(ClickEvent e) {
		  
		  String registerEmail = registerEMailTextBox.getText();
		  String registerName = registerNameTextBox.getText();
		  String registerPassword = registerPasswordTextBox.getText();
		  
//		  Todo: ask the database here
//		  boolean validLogin = true;
		  greetingService.registerUser(registerName, registerPassword, registerEmail,
					new AsyncCallback<String>() {

						public void onFailure(Throwable caught) {
							Window.alert("register BOOOOM!!!!!");
						}

						public void onSuccess(String result) {
							 registerDiv.getStyle().setDisplay(Display.NONE);
							 logoDiv.getStyle().setDisplay(Display.NONE);
							 proto.changePanelLogin();
						}
		  });
	  }

}
