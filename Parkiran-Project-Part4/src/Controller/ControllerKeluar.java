package Controller;

import dao.DaoKeluar;
import dao.InterfaceMasuk;
import dao.InterfaceKeluar;
import View.ViewKeluar;
import Model.ModelKeluar;
import Model.ModelMasuk;
import Model.TabelModelKeluar;
import Model.TabelModelMasuk;
import View.ViewMasuk;
import java.time.LocalTime;
import dao.DaoMasuk;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerKeluar {

    private ViewKeluar view;

    InterfaceMasuk infcKeluar;
    List<ModelMasuk> listKeluar;

    InterfaceKeluar infcKeluarr;
    List<ModelKeluar> listKeluarr;

    public ControllerKeluar(ViewKeluar view) {
        this.view = view;
        infcKeluar = new DaoMasuk();
        listKeluar = infcKeluar.getData();

        infcKeluarr = new DaoKeluar();
        listKeluarr = infcKeluarr.getData();
    }

    public void loadTable() {
        listKeluarr = infcKeluarr.getData();
        TabelModelKeluar tmk = new TabelModelKeluar(listKeluarr);
        view.getTabelKeluar().setModel(tmk);
    }

    public void getEditRow() {
        int i = view.getTabelKeluar().getSelectedRow();

        if (i > -1)
        {
            view.getNoplat().setText(view.getTabelKeluar().getValueAt(i, 1).toString());
        }
    }

    public void insertData() {
        ModelKeluar keluar2 = new ModelKeluar();
        keluar2.setNama(view.getNama().getText());
        keluar2.setNoplat(view.getNoplat().getText());
        keluar2.setJenis(view.getJenis().getText());
        keluar2.setHarga(view.getHarga());
        keluar2.setLama(Integer.parseInt(view.getLama().getText()));
        keluar2.setTotal(Integer.parseInt(view.getTotal().getText()));
        infcKeluarr.insert(keluar2);

        ModelMasuk masuk2 = new ModelMasuk();
        masuk2.setNoplat(view.getNoplat().getText());
        infcKeluar.delete(masuk2);

        JOptionPane.showMessageDialog(view, "Berhasil menambahkan data baru");
        view.getNoplat().setText("");
        view.getNama().setText("");
        view.getJenis().setText("");
        view.getTglMasuk().setText("");
        view.getLama().setText("");
        view.getTotal().setText("");
        loadTable();
    }

    public void deleteData() {
        ModelKeluar keluar = new ModelKeluar();
        keluar.setNoplat(view.getNoplat().getText());
        if (keluar.getNoplat().isEmpty())
        {
            // Menampilkan pesan kesalahan kepada pengguna
            JOptionPane.showMessageDialog(null, "Anda belum memilih data", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } else
        {
        infcKeluarr.delete(keluar);
        JOptionPane.showMessageDialog(view, "Berhasil dihapus");
        view.getNoplat().setText("");
        loadTable();

        }

    }

    public void cariDataMasuk() {
        String cari = view.getNoplat().getText();
        System.out.println(cari);
        listKeluar = infcKeluar.search(cari);
        if (listKeluar.isEmpty())
        {
            JOptionPane.showMessageDialog(view, "Nomer Kendaraan tidak Ditemukan");
        } else
        {
            for (ModelMasuk list : listKeluar)
            {
                String nama = list.getNama();
                String jenis = list.getJenis();
                String tgl = list.getTglMasuk();
                System.out.println(tgl);

                view.getNama().setText(nama);
                view.getJenis().setText(jenis);
                view.getTglMasuk().setText(tgl);
            }
        }
    }

}
