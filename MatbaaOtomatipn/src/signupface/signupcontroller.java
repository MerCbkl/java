package signupface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import  javafx.scene.image.Image;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class signupcontroller implements Initializable{
    @FXML
    private AnchorPane scenePane;
    Stage stage;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private javafx.scene.control.TextField namefield;
    @FXML
   private javafx.scene.control.TextField emailfield;
    @FXML
   private javafx.scene.control.TextField usernamefield;
    @FXML
   private PasswordField passwordfield;
    @Override
    public void initialize(URL url , ResourceBundle resourceBundle)
    {
        File brandingFile = new File("@../../icon/icons8_up_26px.png");
        Image brandingimage = new Image(brandingFile.toURI().toString());
        img1.setImage(brandingimage);
        File brandingFile2 = new File("@../../icon/icons8_username_32px_1.png");
        Image brandingimage2 = new Image(brandingFile2.toURI().toString());
        img2.setImage(brandingimage2);
        File brandingFile3 = new File("@../../icon/icons8_password_64px.png");
        Image brandingimage3 = new Image(brandingFile3.toURI().toString());
        img3.setImage(brandingimage3);
        File brandingFile4 = new File("@../../icon/icons8_sign_language_i_30px.png");
        Image brandingimage4 = new Image(brandingFile4.toURI().toString());
        img4.setImage(brandingimage4);
        File brandingFile7 = new File("@../../icon/icons8_email_80px.png");
        Image brandingimage7 = new Image(brandingFile7.toURI().toString());
        img7.setImage(brandingimage7);
        File brandingFile5 = new File("@../../icon/icons8_name_80px.png");
        Image brandingimage5 = new Image(brandingFile5.toURI().toString());
        img5.setImage(brandingimage5);
        File brandingFile6 = new File("@../../icon/icons8_yoga_mat_50px_3.png");
        Image brandingimage6 = new Image(brandingFile6.toURI().toString());
        img6.setImage(brandingimage6);

    }
    public void logout(ActionEvent event)
    {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
    public void loginbtnaction() throws Exception
    {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
        Stage window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../loginface/maininterface.fxml"));
        window.setTitle("MatBaa Otomation");
        window.setScene(new Scene(root));
        window.initStyle(StageStyle.UNDECORATED);

        window.show();

    }
    public void signupbtn() throws  Exception
    {

        if(namefield.getText().isBlank()==false && emailfield.getText().isBlank()==false && usernamefield.getText().isBlank()==false&& passwordfield.getText().isBlank()==false )
        {
            validateSignUp();
        }else
        {
            JOptionPane.showMessageDialog(null,"Lütfen Formu Tam Anlamıyla Doldurun!");
        }
    }
    public void validateSignUp() throws Exception
    {
        kayit_ol kayit = new kayit_ol();
        kayit.kayitol(namefield.getText(),emailfield.getText(),usernamefield.getText(),passwordfield.getText());
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
        Stage window = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("maininterface.fxml"));
        window.setTitle("MatBaa Otomation");
        window.setScene(new Scene(root));
        window.initStyle(StageStyle.UNDECORATED);

        window.show();
    }
}
