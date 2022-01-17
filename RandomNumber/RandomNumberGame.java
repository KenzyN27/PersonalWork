import java.util.Scanner;
import java.lang.Math;

public class RandomNumberGame {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int count;
		boolean found;
		int randomNum;
		
		System.out.println("\n---------- Welcome to Guess the Number! ----------");
		System.out.print("\nWould you like to play? (Y/N) ");
		String answer = scan.next().toUpperCase();
		
		while ( !answer.equals("Y") && !answer.equals("N") ) {
			System.out.print("ERROR! Please enter a valid response (Y/N) ");
			answer = scan.next().toUpperCase();
		}
		
		while (answer.equals("Y")) {
			
			count = 10;
			found = false;
			System.out.println("\nI have picked a number between 1 and 100.");
			System.out.println("You have " + count + " guesses left.");
			randomNum = (int)((Math.random() * (100 - 1)) + 1);
			System.out.print("Please enter a number between 1 and 100: ");
			int guess = scan.nextInt();
			
			while (count >= 1 && !found) {
				
				while (guess < 1) {
					System.out.println("\nERROR. Invalid number.");
					System.out.print("Please enter a valid number: ");
					guess = scan.nextInt();
				}
				
				if (guess != randomNum) {
					count--;
					
					if (guess > randomNum) {
						System.out.println("Incorrect. The number is lower.");
					}
					
					else {
						System.out.println("Incorrect. The number is higher.");
					}
					
					if (count != 0) {
						
						switch (count) {
							case 1: System.out.println("\nYou have " + count + " guess left."); break;
							default: System.out.println("\nYou have " + count + " guesses left.");
						}
						System.out.print("Please enter another number: ");
						guess = scan.nextInt();
					}
				}
				
				else {
					System.out.println("\nCongratulations! The number was " + randomNum + "!");
					found = true;
				}
				
			}
			
			if (!found) {
				System.out.println("\nYou ran out of guesses.");
				System.out.println("The number was " + randomNum + ".");
			}
			
			System.out.print("\nWould you like to play again? (Y/N) ");
			answer = scan.next().toUpperCase();
			
		}
		
		System.out.println("\nThanks for playing Guess the Number!");
		
	}
	
}		