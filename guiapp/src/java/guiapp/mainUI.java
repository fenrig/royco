/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiapp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author fenrig
 */
public class mainUI extends JFrame implements ActionListener{
    private Controller controller;
    private JPanel jpanel_panel = new JPanel(new GridLayout(0,1));
    private JTextArea jtextarea_output = new JTextArea();
    private JButton jbutton_bereken = new JButton("Werk saldo's bij");
    
    public mainUI(Controller controllerx){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.controller = controllerx;
        
        this.jpanel_panel.add(this.jtextarea_output);
        this.jpanel_panel.add(this.jbutton_bereken);
        
        this.getContentPane().add(this.jpanel_panel);
        this.setSize(400, 400);
        
        this.jbutton_bereken.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.jbutton_bereken){
            this.jtextarea_output.setText(this.controller.werkIntrestvoetenbij());
        }
    }
}
