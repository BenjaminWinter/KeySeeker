package de.bht.swp.ui_prototype.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class prototype implements EntryPoint {
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
	  final Canvas canvas = Canvas.createIfSupported();
	  if(canvas==null) {
		  RootPanel.get().add(new Label("Canvas is not supported by your browser"));
		  return;
	  }
	  final Image image = new Image("/images/test.jpg");
	  canvas.setCoordinateSpaceWidth(image.getWidth());
	  canvas.setCoordinateSpaceHeight(image.getHeight());
	 
	  
	  final Context2d context = canvas.getContext2d();
	  final ImageElement board = ImageElement.as(image.getElement());
	  
	  image.addLoadHandler(new LoadHandler() {
	        public void onLoad(LoadEvent event) {
	            context.drawImage(board, 0, 0);
	        	context.fillRect(430, 650, 20, 20);
	        }
	  });
	  
	  RootPanel.get().add(canvas);
	  
	  image.setVisible(false);
	  RootPanel.get().add(image);
  }
}
