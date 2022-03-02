package rmi.mahasiswa.arry.code.client.table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rmi.mahasiswa.code.entity.Mahasiswa;

//Class untuk menampilkan data yang ada pada database ke table JFrame
public class TableModelMahasiswa extends AbstractTableModel {
    private List<Mahasiswa> list = new ArrayList<Mahasiswa>();
    
    //untuk mendapatkan data dan menampilkannya ke dalam table
    public Mahasiswa get(int row) {
        return list.get(row);
    }
    
    //untuk merubah data yang ada pada table
    public void setData(List<Mahasiswa> list) {
        this.list = list;
        fireTableDataChanged();
    }
    
    //menentukan jumlah baris pada table berdasarkan data yang ada
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    //menentukan banyak jumlah kolom pada table
    @Override
    public int getColumnCount() {
        return 5; //5 Kolom
    }
    
    //Mengambil dan menampilkan data ke dalam kolom yang ditentukan
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                 return list.get(rowIndex).getNpm();
            case 1:
               return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJurusan();
            case 3:
                return list.get(rowIndex).getAlamat();
            case 4:
                return list.get(rowIndex).getPhone();
          
            default:
                return null;
        }
    }
    
    //Menentukan judul setiap kolom
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Npm";
            case 1:
                return "Nama";
            case 2:
                return "Jurusan";
            case 3:
                return "Alamat";
            case 4:
                return "Phone";
            
            default:
                return null;
        }
    }
    
}