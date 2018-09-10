/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import database.database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import view.login;

/**
 *
 * @author Administrator
 */
public class login_kontroler implements MouseListener{
    private login gui;
    private database db = new database();
    private ResultSet rs=null;
    public login_kontroler(){
        db.konek();
        gui = new login();
        gui.setVisible(true);
        gui.addlistener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        String command = "select * from user where nama='"+gui.getuser()+"' and pass='"+gui.getpass()+"'";
        try {
            rs = db.getdata(command);
            if (rs.next() && rs.getString(1).equals(gui.getuser()) && rs.getString(2).equals(gui.getpass())){
                gui.dispose();
                new main_kontroler(rs.getString(1));
            }else{
                JOptionPane.showMessageDialog(gui, "maaf user dan password tidak valid","gagal",0);
                gui.reset();
            }
        } catch (Exception ae) {
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
