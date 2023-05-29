/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import java.time.LocalDateTime;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dell
 */
public class TabelModelKeluar extends AbstractTableModel {

    List<ModelKeluar> mdlKeluar;

    public TabelModelKeluar(List<ModelKeluar> mdlKeluar) {
        this.mdlKeluar = mdlKeluar;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return mdlKeluar.size();
    }

    @Override
    public String getColumnName(int column) {
        switch (column)
        {
            case 0:
                return "Nama";
            case 1:
                return "Noplat";
            case 2:
                return "Jenis";
            case 3:
                return "Harga";
            case 4:
                return "Lama";
            case 5:
                return "Total";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column)
        {
            case 0:
                return mdlKeluar.get(row).getNama();
            case 1:
                return mdlKeluar.get(row).getNoplat();
            case 2:
                return mdlKeluar.get(row).getJenis();
            case 3:
                return mdlKeluar.get(row).getHarga();
            case 4:
                return mdlKeluar.get(row).getLama();
            case 5:
                return mdlKeluar.get(row).getTotal();
            default:
                return null;
        }
    }
}
