package veritabani;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class database {
    public Connection con;
    private String url="jdbc:mysql://localhost/";
    private String dbname="musteri_veritabani";
    private String driver="com.mysql.jdbc.Driver";
    private String username="root";
    private String password="";
    public void baglan()
    {
        try {
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url+dbname,username,password);
            System.out.println("baglandi");
        }catch (Exception hata)
        {
System.out.println(hata);
JOptionPane.showMessageDialog(null,"Veritabanina Baglanilmadi"+hata);
        }
    }
    public void kapat()
    {
        try
        {
con.close();
System.out.println("Baglanti Kapatildi");

        }catch (Exception hata)
        {
            JOptionPane.showMessageDialog(null,"Baglanti Kapatilmadi"+hata);

        }
    }
}
