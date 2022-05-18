package signupface;
import veritabani.database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class kayit_ol {

    PreparedStatement ps;
    public void kayitol(String name,String email,String username,String password)
    {
        String isim=name;
        String posta=email;
        String kullaniciadi=username;
        String sifre=password;

        String insertFields="insert into musteri_veritabani(name,email,loginid,passid) values('";
        String insertValues=isim + "','"+ posta+"','"+kullaniciadi+ "','"+sifre +"')";
        String insertToRegister=insertFields+insertValues;
        try
        {
database db = new database();
db.baglan();
ps=db.con.prepareStatement(insertToRegister);
ps.executeUpdate();
ps.close();
db.kapat();
JOptionPane.showMessageDialog(null,"Basarili Bir Sekilde Kayit Oldunuz Yönlendirilme Basladi!!!");
        }catch (Exception hata)
        {
JOptionPane.showMessageDialog(null,"Bilinmeyen bir hata "+ hata);
        }
    }

}
