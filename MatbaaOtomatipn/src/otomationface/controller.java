package otomationface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import veritabani.database;

import javax.swing.*;

public class controller
{
PreparedStatement ps;
ResultSet rs;
database db;
    private long m_TCKNO;
    private String m_Ad;
    private String m_Soyad;
    private String m_SirketAd;
    private int m_baskisayi;
    private int m_baskisure;
    private String m_baslangictarih;
    private String m_bitistarih;
    private boolean m_renksecimi;
    private boolean m_kalitesecimi;
    private boolean m_yumusatmasecimi;
    private int m_ortmoney;
    private String m_adres;
    public long getM_TCKNO()
    {
        return m_TCKNO;
    }
    public void setM_TCKNO(long m_TCKNO)
    {
        this.m_TCKNO=m_TCKNO;
    }
    public String getM_Ad()
    {
        return m_Ad;
    }
    public void setM_Ad(String m_Ad)
    {
        this.m_Ad=m_Ad;
    }
    public String getM_Soyad()
    {
        return m_Soyad;
    }
    public void setM_Soyad(String m_Soyad)
    {
        this.m_Soyad=m_Soyad;
    }

    public String getM_SirketAd() {
        return m_SirketAd;
    }

    public void setM_SirketAd(String m_SirketAd) {
        this.m_SirketAd = m_SirketAd;
    }

    public int getM_baskisayi() {
        return m_baskisayi;
    }

    public void setM_baskisayi(int m_baskisayi) {
        this.m_baskisayi = m_baskisayi;
    }

    public int getM_baskisure() {
        return m_baskisure;
    }

    public void setM_baskisure(int m_baskisure) {
        this.m_baskisure = m_baskisure;
    }

    public String getM_baslangictarih() {
        return m_baslangictarih;
    }

    public void setM_baslangictarih(String m_baslangictarih) {
        this.m_baslangictarih = m_baslangictarih;
    }

    public String getM_bitistarih() {
        return m_bitistarih;
    }

    public void setM_bitistarih(String m_bitistarih) {
        this.m_bitistarih = m_bitistarih;
    }

    public boolean isM_renksecimi() {
        return m_renksecimi;
    }

    public void setM_renksecimi(boolean m_renksecimi) {
        this.m_renksecimi = m_renksecimi;
    }

    public boolean isM_kalitesecimi() {
        return m_kalitesecimi;
    }

    public void setM_kalitesecimi(boolean m_kalitesecimi) {
        this.m_kalitesecimi = m_kalitesecimi;
    }

    public boolean isM_yumusatmasecimi() {
        return m_yumusatmasecimi;
    }

    public void setM_yumusatmasecimi(boolean m_yumusatmasecimi) {
        this.m_yumusatmasecimi = m_yumusatmasecimi;
    }
    public int getM_ortmoney() {
        return m_ortmoney;
    }

    public void setM_ortmoney(int m_ortmoney) {
        this.m_ortmoney = m_ortmoney;
    }
    public String getM_adres() {
        return m_adres;
    }

