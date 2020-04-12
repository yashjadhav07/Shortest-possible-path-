

package gmapsfx.javascript.event;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import netscape.javascript.JSObject;


public class EventHandlers {
	
	private final Map<String, GFXEventHandler> handlers = new HashMap<>();
    
	public EventHandlers() {
	}
	
	
	public String registerHandler(GFXEventHandler handler) {
		String uuid = UUID.randomUUID().toString();
		handlers.put(uuid, handler);
		return uuid;
	}
	
   
	public void handleUIEvent(String callbackKey, JSObject result) {
		if (handlers.containsKey(callbackKey) && handlers.get(callbackKey) instanceof UIEventHandler) {
			((UIEventHandler) handlers.get(callbackKey)).handle(result);
		} else {
			System.err.println("Error in handle: " + callbackKey + " for result: " + result);
		}
	}
    
   
    public void handleStateEvent(String callbackKey) {
		if (handlers.containsKey(callbackKey) && handlers.get(callbackKey) instanceof StateEventHandler) {
			((StateEventHandler) handlers.get(callbackKey)).handle();
		} else {
			System.err.println("Error in handle: " + callbackKey + " for state handler ");
		}
	}
	
}