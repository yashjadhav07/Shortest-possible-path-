
package gmapsfx.javascript;

import javafx.concurrent.Worker;


public interface IWebEngine {

    
    public Object executeScript(String command);

    
    public Worker<Void> getLoadWorker();

    
    public void load(String url);

}
