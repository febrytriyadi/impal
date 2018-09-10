/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.data;
import view.tambahdata;

/**
 *
 * @author Administrator
 */
public class tambahdata_kontroler implements MouseListener{
    private tambahdata gui;
    private String nama;
    private database db = new database();
    public tambahdata_kontroler(String x){
        db.konek();
        nama = x;
        gui = new tambahdata();
        gui.setVisible(true);
        gui.addlistener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getKembali())){
            gui.dispose();
            new main_kontroler(nama);
        }else if (source.equals(gui.getSimpan())){
            data x = gui.getdata();
            if (x!=null){
            String command = "insert into data values('"+x.getid()+"',"
                    +x.getAkreditasidosen()+","
                    +x.getJmldosen()+","
                    +x.getTingkatkesejahteraandosen()+","
                    +x.getKurikulum()+","
                    +x.getFasilitasmengajar()+","
                    +x.getFasilitaspraktikum()+","
                    +x.getSksmengajar()+","
                    +x.getSkspraktikum()+","
                    +x.getjumlahmhs()+","
                    +x.getJumlahmhsperkelas()+","
                    +x.getTingkatkeaktifan()+","
                    +x.getJumlahasistensi()+")";
            db.isidata(command);
            JOptionPane.showMessageDialog(gui, "berhasil", "pesan", 2);
            gui.dispose();
            new main_kontroler(nama);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
