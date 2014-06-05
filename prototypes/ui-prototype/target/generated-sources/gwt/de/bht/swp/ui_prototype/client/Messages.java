package de.bht.swp.ui_prototype.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	C:/Users/Marvin/Documents/Eclipse/project/ui-prototype/src/main/resources/de/bht/swp/ui_prototype/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