    public void setM_adres(String m_adres) {
        this.m_adres = m_adres;
    }
    public boolean musteriEkle(controller m_ekle)
    {

        try{
            db.baglan();
            String sorgu ="insert into company_info(tc_no,ad,soy_ad,sirket_ad,alinanort_ucret,baski_sayisi,baski_sure,baslangic_tarih,bitis_tarih,renklirenksiz,kalitesecim,yumusatma,adres) values(?,?,?,?,?,?,?,?,?,?,?,?,?))";
  ps=db.con.prepareStatement(sorgu);
  ps.setLong(1,m_ekle.getM_TCKNO());
  ps.setString(2,m_ekle.getM_Ad());
  ps.setString(3,m_ekle.getM_Soyad());
  ps.setString(4,m_ekle.getM_SirketAd());
  ps.setInt(5,m_ekle.getM_ortmoney());
  ps.setInt(6,m_ekle.getM_baskisayi());
  ps.setInt(7,m_ekle.getM_baskisure());
  ps.setString(8,m_ekle.getM_baslangictarih());
  ps.setString(9,m_ekle.getM_bitistarih());
  ps.setBoolean(10,m_ekle.isM_renksecimi());
            ps.setBoolean(11,m_ekle.isM_kalitesecimi());
            ps.setBoolean(12,m_ekle.isM_yumusatmasecimi());
            ps.setString(13,m_ekle.getM_adres());
            ps.execute();
            ps.close();
            db.kapat();
            return true;
        }catch (Exception hata)
        {

            JOptionPane.showMessageDialog(null,"Hata:"+hata);
            return false;
        }
    }
    public boolean musteriBul(controller m_Bul)
    {

        try
        {
db.baglan();
String sorgu = "select * from company_info where tc_no = ?";
ps=db.con.prepareStatement(sorgu);
ps.setLong(1,m_Bul.getM_TCKNO());
rs= ps.executeQuery();
rs.next();
setM_Ad(rs.getString("ad"));
            setM_Soyad(rs.getString("soy_ad"));
            setM_SirketAd(rs.getString("sirket_ad"));
            setM_baskisayi(rs.getInt("baski_sayisi"));
            setM_ortmoney(rs.getInt("alinanort_ucret"));
            setM_baskisure(rs.getInt("baskisure"));
            setM_baslangictarih(rs.getString("baslangic_tarih"));
            setM_bitistarih(rs.getString("bitis_tarih"));
            setM_renksecimi(rs.getBoolean("renklirenksiz"));
            setM_kalitesecimi(rs.getBoolean("kalitesecim"));
            setM_yumusatmasecimi(rs.getBoolean("yumusatma"));
            setM_adres(rs.getString("adres"));
            ps.close();
            db.kapat();
            return true;
        }catch (Exception hata)
        {
            JOptionPane.showMessageDialog(null,"Hata:"+hata);
            return false;
        }
    }

    public boolean musteri_sil(controller m_sil)
    {

        try
        {
            db.baglan();
            String sorgu = "delete from company_info where tc_no =?";
            ps=db.con.prepareStatement(sorgu);
            ps.setLong(1,m_sil.getM_TCKNO());
            ps.execute();
            ps.close();
            db.kapat();
            return true;
        }catch (Exception hata)
        {

            JOptionPane.showMessageDialog(null,"Hata:"+hata);
            return false;
        }
    }

    public boolean musteri_guncelle(controller m_guncelle)
    {

        try
        {
db.baglan();
String sorgu="update company_info set ad=?,soy_ad=?,sirket_ad=?,baski_sayisi=?,alinanort_ucret=?,baski_sure=?,baslangic_tarih=?,bitis_tarih=?,renklirenksiz=?,kalitesecim=?,yumusatma=?,adres=? where tc_no=?";
ps=db.con.prepareStatement(sorgu);
ps.setString(1,m_guncelle.getM_Ad());
ps.setString(2,m_guncelle.getM_Soyad());
ps.setString(3,m_guncelle.getM_SirketAd());
ps.setInt(4,m_guncelle.getM_baskisayi());
ps.setInt(5,m_guncelle.getM_ortmoney());
ps.setInt(6,m_guncelle.getM_baskisure());
ps.setString(7,m_guncelle.getM_baslangictarih());
ps.setString(8,m_guncelle.getM_bitistarih());
ps.setBoolean(9,m_guncelle.isM_renksecimi());
            ps.setBoolean(10,m_guncelle.isM_kalitesecimi());
            ps.setBoolean(11,m_guncelle.isM_yumusatmasecimi());
            ps.setString(12,m_guncelle.getM_adres());
            ps.setLong(13,m_guncelle.getM_TCKNO());
            ps.executeUpdate();
            ps.close();
            db.kapat();
            return true;
        }catch (Exception hata)
        {
            JOptionPane.showMessageDialog(null,"Hata:"+hata);
            return false;
        }
    }



}
