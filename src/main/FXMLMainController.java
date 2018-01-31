package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfae
 */
public class FXMLMainController implements Initializable {

    @FXML
    private Button paciente;

    @FXML
    private Button reportes;

    @FXML
    private Button configuracion;

    @FXML
    void openConfiguracion(ActionEvent event) {
        loadWindow("/configuracion/configuracion.fxml", "Configuracion");
        closeStage();
    }

    @FXML
    void openPaciente(ActionEvent event) {
        loadWindow("/paciente/paciente.fxml", "Paciente");
        closeStage();
    }

    @FXML
    void openReportes(ActionEvent event) {
        loadWindow("/reportes/reportes.fxml", "Reportes");
        closeStage();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // loadWindow("/main/main.fxml", "Bienvenido al Sistema SEI");
    }

    void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));

            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

    private void closeStage() {
        ((Stage) configuracion.getScene().getWindow()).close();
    }
}
