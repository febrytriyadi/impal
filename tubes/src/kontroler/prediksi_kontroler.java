/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import model.data;
import view.prediksi;

/**
 *
 * @author Administrator
 */
public class prediksi_kontroler implements MouseListener{
    private String nama;
    private prediksi gui;
    public prediksi_kontroler(String x){
        nama = x;
        gui = new prediksi();
        gui.addlistener(this);
        gui.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getKembali())){
            gui.dispose();
            new main_kontroler(nama);
        }else{
            if (gui.getdata()!=null&&gui.getselecteddata()!=null && gui.getnilai()!=-1){
                data x = gui.getdata();
                data y = gui.getselecteddata();
                double p = (y.getAkreditasidosen() -  x.getAkreditasidosen())*0.5;
                double q = (y.getjumlahmhs()/y.getJmldosen() - x.getjumlahmhs()/x.getJmldosen())*2.5;
                double r = (y.getTingkatkesejahteraandosen() - x.getTingkatkesejahteraandosen())*0.4;
                double s = (y.getKurikulum() - x.getKurikulum()) * 2.3;
                double t = (x.getFasilitasmengajar() - y.getFasilitasmengajar())*0.6;
                double u = (x.getFasilitaspraktikum() - y.getFasilitaspraktikum())*0.6;
                double v = (x.getSksmengajar() - y.getSksmengajar())*3/100;
                double w = (x.getSkspraktikum() - y.getSkspraktikum())*2/100;
                double z = (y.getJumlahmhsperkelas() - x.getJumlahmhsperkelas())*0.5;
                double a = (y.getTingkatkeaktifan() - x.getTingkatkeaktifan())*3;
                double b = (x.getJumlahasistensi() - y.getJumlahasistensi())*1.7;
                double c = a+b+p+q+r+s+t+u+v+w+z+100;
                double nilai = gui.getnilai()*c/100;
                if (c>=100){
                    JOptionPane.showMessageDialog(gui, "nilai mengalami kenaikan sebesar "+(c-100)+"% \n prediksi nilai "+(nilai), "hasil", 1);
                }else JOptionPane.showMessageDialog(gui, "nilai mengalami penurunan sebesar "+(-1*(c-100))+"% \n prediksi nilai "+(nilai), "hasil", 0);
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
