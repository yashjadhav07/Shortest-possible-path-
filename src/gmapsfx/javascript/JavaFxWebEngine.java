

package gmapsfx.javascript;

import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;


public class JavaFxWebEngine implements IWebEngine {
    
    
    protected WebEngine webEngine;
    
    
    public JavaFxWebEngine( WebEngine engine ) {
        this.webEngine = engine;
    }

    
    
    @Override
    public Object executeScript(String command) {
        return webEngine.executeScript(command);
    }

    
    @Override
    public Worker<Void> getLoadWorker() {
        return webEngine.getLoadWorker();
    }

   
    @Override
    public void load(String url) {
        webEngine.load(url);
    }
    
    
    
    
    
}
