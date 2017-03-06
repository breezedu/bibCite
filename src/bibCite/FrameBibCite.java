package bibCite;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class FrameBibCite extends javax.swing.JFrame {
    public FrameBibCite() {
        super("Demo program for JFrame");
        
        
        JFrame frame = new JFrame("Demo program for JFrame");
        
        frame.setLayout(new GridBagLayout());
        
        //frame.setLayout(new GridLayout());
        
        //frame.setLayout(new CardLayout());
        
        //frame.getContentPane().setLayout(layout);
        
        JTextField textFieldUserName = new JTextField(50);
        frame.add(textFieldUserName);
        
        add(textFieldUserName, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);
         
        menuBar.add(menuFile);
         
        // adds menu bar to the frame
        frame.setJMenuBar(menuBar);
        
        
        
        
    }
    
    
}
