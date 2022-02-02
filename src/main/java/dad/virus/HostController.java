package dad.virus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HostController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private SplitPane configPane;

    @FXML
    private Button menuButton;

    @FXML
    private Button nextButton;

    @FXML
    private StackPane view;

    public HostController() throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void onBackButton(ActionEvent event) {

    }

    @FXML
    void onMenuButton(ActionEvent event) {

    }

    @FXML
    void onNextButton(ActionEvent event) {

    }

    public Button getBackButton() {
        return backButton;
    }

    public SplitPane getConfigPane() {
        return configPane;
    }

    public Button getMenuButton() {
        return menuButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public StackPane getView() {
        return view;
    }
}
