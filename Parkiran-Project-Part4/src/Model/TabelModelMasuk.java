package Model;

import java.util.List;
import java.time.LocalDateTime;
import javax.swing.table.AbstractTableModel;

public class TabelModelMasuk extends AbstractTableModel{

    List<ModelMasuk> mdlMasuk;

    public TabelModelMasuk(List<ModelMasuk> mdlMasuk) {
        this.mdlMasuk = mdlMasuk;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return mdlMasuk.size();
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
                return "TglMasuk";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column)
        {
            case 0:
                return mdlMasuk.get(row).getNama();
            case 1:
                return mdlMasuk.get(row).getNoplat();
            case 2:
                return mdlMasuk.get(row).getJenis();
            case 3:
                return mdlMasuk.get(row).getTglMasuk();
//                return mdlMasuk.get(row).wait(column);
            default:
                return null;
        }
    }
}
