package loginface;
import veritabani.database;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class giris_yap {


    ResultSet rs;
    PreparedStatement ps;
    public Boolean giris(String kAdi,String kSifre)
    {
        database db = new database();
        db.baglan();

        String sorgu = "select * from musteri_veritabani where kullaniciadi=?";
        try{
ps = db.con.prepareStatement(sorgu);
ps.setString(1,kAdi);
rs= ps.executeQuery();
while(rs.next())
{
    String ka= rs.getString("loginid");
    String passw = rs.getString("passid");
if(ka.equals(kAdi)&&passw.equals(kSifre))
{return true;}
else
    return false;
}

rs.close();
ps.close();
db.kapat();
        }catch (Exception hata)
        {
            JOptionPane.showMessageDialog(null,"Bilinmeyen Hata"+hata);
        }
        return  false;
    }
}
