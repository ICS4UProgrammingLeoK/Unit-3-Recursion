/*
 * Created by Leo Kay
 * Created on April 16, 2020
 * Created for: ICS4U
 * Day #25 - Using Recursion
 * This program reverses a string
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

public class UsingRecursionLeoK {

	protected Shell shlUsingRecursionBy;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UsingRecursionLeoK window = new UsingRecursionLeoK();
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
		shlUsingRecursionBy.open();
		shlUsingRecursionBy.layout();
		while (!shlUsingRecursionBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlUsingRecursionBy = new Shell();
		shlUsingRecursionBy.setSize(420, 142);
		shlUsingRecursionBy.setText("Using Recursion by Leo Kay");
		
		Label lblEnterAString = new Label(shlUsingRecursionBy, SWT.NONE);
		lblEnterAString.setBounds(10, 10, 185, 15);
		lblEnterAString.setText("Enter a string you want to reverse:");
		
		text = new Text(shlUsingRecursionBy, SWT.BORDER);
		text.setBounds(201, 10, 185, 21);
		
		Label lbl_answer = new Label(shlUsingRecursionBy, SWT.NONE);
		lbl_answer.setBounds(10, 67, 376, 15);
		
		Button btn_go = new Button(shlUsingRecursionBy, SWT.NONE);
		btn_go.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//get the string
					String str = text.getText();
					
					//create a reverse variable
					String reverse = "";
					
					//reverse the string
					for (int i = str.length() - 1; i >= 0; i--) {
						reverse = reverse + str.charAt(i);
					}
					
					//display the string
					lbl_answer.setText("The reversed string is " + reverse);
					
				} catch (Exception e1) {
					//display an error message
					JOptionPane.showMessageDialog(null, "Please enter a string.", "Error", JOptionPane.ERROR_MESSAGE);;
				}
			}
		});
		btn_go.setBounds(158, 37, 75, 25);
		btn_go.setText("Go!");

	}
}
