package login;

import basedatos.BaseDatos;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLLoginController {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelOnClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLoginClick(ActionEvent event) {
        BaseDatos bd = new BaseDatos();

        String user = txtUser.getText();
        String pass = txtPass.getText();

        String dbUser = bd.getLoginUser(user);
        String dbPass = bd.getLoginPassword(pass);
        if (user.equals(dbUser) && !user.equals("")) {
            if (pass.equals(dbPass) && !pass.equals("")) {
                closeStage();
                loadMain();
            }
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setContentText("Usuario o Contraseña no es válido!");
            alert.showAndWait();

            txtUser.setText("");
            txtPass.setText("");
            txtPass.setDisable(true);
        }
    }

    @FXML
    void btnUserKeyTyped(KeyEvent event) {

        if ("".equals(txtPass.getText())) {
            txtPass.setDisable(false);
            txtPass.setFocusTraversable(true);
        } else {
            txtPass.setDisable(true);
        }
    }

    void loadMain() {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/main/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Sistema SEI");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private void closeStage() {
        ((Stage) txtUser.getScene().getWindow()).close();
    }
}
