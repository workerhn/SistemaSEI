/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfae
 */
public class PacienteController implements Initializable {

    @FXML
    private Button home;

    @FXML
    private Button buscar;

    @FXML
    private Button consulta;

    @FXML
    private Button agregar;

    @FXML
    private Button modificar;

    @FXML
    private Button eliminar;

    Stage stage;
    Scene scene;

    @FXML
    void openBuscar(ActionEvent event) {
        loadWindow("/paciente/buscar/BuscarPaciente.fxml", "Busqueda de Paciente");
        closeStage();
    }

    @FXML
    void openConsulta(ActionEvent event) {
        loadWindow("/paciente/consulta/PacienteConsulta.fxml", "Consulta de Paciente");
        closeStage();
    }

    @FXML
    void openEliminar(ActionEvent event) {
        loadWindow("/paciente/eliminar/EliminarPaciente.fxml", "Eliminar Paciente");
        closeStage();
    }

    @FXML
    void openHome(ActionEvent event) {
        loadWindow("/main/main.fxml", "Bienvenido al Sistema SEI");
        closeStage();
    }

    @FXML
    void openAgregar(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/paciente/agregar/AgregarPaciente.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(parent);

            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
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

    private void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));

            stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {

        }
    }

    private void closeStage() {
        ((Stage) home.getScene().getWindow()).close();
    }
}
