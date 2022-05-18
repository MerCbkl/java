package otomationface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import  javafx.scene.image.Image;
import javafx.scene.control.TextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
public class anafacecontroller implements Initializable{
    private double xAxis=0;
    private double yAxis=0;
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
    private TextField tcknfield;
    @FXML
    private TextField adfield;
    @FXML
    private TextField soyadfield;
    @FXML
    private TextField companyfield;
    @FXML
    private TextField ort;
    @FXML
    private TextField baskifield;
    @FXML
    private TextField baskisurefield;
    @FXML
    private TextArea adresfield;
@FXML
private TextField bastarihfield;
@FXML  DatePicker datepicker1;
    @FXML
    private TextField bittarihfield;
    @FXML  DatePicker datepicker2;
@FXML
private RadioButton radiobtn1;
    @FXML
    private RadioButton radiobtn2;
    @FXML
    private RadioButton radiobtn3;
    @FXML
    private RadioButton radiobtn4;
    @FXML
    private RadioButton radiobtn5;
    @FXML
    private RadioButton radiobtn6;
    @Override
    public void initialize(URL url , ResourceBundle resourceBundle)
    {
        File brandingFile = new File("@../../icon/icons8_save_64px_2.png");
        Image brandingimage = new Image(brandingFile.toURI().toString());
        img1.setImage(brandingimage);
        File brandingFile2 = new File("@../../icon/icons8_search_50px_1.png");
        Image brandingimage2 = new Image(brandingFile2.toURI().toString());
        img2.setImage(brandingimage2);
        File brandingFile3 = new File("@../../icon/icons8_update_50px_1.png");
        Image brandingimage3 = new Image(brandingFile3.toURI().toString());
        img3.setImage(brandingimage3);
        File brandingFile4 = new File("@../../icon/icons8_table_30px_1.png");
        Image brandingimage4 = new Image(brandingFile4.toURI().toString());
        img4.setImage(brandingimage4);
        File brandingFile5 = new File("@../../icon/icons8_exit_24px_1.png");
        Image brandingimage5 = new Image(brandingFile5.toURI().toString());
        img5.setImage(brandingimage5);
        File brandingFile6 = new File("@../../icon/icons8_yoga_mat_64px_3.png");
        Image brandingimage6 = new Image(brandingFile6.toURI().toString());
        img6.setImage(brandingimage6);
radiobtn1.setSelected(true);
radiobtn3.setSelected(true);
radiobtn5.setSelected(true);
    }
    public void logout(ActionEvent event)
    {
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
  public void dtpicker1control() throws  Exception
  {
      String date=datepicker1.getValue().toString();
bastarihfield.setText(date);
  }
    public void dtpicker2control() throws  Exception
    {
        String date=datepicker2.getValue().toString();
        bittarihfield.setText(date);
    }
public void temizle()
{
    tcknfield.setText("");
    adfield.setText("");
    soyadfield.setText("");
    baskifield.setText("");
    baskisurefield.setText("");
    bastarihfield.setText("");
    bittarihfield.setText("");
    ort.setText("");
    adresfield.setText("");
    companyfield.setText("");
    radiobtn1.setSelected(true);
    radiobtn3.setSelected(true);
    radiobtn5.setSelected(true);
    radiobtn2.setSelected(false);
    radiobtn4.setSelected(false);
    radiobtn6.setSelected(false);
}
    public void kaydetBtnaction() throws Exception
    {
boolean durum=false;
controller me = new controller();
me.setM_TCKNO(Long.valueOf(tcknfield.getText()));
me.setM_Ad(adfield.getText());
me.setM_Soyad(soyadfield.getText());
me.setM_SirketAd(companyfield.getText());
me.setM_ortmoney(Integer.valueOf(ort.getText()));
me.setM_baskisure(Integer.valueOf(baskisurefield.getText()));
me.setM_baskisayi(Integer.valueOf(baskifield.getText()));
me.setM_baslangictarih(bastarihfield.getText());
me.setM_bitistarih(bittarihfield.getText());
me.setM_adres(adresfield.getText());
if(radiobtn1.isSelected()==true)
{
    me.setM_renksecimi(true);
}
if(radiobtn2.isSelected()==true)
{
    me.setM_renksecimi(false);
}
        if(radiobtn3.isSelected()==true)
        {
            me.setM_kalitesecimi(true);
        }
        if(radiobtn4.isSelected()==true)
        {
            me.setM_kalitesecimi(false);
        }
        if(radiobtn5.isSelected()==true)
        {
            me.setM_yumusatmasecimi(true);
        }
        if(radiobtn6.isSelected()==true)
        {
            me.setM_yumusatmasecimi(false);
        }
        durum=me.musteriEkle(me);
temizle();
    }
public void bulbtnaction() throws Exception
{

    img1.setDisable(true);
    img3.setDisable(false);
    img5.setDisable(false);
    boolean durum=false;
    controller me = new controller();
    me.setM_TCKNO(Long.valueOf(tcknfield.getText()));
    durum = me.musteriBul(me);
    adfield.setText(me.getM_Ad());
    soyadfield.setText(me.getM_Soyad());
    companyfield.setText(me.getM_SirketAd());
    ort.setText(String.valueOf(me.getM_ortmoney()));
    baskisurefield.setText(String.valueOf(me.getM_baskisure()));
    baskifield.setText(String.valueOf(me.getM_baskisayi()));
    bastarihfield.setText(me.getM_baslangictarih());
    bittarihfield.setText(me.getM_bitistarih());
    adresfield.setText(me.getM_adres());

    if(me.isM_renksecimi()==true)
    {
        radiobtn1.setSelected(true);
    }
    if(me.isM_renksecimi()==false)
    {
        radiobtn2.setSelected(true);
    }
    if(me.isM_kalitesecimi()==true)
    {
        radiobtn3.setSelected(true);
    }
    if(me.isM_kalitesecimi()==false)
    {
        radiobtn4.setSelected(true);
    }
    if(me.isM_yumusatmasecimi()==true)
    {
        radiobtn5.setSelected(true);
    }
    if(me.isM_yumusatmasecimi()==false)
    {
        radiobtn6.setSelected(true);
    }
    if(!durum==false)
    {
        JOptionPane.showMessageDialog(null,"Üyelik Bulunamadı!");
        temizle();
    }
}
public void btnsilaction() throws Exception
{
    img1.setDisable(false);
    img2.setDisable(false);
    img3.setDisable(true);
    img5.setDisable(true);
    boolean durum =false;
    controller me = new controller();
    me.setM_TCKNO(Long.valueOf(tcknfield.getText()));
    durum = me.musteri_sil(me);
    temizle();

}
public  void btnguncelleaction() throws Exception
{

    img1.setDisable(false);
    img2.setDisable(false);
    img5.setDisable(true);
    img3.setDisable(true);
    boolean durum =false;
    controller me = new controller();

    me.setM_TCKNO(Long.valueOf(tcknfield.getText()));
    me.setM_Ad(adfield.getText());
    me.setM_Soyad(soyadfield.getText());
    me.setM_SirketAd(companyfield.getText());
    me.setM_ortmoney(Integer.valueOf(ort.getText()));
    me.setM_baskisayi(Integer.valueOf(baskifield.getText()));
    me.setM_baskisure(Integer.valueOf(baskisurefield.getText()));
    me.setM_baslangictarih(bastarihfield.getText());
    me.setM_bitistarih(bittarihfield.getText());
    me.setM_adres(adresfield.getText());

    if(radiobtn1.isSelected()==true)
    {
        me.setM_renksecimi(true);
    }
    if(radiobtn2.isSelected()==true)
    {
        me.setM_renksecimi(false);
    }
    if(radiobtn3.isSelected()==true)
    {
        me.setM_kalitesecimi(true);
    }
    if(radiobtn4.isSelected()==true)
    {
        me.setM_kalitesecimi(false);
    }
    if(radiobtn5.isSelected()==true)
    {
        me.setM_yumusatmasecimi(true);
    }
    if(radiobtn6.isSelected()==true)
    {
        me.setM_yumusatmasecimi(false);
    }
    durum=me.musteri_guncelle(me);
    temizle();
}
public void tcknfocuslost(FocusEvent evt) throws  Exception
{
    if(tcknfield.getText().length()>11)
    {
        JOptionPane.showMessageDialog(null,"Lutfen 11 Haneli Tc Giriniz");
        tcknfield.requestFocus();
    }
}
public void tcknRelased(KeyEvent evt) throws Exception
{
    try
    {
Long.parseLong(tcknfield.getText());

    }catch (Exception ex)
    {
JOptionPane.showMessageDialog(null,"Lütfen Sayi Giriniz");
tcknfield.requestFocus();
    }
}
}
