package de.bht.swp.ui_prototype.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
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
  
  
  
  protected int charPosX;
  protected int charPosY;
  protected Canvas canvas;
  protected Context2d context;
  protected ImageElement imageElement;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  canvas = Canvas.createIfSupported();
	  if(canvas==null) {
		  RootPanel.get().add(new Label("Canvas is not supported by your browser"));
		  return;
	  }
	  
	  canvas.setWidth("600px");
	  canvas.setHeight("600px");
	  canvas.setCoordinateSpaceWidth(600);
	  canvas.setCoordinateSpaceHeight(600);
	  
	  context = canvas.getContext2d();
	  Image image = new Image("/images/testTiles.jpg");
	  imageElement = ImageElement.as(image.getElement());
	  
	  charPosX = 4;
	  charPosY = 2;
	  
	  image.addLoadHandler(new LoadHandler() {
	        public void onLoad(LoadEvent event) {
	            draw();
	        }
	  });
	  
	  RootPanel.get().add(canvas);
	  
	  canvas.addKeyDownHandler(new KeyDownHandler() {
		  
		public void onKeyDown(KeyDownEvent event) {
			int keycode = event.getNativeKeyCode();
			switch (keycode) {
			case KeyCodes.KEY_DOWN:
				if (charPosY < 3) {
					charPosY++;
				}
				break;
				
			case KeyCodes.KEY_UP:
				if (charPosY > 0) {
					charPosY--;
				}
				break;
				
			case KeyCodes.KEY_LEFT:
				if (charPosX > 0) {
					charPosX--;
				}
				break;
				
			case KeyCodes.KEY_RIGHT:
				if (charPosX < 9) {
					charPosX++;
				}
				break;
				
			default:
				break;
			}
			draw();
		}
	  });
	  
	  image.setVisible(false);
	  RootPanel.get().add(image);
	  canvas.setFocus(true);
	  
//	  Timer timer = new Timer() {
//		@Override
//		public void run() {
//		}
//	  };
	  
//	  timer.scheduleRepeating(20);
//	  timer.run();
  }
  
  public void draw() {
	  
	  // values here are not very accurate, but its only a test
	  double deltaX = 68 +0.5;
	  int deltaY = 68;
	  
	  //Background
	  context.fillRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
	  
	  //first row
	  context.drawImage(imageElement, (charPosX-1)*deltaX, (charPosY-1)*deltaY, 71, 71,   0, 0, 200, 200);
	  context.drawImage(imageElement,  charPosX   *deltaX, (charPosY-1)*deltaY, 70, 70, 200, 0, 200, 200);
	  context.drawImage(imageElement, (charPosX+1)*deltaX, (charPosY-1)*deltaY, 70, 70, 400, 0, 200, 200);
	  //second row
	  context.drawImage(imageElement, (charPosX-1)*deltaX, charPosY*deltaY, 71, 71,   0, 200, 200, 200);
	  context.drawImage(imageElement,  charPosX   *deltaX, charPosY*deltaY, 70, 70, 200, 200, 200, 200);
	  context.drawImage(imageElement, (charPosX+1)*deltaX, charPosY*deltaY, 70, 70, 400, 200, 200, 200);
	  //third row
	  context.drawImage(imageElement, (charPosX-1)*deltaX, (charPosY+1)*deltaY, 71, 71,   0, 400, 200, 200);
	  context.drawImage(imageElement,  charPosX   *deltaX, (charPosY+1)*deltaY, 70, 70, 200, 400, 200, 200);
	  context.drawImage(imageElement, (charPosX+1)*deltaX, (charPosY+1)*deltaY, 70, 70, 400, 400, 200, 200);
	  
	  context.fillRect(context.getCanvas().getWidth()/2 -25, context.getCanvas().getHeight()/2 -25, 50, 50);
  }
}
