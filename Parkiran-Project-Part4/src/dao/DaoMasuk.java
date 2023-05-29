package dao;

import DBConnect.Connector;
import Model.ModelMasuk;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoMasuk implements InterfaceMasuk {

    Connector connection = new Connector();
    Connection koneksi;

    final String insert = "INSERT INTO masuk (nama,noplat,jenis,tglMasuk) VALUES (?, ?, ?,?);";
    final String update = "UPDATE masuk SET nama=?, noplat=?, jenis=?, tglMasuk=? WHERE noplat=? ;";
    final String delete = "DELETE FROM masuk WHERE noplat=? ;";
    final String select = "SELECT * FROM masuk;";
    final String search = "SELECT * FROM masuk WHERE noplat like ?";

    public DaoMasuk() {
        koneksi = connection.getConnection();
    }

    @Override
    public void insert(ModelMasuk masuk) {
        PreparedStatement statement = null;
        try
        {
            statement = koneksi.prepareStatement(insert);
            statement.setString(1, masuk.getNama());
            statement.setString(2, masuk.getNoplat());
            statement.setString(3, masuk.getJenis());
//            statement.setString(4, timestampString);
            statement.setString(4, masuk.getTglMasuk());
            statement.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(ModelMasuk masuk) {
        PreparedStatement statement = null;
        try
        {
            statement = koneksi.prepareStatement(update);
            statement.setString(1, masuk.getNama());
            statement.setString(2, masuk.getNoplat());
            statement.setString(3, masuk.getJenis());
//            statement.setString(4, timestampString);
            statement.setString(4, masuk.getTglMasuk());
            statement.setString(5, masuk.getNoplat());
            statement.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(ModelMasuk masuk) {
        PreparedStatement statement = null;
        try
        {
            statement = koneksi.prepareStatement(delete);
            statement.setString(1, masuk.getNoplat());
            statement.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        } finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                } catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<ModelMasuk> getData() {
        List<ModelMasuk> listMasuk = null;
        try
        {
            listMasuk = new ArrayList<ModelMasuk>();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next())
            {
                ModelMasuk masuk = new ModelMasuk();
                masuk.setNama(rs.getString("nama"));
                masuk.setNoplat(rs.getString("noplat"));
                masuk.setJenis(rs.getString("jenis"));
                masuk.setTglMasuk(rs.getString("tglMasuk"));
                listMasuk.add(masuk);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DaoMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listMasuk;
    }

    @Override
    public List<ModelMasuk> search(String keyword) {
        List<ModelMasuk> listMasuk = new ArrayList<>();
        try
        {
            PreparedStatement statement = koneksi.prepareStatement(search);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                ModelMasuk masuk = new ModelMasuk();
                masuk.setNama(rs.getString("nama"));
                masuk.setNoplat(rs.getString("noplat"));
                masuk.setJenis(rs.getString("jenis"));
                listMasuk.add(masuk);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return listMasuk;
    }
}
