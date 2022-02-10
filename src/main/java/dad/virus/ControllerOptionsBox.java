package dad.virus;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    private DoubleProperty vol = new SimpleDoubleProperty();

    private StringProperty urlCSS = new SimpleStringProperty();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Listener, valores del slider opciones para el volúmen
        this.sliderVol.setValue(50f);
        this.sliderVol.valueProperty().addListener((v,ov,nv) -> {
            vol.setValue(nv);
        });

        ToggleGroup tg = new ToggleGroup();
        this.rdBtnDark.setToggleGroup(tg);
        this.rdBtnClear.setToggleGroup(tg);

        String urlDarkTheme = "file:/C:/Users/psych/Desktop/virus2/Virus/target/classes/css/rootDark.css";

        String urlStyleSheetApp = App.getPrimaryStage().getScene().getStylesheets().get(0);
        System.out.println(urlStyleSheetApp);
        if(urlDarkTheme.equals(urlStyleSheetApp)){
            this.rdBtnDark.setSelected(true);
            this.getBtnSave().setDisable(true);
        }else {
            this.rdBtnClear.setSelected(true);
            this.getBtnSave().setDisable(true);
        }

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton r = (RadioButton) t1;
                try {
                    if (r.getText().equals("Tema Oscuro")) {
                        urlCSS.setValue("/css/rootDark.css");
                        btnSave.setDisable(false);
                        r.getScene().getStylesheets().remove(String.valueOf(getClass().getResource("/css/viewOptionsClear.css")));
                        r.getScene().getStylesheets().add(String.valueOf(getClass().getResource("/css/viewOptionsDark.css")));

                    } else {
                        urlCSS.setValue("/css/rootClear.css");
                        btnSave.setDisable(false);
                        r.getScene().getStylesheets().remove(String.valueOf(getClass().getResource("/css/viewOptionsDark.css")));
                        r.getScene().getStylesheets().add(String.valueOf(getClass().getResource("/css/viewOptionsClear.css")));
                    }
                }catch (NullPointerException ignored){}
            }
        });
    }

    public DoubleProperty getVol() {
        return vol;
    }

    public StringProperty getURLcss(){
        return urlCSS;
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

