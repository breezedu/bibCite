//import package

import java.awt.datatransfer.Clipboard;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;




/***************************************************
 * A JFrame to load getBIB_title.java
 * 
 * @author Jeff
 *
 */
public class D0311FrameBibCite extends JFrame {

	//set serialVersionUID, by default
	private static final long serialVersionUID = -5624404136485946868L;

	String userWord = "";
	String citeWork = ""; 
	
	//a TextFile to input the title of the paper user wants to cite
	JTextField userInput;

	/***************************
	 * implement the FrameWork;
	 */
	public D0311FrameBibCite() {
		JFrame jf = new JFrame();
		
		final JPanel panel = new JPanel();
		
		//the panel on top, to tell user to input the title; 
		JLabel jl = new JLabel("\nPlease input the title of the paper you want to cite: \n");
		
		//the width of input TextField;
		userInput = new JTextField(" ", 30);
		
		//the panel in the middle of the Frame;
		final JLabel j2 = new JLabel("\nThe BibTeX citation: \n");
		
		//to display the bibTeX format of citation
		final JTextArea bibCitation = new JTextArea(citeWork); 
		
	    // create our jbutton
	    JButton showDialogButton = new JButton("Submit");
	    
	    // add the listener to the jbutton to handle the "pressed" event
	    showDialogButton.addActionListener(new ActionListener()
	    {
	    	//the action after user clicking "Submit" button; 
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		try {
	    			//click the button action method(); 
	    			submitAction(panel, j2, bibCitation);
	    		
	    		} catch (InterruptedException | UnsupportedFlavorException
					| IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
	    		} 
	    	} //end of actionPerformed() method; 
	    });
		
		
		//set the size of the jFrame; 
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add panel; 
		jf.add(panel);
		
		//use BoxLayout
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(jl);
		panel.add(userInput);
		panel.add(showDialogButton);
		
		panel.add(j2);
		panel.add(bibCitation); 
	
	} //end FrameBibCite(); 

	/***************
	 * 
	 * @param panel
	 * @param bibCitation 
	 * @param j22 
	 * @throws InterruptedException
	 * @throws UnsupportedFlavorException
	 * @throws IOException
	 */
	private void submitAction(JPanel panel, JLabel j22, JTextArea bibCitation) throws InterruptedException, UnsupportedFlavorException, IOException {
		userWord = userInput.getText();
		//do something with the variabe userWord here (print it to the console, etc.)
	
		D20170305_getBIB_title getBib = new D20170305_getBIB_title();
		getBib.run(userWord);		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		
		citeWork= (String) clipboard.getData(DataFlavor.stringFlavor);
		
		System.out.println("citework: " + citeWork);
		
		
		//JPanel panel2 = new JPanel();
		//panel.add(panel2);
		
		bibCitation.setText(citeWork); 
				
		panel.repaint();
		
	}

	/*************
	 * main()
	 * @param args
	 */
	public static void main(String[] args) {
		
		new FrameBibCite();
	
	}//end main(); 
}
