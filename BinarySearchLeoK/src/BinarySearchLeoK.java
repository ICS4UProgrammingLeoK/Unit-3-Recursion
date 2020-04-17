/*
 * Created by Leo Kay
 * Created on April 16, 2020
 * Created for: ICS4U
 * Day #27 - Binary Search
 * This program generates a list, sorts it, and finds the index of a number by binary search
 */

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.Random;
import javax.swing.JOptionPane;

public class BinarySearchLeoK {

	protected Shell shlBinarySearchBy;
	private Text txt_num;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BinarySearchLeoK window = new BinarySearchLeoK();
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
		shlBinarySearchBy.open();
		shlBinarySearchBy.layout();
		while (!shlBinarySearchBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public int BinarySearch(int[] numbers, int userNum) {
		//variables
		int left = 0, right = numbers.length - 1, middle;
		
		//do while the left side is less than or equal to the right side
		while (left <= right) {
			//get the middle number
			middle = (left + right) / 2;
			
			//check to see if the middle number is the user number
			if (numbers[middle] < userNum) {
				//set the new left
				left = middle + 1;
			} else if (numbers[middle] > userNum) {
				right = middle - 1;
			} else {
				//return the middle
				return middle;
			}
		}
		//if the userNum is not in the array, return -1
		return -1;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBinarySearchBy = new Shell();
		shlBinarySearchBy.setSize(450, 473);
		shlBinarySearchBy.setText("Binary Search by Leo Kay");
		
		Label lblPressTheButton = new Label(shlBinarySearchBy, SWT.NONE);
		lblPressTheButton.setBounds(10, 10, 414, 15);
		lblPressTheButton.setText("Press the button to generate and sort an array that is 250 integers long.");
		
		Label lblUnsorted = new Label(shlBinarySearchBy, SWT.NONE);
		lblUnsorted.setBounds(10, 39, 55, 15);
		lblUnsorted.setText("Unsorted");
		
		Label lblSorted = new Label(shlBinarySearchBy, SWT.NONE);
		lblSorted.setBounds(278, 39, 55, 15);
		lblSorted.setText("Sorted");
		
		List lst_unsorted = new List(shlBinarySearchBy, SWT.BORDER);
		lst_unsorted.setBounds(10, 60, 122, 285);
		
		List lst_sorted = new List(shlBinarySearchBy, SWT.BORDER);
		lst_sorted.setBounds(278, 60, 122, 287);
		
		Label lbl_answer = new Label(shlBinarySearchBy, SWT.NONE);
		
		//create an array that is 250 ints long
		int[] numbers = new int[250];
		
		Button btn_sort = new Button(shlBinarySearchBy, SWT.NONE);
		btn_sort.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//max and min for random numbers
				int min = 0;
				int max = 1000;
				
				//add 250 random nums to the array
				for (int i = 0; i < numbers.length; i++) {
					//generate the random number
					Random random = new Random();
					int randomNum = random.nextInt((max - min) + 1) + min;
					
					//place the number into the array at i
					numbers[i] = randomNum;
				}
				
				//display the array
				for (int x = 0; x < numbers.length; x++) {
					lst_unsorted.add(Integer.toString(numbers[x]), x);
				}
				
				//temp variable
				int temp;
				
				//sort the array by using bubble sort
				for (int i = 0; i < numbers.length - 1; i++) {
					for (int j = 0; j < numbers.length - 1; j++) {
						//check to see if the first bubble is greater than the second
						if (numbers [j] > numbers[j + 1]) {
							//store the number as a temp
							temp = numbers[j];
							
							//swap the numbers
							numbers[j] = numbers[j + 1];
							numbers[j + 1] = temp;
						}
					}
				}
				
				//display the array
				for (int y = 0; y < numbers.length; y++) {
					lst_sorted.add(Integer.toString(numbers[y]), y);
				}
			}
		});
		btn_sort.setBounds(167, 180, 75, 25);
		btn_sort.setText("Sort");
		
		Label lblPleaseEnterA = new Label(shlBinarySearchBy, SWT.NONE);
		lblPleaseEnterA.setBounds(10, 351, 122, 15);
		lblPleaseEnterA.setText("Please enter a number:");
		
		txt_num = new Text(shlBinarySearchBy, SWT.BORDER);
		txt_num.setBounds(166, 351, 76, 21);
		
		Button btn_getIndex = new Button(shlBinarySearchBy, SWT.NONE);
		btn_getIndex.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//try to get the number
				try {
					int userNum = Integer.parseInt(txt_num.getText());
					
					//call binary search
					int result = BinarySearch(numbers, userNum);
					
					//display the answer
					if (result == -1) {
						lbl_answer.setText("The number you entered is not in the array");
					} else {
						lbl_answer.setText("The number you entered is at index " + result);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_getIndex.setBounds(302, 353, 75, 25);
		btn_getIndex.setText("Get Index");
		
		lbl_answer.setBounds(10, 409, 414, 15);

	}
}
