package dad.virus;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable{

	@FXML
    private Button configButton;

    @FXML
    private Button documentationButton;

    @FXML
    private Button exitButton;

    @FXML
    private HBox hbox;

    @FXML
    private Button multiPlayerButton;

    @FXML
    private StackPane stack;

    @FXML
    private BorderPane view;
	
    @FXML
    public void configAction(ActionEvent event) {

    }

    @FXML
    public void documentationAction(ActionEvent event) {

    }

    @FXML
    public void exitAction(ActionEvent event) {

    }

    @FXML
    public void multiPlayerAction(ActionEvent event) {

    }

	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}
	public BorderPane getView() {
		return view;
	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
