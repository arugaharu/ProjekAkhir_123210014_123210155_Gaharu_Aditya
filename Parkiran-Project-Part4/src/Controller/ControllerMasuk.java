package Controller;

import dao.DaoMasuk;
import dao.InterfaceMasuk;
import View.ViewMasuk;
import Model.ModelMasuk;
import Model.TabelModelMasuk;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMasuk {

    private ViewMasuk view;
    InterfaceMasuk infcMasuk;
    List<ModelMasuk> listMasuk;

    public ControllerMasuk(ViewMasuk view) {
        this.view = view;
        infcMasuk = new DaoMasuk();
        listMasuk = infcMasuk.getData();
    }

    public void loadTable() {
        listMasuk = infcMasuk.getData();
        TabelModelMasuk tmm = new TabelModelMasuk(listMasuk);
        view.getTabelMasuk().setModel(tmm);
    }

    public void insertData() {

        ModelMasuk masuk = new ModelMasuk();
        masuk.setNama(view.getNama().getText());
        masuk.setNoplat(view.getNoplat().getText());
        masuk.setJenis(view.getJenis());

        if (masuk.getNama().isEmpty())
        {
            // Menampilkan pesan kesalahan kepada pengguna
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else if (masuk.getNoplat().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Nomer kendaraan tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);

        } else if (masuk.getJenis() == null)
        {
            JOptionPane.showMessageDialog(null, "Jenis kendaraan tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);

        }
        {
            infcMasuk.insert(masuk);
            view.getNama().setText("");
            view.getNoplat().setText("");
            loadTable();
            view.getNama().setText("");
            view.getNoplat().setText("");
        }
    }

    public void getEditRow() {
        int i = view.getTabelMasuk().getSelectedRow();

        if (i > -1)
        {
            view.getNama().setText(view.getTabelMasuk().getValueAt(i, 0).toString());
            view.getNoplat().setText(view.getTabelMasuk().getValueAt(i, 1).toString());
        }
    }

    public void editData() {

        ModelMasuk masuk = new ModelMasuk();
        masuk.setNama(view.getNama().getText());
        masuk.setNoplat(view.getNoplat().getText());
        masuk.setJenis(view.getJenis());

// Memeriksa apakah input kosong
        if (masuk.getNama().isEmpty())
        {
            // Menampilkan pesan kesalahan kepada pengguna
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else if (masuk.getNoplat().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Nomer kendaraan tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);

        } else if (masuk.getJenis() == null)
        {
            JOptionPane.showMessageDialog(null, "Jenis kendaraan tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);

        }
        {
//            JOptionPane.showMessageDialog(view, "Berhasil diedit");
            infcMasuk.update(masuk);
            loadTable();
            view.getNama().setText("");
            view.getNoplat().setText("");
        }
    }

    public void deleteData() {
        ModelMasuk masuk = new ModelMasuk();
        masuk.setNoplat(view.getNoplat().getText());
        if (masuk.getNoplat().isEmpty())
        {
            // Menampilkan pesan kesalahan kepada pengguna
            JOptionPane.showMessageDialog(null, "Anda belum memilih data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else
        {
            infcMasuk.delete(masuk);
            JOptionPane.showMessageDialog(view, "Berhasil dihapus");
            loadTable();
            view.getNama().setText("");
            view.getNoplat().setText("");
            view.getJenis().isEmpty();
        }
    }

    public void cariData() {
        String cari = view.getCari().getText();
      
        listMasuk = infcMasuk.search(cari);
        TabelModelMasuk tmm = new TabelModelMasuk(listMasuk);
        view.getTabelMasuk().setModel(tmm);
       
    }

}
