/*
 * Created by Leo Kay
 * Created on April 16, 2020
 * Created for: ICS4U
 * Day #26 - Factorial!
 * This program performs factorials
 */

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import javax.swing.JOptionPane;

public class FactorialLeoK {

	protected Shell shlFactorialByLeo;
	private Text txt_num;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FactorialLeoK window = new FactorialLeoK();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFactorialByLeo.open();
		shlFactorialByLeo.layout();
		while (!shlFactorialByLeo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFactorialByLeo = new Shell();
		shlFactorialByLeo.setSize(268, 158);
		shlFactorialByLeo.setText("Factorial! by Leo Kay");
		
		Label lblPleaseEnterA = new Label(shlFactorialByLeo, SWT.NONE);
		lblPleaseEnterA.setBounds(10, 10, 135, 15);
		lblPleaseEnterA.setText("Please enter a number:");
		
		txt_num = new Text(shlFactorialByLeo, SWT.BORDER);
		txt_num.setBounds(151, 4, 76, 21);
		
		Label lbl_answer = new Label(shlFactorialByLeo, SWT.NONE);
		
		Button btn_go = new Button(shlFactorialByLeo, SWT.NONE);
		btn_go.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//variables
					int num;
					long fact = 1;
					
					//get the number
					num = Integer.parseInt(txt_num.getText());
					
					//get the answer
			        for(int i = 1; i <= num; i++)
			        {
			            fact = fact * i;
			        }
			        
			        //display the answer
			        lbl_answer.setText(num + "! is: " + fact);
					
				}catch(Exception e1) {
					//display an error message
					JOptionPane.showMessageDialog(null, "Please enter a string.", "Error", JOptionPane.ERROR_MESSAGE);;
				}
			}
		});
		btn_go.setBounds(82, 39, 75, 25);
		btn_go.setText("Go!");
		
		lbl_answer.setBounds(10, 85, 232, 15);

	}
}
