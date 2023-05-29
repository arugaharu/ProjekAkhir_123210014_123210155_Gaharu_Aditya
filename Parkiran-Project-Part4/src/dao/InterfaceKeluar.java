/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Model.ModelKeluar;
import Model.ModelMasuk;
import java.util.List;

/**
 *
 * @author dell
 */
public interface InterfaceKeluar {

    public void insert(ModelKeluar keluar);

    public void delete(ModelKeluar keluar);

    public List<ModelKeluar> getData();

    public List<ModelKeluar> search(String keyword);

}
