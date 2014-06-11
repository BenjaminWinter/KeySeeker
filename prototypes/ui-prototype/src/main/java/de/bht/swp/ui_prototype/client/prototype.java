package de.bht.swp.ui_prototype.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
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
  
  
  private final int[] INIT_CHAR_POSITION = {4, 2};
  
  protected int charPosX;
  protected int charPosY;
  protected Canvas canvas;
  protected Canvas miniMapCanvas;
  protected Context2d context;
  protected ImageElement mapImageElement;
  
  @UiField
  Button confirmButton;
  
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  InputPanel ip = new InputPanel();
	  RootPanel.get().add(ip);
	  
//	  ip.testButton.setText("funkt");
	  
  }
  

  
  public void onStartGame() {
	  canvas = Canvas.createIfSupported();
	  miniMapCanvas = Canvas.createIfSupported();
	  if(canvas==null || miniMapCanvas==null) {
		  RootPanel.get().add(new Label("Canvas is not supported by your browser"));
		  return;
	  }
	  
	  canvas.setWidth("600px");
	  canvas.setHeight("600px");
	  canvas.setCoordinateSpaceWidth(600);
	  canvas.setCoordinateSpaceHeight(600);
	  
	  context = canvas.getContext2d();
	  Image mapImage = new Image("/images/testTiles.jpg");
	  mapImageElement = ImageElement.as(mapImage.getElement());
	  
	  charPosX = INIT_CHAR_POSITION[0];
	  charPosY = INIT_CHAR_POSITION[1];
	  
	  mapImage.addLoadHandler(new LoadHandler() {
	        public void onLoad(LoadEvent event) {
	            draw();
	        }
	  });
	  
	  RootPanel.get().add(canvas);
	  RootPanel.get().add(miniMapCanvas);
	  
	  canvas.addClickHandler(new ClickHandler() {
		
		public void onClick(ClickEvent event) {
			int mouseX = event.getClientX() - canvas.getAbsoluteLeft();
			int mouseY = event.getClientY() - canvas.getAbsoluteTop();
			
			int centerX = context.getCanvas().getWidth()/2 -25;
			int centerY = context.getCanvas().getHeight()/2 -25;
			
			if (charPosY > 0 && centerX <= mouseX && mouseX <= centerX+50 && centerY - 100 <= mouseY && mouseY <= centerY - 50) {
				charPosY--;
			} else if (charPosY < 3 && centerX <= mouseX && mouseX <= centerX+50 && centerY + 100 <= mouseY && mouseY <= centerY + 150) {
				charPosY++;
			} else if (charPosX > 0 && centerX -100 <= mouseX && mouseX <= centerX-50 && centerY <= mouseY && mouseY <= centerY + 50) {
				charPosX--;
			} else if (charPosX < 9 && centerX +100 <= mouseX && mouseX <= centerX +150 && centerY <= mouseY && mouseY <= centerY + 50) {
				charPosX++;
			}
			draw();
		}
	  });
	  
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
	  
	  mapImage.setVisible(false);
	  RootPanel.get().add(mapImage);
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
	  
	  drawMap();
	  drawArrows(); 
	  
	  // dummy Character
	  context.fillRect(context.getCanvas().getWidth()/2 -25, context.getCanvas().getHeight()/2 -25, 50, 50);
	  
	  drawMiniMap();
  }
  

public void drawMap() {
	  
	  // values here are not very accurate, but its only a test
	  double deltaX = 68 +0.5;
	  int deltaY = 68;
		  
	  // black Background
	  context.fillRect(0, 0, context.getCanvas().getWidth(), context.getCanvas().getHeight());
	  
	  //first row
	  context.drawImage(mapImageElement, (charPosX-1)*deltaX, (charPosY-1)*deltaY, 71, 71,   0, 0, 200, 200);
	  context.drawImage(mapImageElement,  charPosX   *deltaX, (charPosY-1)*deltaY, 70, 70, 200, 0, 200, 200);
	  context.drawImage(mapImageElement, (charPosX+1)*deltaX, (charPosY-1)*deltaY, 70, 70, 400, 0, 200, 200);
	  //second row
	  context.drawImage(mapImageElement, (charPosX-1)*deltaX, charPosY*deltaY, 71, 71,   0, 200, 200, 200);
	  context.drawImage(mapImageElement,  charPosX   *deltaX, charPosY*deltaY, 70, 70, 200, 200, 200, 200);
	  context.drawImage(mapImageElement, (charPosX+1)*deltaX, charPosY*deltaY, 70, 70, 400, 200, 200, 200);
	  //third row
	  context.drawImage(mapImageElement, (charPosX-1)*deltaX, (charPosY+1)*deltaY, 71, 71,   0, 400, 200, 200);
	  context.drawImage(mapImageElement,  charPosX   *deltaX, (charPosY+1)*deltaY, 70, 70, 200, 400, 200, 200);
	  context.drawImage(mapImageElement, (charPosX+1)*deltaX, (charPosY+1)*deltaY, 70, 70, 400, 400, 200, 200);
  }
  
  public void drawArrows() {
	  
	  ImageElement arrows = ImageElement.as(new Image("/images/testArrows.png").getElement());
	  
	  if(charPosX > 0) {
		  context.drawImage(arrows, 0, 0, 200, 200, context.getCanvas().getWidth()/2 -25 -100, context.getCanvas().getHeight()/2 -25, 50, 50);
	  }
	  if(charPosX < 9) {
		  context.drawImage(arrows, 400, 0, 200, 200, context.getCanvas().getWidth()/2 -25 +100, context.getCanvas().getHeight()/2 -25, 50, 50);
	  }
	  if(charPosY > 0) {
		  context.drawImage(arrows, 200, 0, 200, 200, context.getCanvas().getWidth()/2 -25, context.getCanvas().getHeight()/2 -25  -100, 50, 50);
	  }
	  if(charPosY < 3) {
		  context.drawImage(arrows, 600, 0, 200, 200, context.getCanvas().getWidth()/2 -25, context.getCanvas().getHeight()/2 -25  +100, 50, 50);
	  }
  }
  
  private void drawMiniMap() {
	  Context2d miniMapCtx = miniMapCanvas.getContext2d();
	  double xTileLenght = miniMapCtx.getCanvas().getWidth()/10 -0.7;
	  double yTileLenght = miniMapCtx.getCanvas().getHeight()/4 -1.7;
	  
	  miniMapCtx.drawImage(mapImageElement, 0, 0, miniMapCtx.getCanvas().getWidth(), miniMapCtx.getCanvas().getHeight());
	  miniMapCtx.fillRect(xTileLenght/2  -3 +charPosX*xTileLenght, yTileLenght/2+charPosY*yTileLenght - 3, 6, 6);
  }
}
