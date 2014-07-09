package de.bht.swp.ui_prototype.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  String  loginUser(String name,String passwort) throws IllegalArgumentException;
  String registerUser(String name,String passwort, String email) throws IllegalArgumentException;
}
