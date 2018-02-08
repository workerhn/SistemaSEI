package basedatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfae
 */
public class BaseDatos {

    private Connection myConn = null;
    private Statement myStmt = null;
    private ResultSet myRs = null;
    private PreparedStatement preparedStmt;

    private final Properties props = new Properties();
    private String connect;

    public BaseDatos() {
        this.preparedStmt = null;
        this.connect = "";
    }

    // Get the user connected
    public String getLoginUser(String u) {

        try {
            props.load(new FileInputStream("AccessoUsuario.properties"));

        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2. Read the props
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDburl = props.getProperty("dburl");

        try {
            // 3. Get a connection to database
            myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT user FROM login_user WHERE user='" + u + "'");

            while (myRs.next()) {
                connect = myRs.getString("user");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connect;
    }

    public String getLoginPassword(String p) {
        // 1. Load the properties file

        try {
            props.load(new FileInputStream("AccessoUsuario.properties"));

        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2. Read the props
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDburl = props.getProperty("dburl");

        try {
            // 3. Get a connection to database
            myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT pass FROM login_user WHERE pass='" + p + "'");

            while (myRs.next()) {
                connect = myRs.getString("pass");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connect;
    }

    /*
    modificar el insert 
     */
    public void insert(String primer_nombre, String segundo_nombre, String primer_apellido,
        String segundo_apellido, int edad, String genero, String estado_civil,
        String raza, String religion, String escolaridad, String ocupacion, String procedencia, String direccion,
        String turno_doctor) throws SQLException {
        // 1. Load the properties file

        try {
            props.load(new FileInputStream("AccessoUsuario.properties"));
        } catch (IOException ex) {

        }

        // 2. Read the props
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDburl = props.getProperty("dburl");

        try {
            // 3. Get a connection to database
            myConn = DriverManager.getConnection(theDburl, theUser, thePassword);

            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp fecha_hora = new java.sql.Timestamp(new java.util.Date().getTime());

            String query = "INSERT INTO paciente (primer_nombre, segundo_nombre, primer_apellido, segundo_apellido,"
                + "edad, genero, estado_civil, raza, religion,"
                + "escolaridad, ocupacion, procedencia,direccion, fecha_hora, turno_doctor)"
                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            preparedStmt = myConn.prepareStatement(query);

            preparedStmt.setString(1, primer_nombre);
            preparedStmt.setString(2, segundo_nombre);
            preparedStmt.setString(3, primer_apellido);
            preparedStmt.setString(4, segundo_apellido);
            preparedStmt.setInt(5, edad);
            preparedStmt.setString(6, genero);
            preparedStmt.setString(7, estado_civil);
            preparedStmt.setString(8, raza);
            preparedStmt.setString(9, religion);
            preparedStmt.setString(10, escolaridad);
            preparedStmt.setString(11, ocupacion);
            preparedStmt.setString(12, procedencia);
            preparedStmt.setString(13, direccion);
            preparedStmt.setTimestamp(14, fecha_hora);
            preparedStmt.setString(15, turno_doctor);

            preparedStmt.execute();

        } catch (SQLException ex) {

        }
    }

    public void update(String text) {

    }

    public void delete(int id) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("AccessoUsuario.properties"));

        } catch (IOException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        // 2. Read the props
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDburl = props.getProperty("dburl");

        try {
            // 3. Get a connection to database
            myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
            myStmt = myConn.createStatement();

            // Create query
            String query = "DELETE FROM paciente where idpaciente = ?";
            PreparedStatement preparedStmt = myConn.prepareStatement(query);
            preparedStmt.setInt(1, id);

            // Execute statement
            preparedStmt.execute();
        } catch (SQLException ex) {

        }
    }
}
