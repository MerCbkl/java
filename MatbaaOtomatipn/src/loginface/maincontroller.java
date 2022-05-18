package loginface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import  javafx.scene.image.Image;
import veritabani.database;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class maincontroller implements Initializable {
    @FXML
private Button btn;
    @FXML
    private Text signupbtn;
    @FXML
    private AnchorPane scenePane;
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
    private javafx.scene.control.TextField usernameField1;
    @FXML
    private PasswordField passwordField1;
@Override
    public void initialize(URL url , ResourceBundle resourceBundle)
    {
File brandingFile = new File("@../../icon/icons8_login_100px.png");
Image brandingimage = new Image(brandingFile.toURI().toString());
img1.setImage(brandingimage);
        File brandingFile2 = new File("@../../icon/icons8_username_32px_1.png");
        Image brandingimage2 = new Image(brandingFile2.toURI().toString());
        img2.setImage(brandingimage2);
        File brandingFile3 = new File("@../../icon/icons8_password_64px.png");
        Image brandingimage3 = new Image(brandingFile3.toURI().toString());
        img3.setImage(brandingimage3);
        File brandingFile4 = new File("@../../icon/icons8_login_50px.png");
        Image brandingimage4 = new Image(brandingFile4.toURI().toString());
        img4.setImage(brandingimage4);
        File brandingFile5 = new File("@../../icon/icons8_yoga_mat_50px_3.png");
        Image brandingimage5 = new Image(brandingFile5.toURI().toString());
        img5.setImage(brandingimage5);

    }
    Stage stage;
    Scene scene1,scene2;
    public void logout(ActionEvent event)
    {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
public void signupbtnaction() throws Exception
{
    stage = (Stage) scenePane.getScene().getWindow();
    stage.close();
    Stage window = new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("../signupface/signup.fxml"));
    window.setTitle("MatBaa Otomation");
    window.setScene(new Scene(root));
    window.initStyle(StageStyle.UNDECORATED);

    window.show();

}
public void loginbuttonAction(ActionEvent event)
{
if(usernameField1.getText().isBlank()==false && passwordField1.getText().isBlank()==false)
{
    try {
        validateLogin();
    } catch (Exception e) {
        e.printStackTrace();
    }
}else
{
    JOptionPane.showMessageDialog(null,"Kullanıcı Adı Veya Şifre Yanlış");

}
}
public void validateLogin() throws Exception
{
    giris_yap control = new giris_yap();
   if( control.giris(usernameField1.getText(),passwordField1.getText()))
   {
       JOptionPane.showMessageDialog(null,"Giris Basarili Bir Sonraki Sayfaya Aktarılıyorsunuz!");
       stage = (Stage) scenePane.getScene().getWindow();
       stage.close();
       Stage window = new Stage();
       Parent root = FXMLLoader.load(getClass().getResource("../otomationface/anaface.fxml"));
       window.setTitle("MatBaa Otomation");
       window.setScene(new Scene(root));
       window.initStyle(StageStyle.UNDECORATED);

       window.show();
   }else
   {
       JOptionPane.showMessageDialog(null,"Sifre Yanlis Lütfen Bir  Daha Deneyiniz! ");
   }


}

}
