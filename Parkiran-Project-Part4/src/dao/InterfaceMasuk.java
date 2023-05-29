
package dao;

import Model.ModelMasuk;
import java.util.List;

public interface InterfaceMasuk {    
    public void insert(ModelMasuk masuk);

    public void update(ModelMasuk masuk);

    public void delete(ModelMasuk masuk);
    
    public List<ModelMasuk> getData();
    
    public List<ModelMasuk> search(String keyword);
}
