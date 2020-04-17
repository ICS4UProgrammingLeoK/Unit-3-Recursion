/*
 * Created by: Leo Kay
 * Created on: April 17, 2020
 * Created for: ICS4U
 * Day #28 - Tower of Hanoi
 * This program displays the moves of the tower of hanoi algorithm
 */
import java.util.*;
public class main {
	
	static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        if (n == 1) 
        { 
        	//print the movement of the disk
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        //call this function again until n==1
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 
	
	//scanner
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//variables
		int n;
		
		//ask the user for a number
		System.out.println("Please enter the number of disks: ");
		
		//get the number
		n = Integer.parseInt(scanner.nextLine());
		
		//call the tower of Hanoi function (A, B, and C are the rods
		towerOfHanoi(n, 'A', 'C', 'B');
		
	}
	
}