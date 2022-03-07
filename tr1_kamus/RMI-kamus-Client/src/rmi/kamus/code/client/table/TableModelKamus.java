/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi.kamus.code.client.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rmi.kamus.code.entity.Kamus;
/**
 *
 * @author ACER
 */
public class TableModelKamus extends AbstractTableModel{
    private List<Kamus> list = new ArrayList<Kamus>();
    
    public Kamus get(int row) {
        return list.get(row);
    }
    
    public void setData(List<Kamus> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount() {
        return 4;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNomor();
            case 1:
                return list.get(rowIndex).getKata_indonesia();
            case 2:
                return list.get(rowIndex).getJenis();
            case 3:
                return list.get(rowIndex).getKata_inggris();
                
            default:
                return null;
        }
    }
    
    
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Kata(Indonesia)";
            case 2:
                return "Jenis";
            case 3:
                return "Kata(Inggris)";
                
            default:
                return null;
        }
    }
    
}
