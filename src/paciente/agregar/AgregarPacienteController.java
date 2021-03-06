/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente.agregar;

import basedatos.BaseDatos;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alfae
 */
public class AgregarPacienteController implements Initializable {

    @FXML
    private Button home;

    @FXML
    private Button buscar;

    @FXML
    private Button agregar;

    @FXML
    private Button modificar;

    @FXML
    private Button eliminar;

    @FXML
    private Button consulta;

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
    private RadioButton radMasculino;

    @FXML
    private RadioButton radFeminino;

    @FXML
    private Button agregarPaciente;

    private Stage stage;
    private Scene scene;

    private BaseDatos bd;
    private Date now = new Date();

    @FXML
    void agregarPacienteAction(ActionEvent event) throws SQLException {

        bd.insert(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText(),
            Integer.parseInt(txt5.getText()), radMasculino.getText(), txt7.getText(),
            txt8.getText(), txt9.getText(), txt10.getText(), txt11.getText(), txt12.getText(),
            txt13.getText(), txt15.getText());
    }

    @FXML
    void openAgregar(ActionEvent event) {

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

        loadWindow("/paceinte/modificar/ModificarPaciente.fxml", "Modificar Paciente");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String pattern = "yyyy-MM-dd HH:mm:ss";

        bd = new BaseDatos();

        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        String mysqlFormat = formatter.format(now);
        txt14.setText(mysqlFormat);
    }

    private void loadWindow(String loc, String title) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));

            stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.setFullScreen(true);
            stage.setMaximized(true);
            stage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText(e.getMessage());
        }
    }

    private void closeStage() {
        ((Stage) agregarPaciente.getScene().getWindow()).close();
    }
}
