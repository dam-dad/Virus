package dad.virus;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOptionsBox implements Initializable {

    @FXML
    private Button btnPlayMusic;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSilence;

    @FXML
    private Pane paneTitle;

    @FXML
    private RadioButton rdBtnClear;

    @FXML
    private RadioButton rdBtnDark;

    @FXML
    private Slider sliderVol;

    @FXML
    private Text txtOptions;

    @FXML
    private VBox viewOptions;

    public DoubleProperty vol = new SimpleDoubleProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Listener, valores del slider opciones para el volúmen
        this.sliderVol.setValue(50f);
        this.sliderVol.valueProperty().addListener((v,ov,nv) -> {
            vol.setValue(nv);
        });
    }

    public DoubleProperty getVol() {
        return vol;
    }

    public Button getBtnPlayMusic() {
        return btnPlayMusic;
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public Button getBtnSilence() {
        return btnSilence;
    }
}
