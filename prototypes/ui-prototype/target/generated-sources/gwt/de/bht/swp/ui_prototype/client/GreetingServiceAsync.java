package de.bht.swp.ui_prototype.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see de.bht.swp.ui_prototype.client.GreetingService
     */
    void greetServer( String name, AsyncCallback<String> callback );
    void loginUser( String name,String passwort, AsyncCallback<String> callback );
    void registerUser(String name, String passwort,String email, AsyncCallback<String> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GreetingServiceAsync instance;

        public static final GreetingServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GreetingServiceAsync) GWT.create( GreetingService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
