package dad.virus;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
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
        engine.load("https://cloudpdf.io/view/WybIRELcE");
    }
}
