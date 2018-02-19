/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente.modificar;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfae
 */
public class ModificarPacienteController implements Initializable {

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private RadioButton radMasculino;

    @FXML
    private RadioButton radFeminino;

    @FXML
    private TextField txt7;

    @FXML
    private TextField txt8;

    @FXML
    private TextField txt9;

    @FXML
    private TextField txt10;

    @FXML
    private TextField txt11;

    @FXML
    private TextField txt12;

    @FXML
    private TextField txt13;

    @FXML
    private TextField txt14;

    @FXML
    private TextField txt15;

    @FXML
    private Button home;

    @FXML
    private Button consulta;

    @FXML
    private Button buscar;

    @FXML
    private Button agregar;

    @FXML
    private Button modificar;

    @FXML
    private Button eliminar;

    @FXML
    private Button modificarPaciente;

    @FXML
    void modificarPacienteAction(ActionEvent event) {

    }

    @FXML
    void openAgregar(ActionEvent event) {
        loadWindow("/paciente/agregar/AgregarPaciente.fxml", "Sistema SEI");
    }

    @FXML
    void openBuscar(ActionEvent event) {
        loadWindow("/paciente/buscar/BuscarPaciente.fxml", "Buscar Paciente");
    }

    @FXML
    void openEliminar(ActionEvent event) {
        loadWindow("/paciente/eliminar/EliminarPaciente.fxml", "Eliminar Paciente");
    }

    @FXML
    void openHome(ActionEvent event) {
        loadWindow("/main/main.fxml", "Sistema SEI");
    }

    @FXML
    void openModificar(ActionEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));

            Scene scene = new Scene(parent);

            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle(title);
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {

        }
    }

    private void closeStage() {
        ((Stage) modificarPaciente.getScene().getWindow()).close();
    }
}
