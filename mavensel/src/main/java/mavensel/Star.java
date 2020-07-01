package mavensel;

import java.util.Scanner;

public class Star {

	public static void main(String args[]) {
		
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int n =scan.nextInt(); 
		for (int i= 0; i<= n-1 ; i++){
		    for (int j=0; j<=i; j++) { 
		    	System.out.print("*"); 
		    	} 
		    System.out.println(); 
		}
		for (int i=n-1; i>=0; i--) {
            for(int j=0; j <=i-1;j++){
                System.out.print("*");
            }
		    System.out.println(); 
	   	}
	}
}
