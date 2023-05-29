package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ModelMasuk {
    private String nama;
    private String noplat;
    private String jenis;
    private String tglMasuk;

    public String getTglMasuk() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String tglMasukk = dateTime.format(formatter);
        return tglMasukk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getNama() {
        return nama;
    }
        
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNoplat() {
        return noplat;
    }

    
    public void setNoplat(String noplat) {
        this.noplat = noplat;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
