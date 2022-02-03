package dad.virus;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;

public class PdfController {
	@FXML
    private WebView webView;

    @FXML
    private void initialize()
    {
    	System.out.println("initialize");
        WebEngine engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);        
        engine.setOnStatusChanged(event -> {
        	System.out.println(event.getEventType() + " - " + event.getData());
		});
//        engine.load("https://drive.google.com/viewerng/viewer?embedded=true&url=https://tranjisgames.com/wp-content/uploads/2017/02/VIRUS-RULES-esp.pdf");
        engine.load("https://github.com/dam-dad/Virus");
    }
	  
}
