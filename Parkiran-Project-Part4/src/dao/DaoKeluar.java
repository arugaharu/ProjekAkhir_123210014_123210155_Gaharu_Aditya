/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DBConnect.Connector;
import Model.ModelKeluar;
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

public class DaoKeluar implements InterfaceKeluar {

    Connector connection = new Connector();
    Connection koneksi;

    final String insert = "INSERT INTO keluar (nama,noplat,jenis,harga, lama, total) VALUES (?, ?, ?,?, ?, ?);";
    final String delete = "DELETE FROM keluar WHERE noplat=? ;";
    final String select = "SELECT * FROM keluar;";
    final String search = "SELECT * FROM keluar WHERE noplat like ?";

    public DaoKeluar() {
        koneksi = connection.getConnection();
    }

    @Override
    public void insert(ModelKeluar keluar) {
        PreparedStatement statement = null;
        try
        {
            statement = koneksi.prepareStatement(insert);
            statement.setString(1, keluar.getNama());
            statement.setString(2, keluar.getNoplat());
            statement.setString(3, keluar.getJenis());
            statement.setInt(4, keluar.getHarga());
            statement.setInt(5, keluar.getLama());
            statement.setInt(6, keluar.getTotal());
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
    public void delete(ModelKeluar keluar) {
        PreparedStatement statement = null;
        try
        {
            statement = koneksi.prepareStatement(delete);
            statement.setString(1, keluar.getNoplat());
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
    public List<ModelKeluar> getData() {
        List<ModelKeluar> listKeluar = null;
        try
        {
            listKeluar = new ArrayList<ModelKeluar>();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next())
            {
                ModelKeluar keluar = new ModelKeluar();
                keluar.setNama(rs.getString("nama"));
                keluar.setNoplat(rs.getString("noplat"));
                keluar.setJenis(rs.getString("jenis"));
                keluar.setHarga(rs.getInt("harga"));
                keluar.setLama(rs.getInt("lama"));
                keluar.setTotal(rs.getInt("total"));
                listKeluar.add(keluar);
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(DaoKeluar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listKeluar;
    }

    @Override
    public List<ModelKeluar> search(String keyword) {
        List<ModelKeluar> listKeluar = new ArrayList<>();
        try
        {
            PreparedStatement statement = koneksi.prepareStatement(search);
            statement.setString(1, "%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                ModelKeluar keluar = new ModelKeluar();
                keluar.setNama(rs.getString("nama"));
                keluar.setNoplat(rs.getString("noplat"));
                keluar.setJenis(rs.getString("jenis"));
                keluar.setHarga(rs.getInt("harga"));
                keluar.setLama(rs.getInt("lama"));
                keluar.setTotal(rs.getInt("total"));
                listKeluar.add(keluar);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return listKeluar;
    }

}
