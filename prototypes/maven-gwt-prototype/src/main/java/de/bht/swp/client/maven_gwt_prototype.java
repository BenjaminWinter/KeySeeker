package de.bht.swp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.bht.swp.client.GreetingService;
import de.bht.swp.client.GreetingServiceAsync;
import de.bht.swp.shared.FieldVerifier;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class maven_gwt_prototype implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final Button sendButton = new Button( messages.sendButton() );
    final TextBox nameField = new TextBox();
    final PasswordTextBox selfmadeField = new PasswordTextBox(); // new created textbox for testing
	final TextArea InputArea = new TextArea(); // TextArea for testing chat input
	final TextArea OutputArea = new TextArea();
    final Label errorLabel = new Label();
  
    
    nameField.setText( messages.nameField() );
    InputArea.setWidth("500px");
	InputArea.setHeight("20px");
	OutputArea.setWidth("500px");
	OutputArea.setHeight("500px");
	OutputArea.setReadOnly(true);

    // We can add style names to widgets
    sendButton.addStyleName("sendButton");

    // Add the nameField and sendButton to the RootPanel
    // Use RootPanel.get() to get the entire body element
    RootPanel.get("nameFieldContainer").add(nameField);
    RootPanel.get("selfmadeContainer").add(selfmadeField); // test to add something to the html panel
    RootPanel.get("sendButtonContainer").add(sendButton);
    RootPanel.get("errorLabelContainer").add(errorLabel);
	RootPanel.get("selfmadeTextArea").add(InputArea);
	RootPanel.get("chatTextArea").add(OutputArea);

    // Focus the cursor on the name field when the app loads
    nameField.setFocus(true);
    nameField.selectAll();

    // Create the popup dialog box
    final DialogBox dialogBox = new DialogBox();
    dialogBox.setText("Remote Procedure Call");
    dialogBox.setAnimationEnabled(true);
    final Button closeButton = new Button("Close");
    // We can set the id of a widget by accessing its Element
    closeButton.getElement().setId("closeButton");
    final Label textToServerLabel = new Label();
    final HTML serverResponseLabel = new HTML();
    VerticalPanel dialogVPanel = new VerticalPanel();
    dialogVPanel.addStyleName("dialogVPanel");
    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
    dialogVPanel.add(textToServerLabel);
    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
    dialogVPanel.add(serverResponseLabel);
    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    dialogVPanel.add(closeButton);
    dialogBox.setWidget(dialogVPanel);

    // Add a handler to close the DialogBox
    closeButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        dialogBox.hide();
        sendButton.setEnabled(true);
        sendButton.setFocus(true);
      }
    });

    // Create a handler for the sendButton and nameField
    class MyHandler implements ClickHandler, KeyUpHandler {
      /**
       * Fired when the user clicks on the sendButton.
       */
      public void onClick(ClickEvent event) {
        sendNameToServer();
      }

      /**
       * Fired when the user types in the nameField.
       */
      public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
          sendNameToServer();
        }
      }

      /**
       * Send the name from the nameField to the server and wait for a response.
       */
      private void sendNameToServer() {
        // First, we validate the input.
        errorLabel.setText("");
        String textToServer = nameField.getText();
        if (!FieldVerifier.isValidName(textToServer)) {
          errorLabel.setText("Please enter at least four characters");
          return;
        }

        // Then, we send the input to the server.
        sendButton.setEnabled(false);
        textToServerLabel.setText(textToServer);
        serverResponseLabel.setText("");
        greetingService.greetServer(textToServer, new AsyncCallback<String>() {
          public void onFailure(Throwable caught) {
            // Show the RPC error message to the user
            dialogBox.setText("Remote Procedure Call - Failure");
            serverResponseLabel.addStyleName("serverResponseLabelError");
            serverResponseLabel.setHTML(SERVER_ERROR);
            dialogBox.center();
            closeButton.setFocus(true);
          }

          public void onSuccess(String result) {
            dialogBox.setText("Remote Procedure Call");
            serverResponseLabel.removeStyleName("serverResponseLabelError");
            serverResponseLabel.setHTML(result);
            dialogBox.center();
            closeButton.setFocus(true);
          }
        });
      }
    }

    // Add a handler to send the name to the server
    MyHandler handler = new MyHandler();
    sendButton.addClickHandler(handler);
    nameField.addKeyUpHandler(handler);
    
    //Add a handler to send and add the entered messages to the chatTextArea 
		InputArea.addKeyUpHandler(new KeyUpHandler() {
			GreetingServiceAsync proxy = (GreetingServiceAsync)GWT.create(GreetingService.class);
			
			AsyncCallback<String> callback = new AsyncCallback<String>(){

//				@Override
				public void onFailure(Throwable caught) {
					// Show the RPC error message to the user
					dialogBox
							.setText("Remote Procedure Call - Failure");
					serverResponseLabel
							.addStyleName("serverResponseLabelError");
					serverResponseLabel.setHTML(SERVER_ERROR);
					dialogBox.center();
					closeButton.setFocus(true);
				}

//				@Override
				public void onSuccess(String result) {
					String chatHistory = OutputArea.getText(); 
					OutputArea.setText(chatHistory + result);
				}
			};
			
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					String chatMessage = InputArea.getText(); //get the entered message
					String username = nameField.getText();
					proxy.setOutput(username, chatMessage, callback);
					InputArea.setText("");
					
//					dialogBox.setText("Remote Procedure Call");
//					serverResponseLabel.removeStyleName("serverResponseLabelError");
//					serverResponseLabel.setHTML(chatMessage);
//					dialogBox.center();
//					closeButton.setFocus(true);
//					OutputArea.setText(chatHistory + nameField.getText() + ":   " + serverResponseLabel.getText());
					
//					
//					// add the entered message to the chat and uses the current name in the nameField as username
//					chatTextArea.setText(chatHistory + nameField.getText() + ":   " + chatMessage); 
//					selfmadeTextArea.setText("");
				}
			}
		});
  }
}