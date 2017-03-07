package bibCite;

import java.awt.datatransfer.Clipboard;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;





public class FrameBibCite extends JFrame {

	private static final long serialVersionUID = -5624404136485946868L;

	String userWord = "";
	String citeWork = ""; 
	
	JTextField userInput;

	public FrameBibCite() {
		JFrame jf = new JFrame();
		JPanel panel = new JPanel();
		JLabel jl = new JLabel("\nPlease input the title of the paper you want to cite: \n");
		
		JButton jButton = new JButton("Submit");
		userInput = new JTextField(" ", 30);
		
		JLabel j2 = new JLabel("\nThe BibTeX citation: \n");
		
		
		JTextArea bibCitation = new JTextArea(citeWork); 
		
		
		jButton.addActionListener( (e) -> {
		    try {
				submitAction(panel, j2, bibCitation);
							
			} catch (InterruptedException | UnsupportedFlavorException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(panel);
		
		//use BoxLayout
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(jl);
		panel.add(userInput);
		panel.add(jButton);
		
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
