/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.daftar;

/**
 *
 * @author Administrator
 */
public class daftar_kontroler implements MouseListener,ActionListener{
    private daftar gui;
    private database db = new database();
    private ResultSet rs;
    public daftar_kontroler(){
        db.konek();
        gui = new daftar();
        gui.setVisible(true);
        gui.addlistener(this);
        gui.addmouseistener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source.equals(gui.getexit())){
            gui.dispose();
            new login_kontroler();
        }//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String username=gui.getusername().trim();
        String password=gui.getpassword().trim();
        String nama=gui.getnama();
        String alamat=gui.getalamat();
        char kelamin=gui.getkelamin();
        String email=gui.getemail();
        String agama=gui.getagama();
        String nomor=gui.getnomor();
        if(username.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(gui,"tidak boleh ada fild yang kosong","error",0);
        }else{
            try {
                rs = db.getdata("select username from userpass where username='"+username+"'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(gui,"username sudah dipakai orang lain","error",0);
                }else{
                    String command="insert into userpass values('"+
                            username+"'"+
                            ",'"+password+"'"+
                            ",'c')";
                    db.isidata(command);
                    command="insert into customer(nama,alamat,nomer_telp,jenis_kelamin,email,agama,username) values('"
                            + nama+"','"
                            + alamat+"','"
                            + nomor +"','"
                            + kelamin+"','"
                            + email+"','"
                            + agama+"','"
                            + username+"')";
                    db.isidata(command);
                    JOptionPane.showMessageDialog(gui,"silahkan login","selamat",1);
                    gui.dispose();
                    new login_kontroler();
                }
            } catch (SQLException ex) {
                Logger.getLogger(daftar_kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
