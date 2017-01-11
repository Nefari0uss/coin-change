import java.util.Scanner;

/**
 * Program Change - Java
 *  @date 12 August 2014
 *  @author Nefari0uss
 * 
 * This program will request the amount of money to return and will provide the minimum amount of coinage possible.
 * Assumes user enters a positive int.
 * 
 **/

public class CoinChange {

	public CoinChange() {}

	public static void main(String[] args) {

		int n = getInput();
		calculateChange(n);
	} 

	private static int getInput() {

		int n;
		Scanner input = new Scanner(System.in);
		do {  
			System.out.println("How much change to return? \n Please enter total in cents: ");
			String num = input.nextLine();

			// Handle input greater than Java's MAX_INT.
			try {
				n = Integer.parseInt(num);
				if (n < 0) {
					System.out.println("Negative change isn't a thing...Enter a positive number: ");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("n is too lage. Setting n to be the largest possible int value.");
				n = Integer.MAX_VALUE;
				//System.out.println(n);
			}
		} while (n < 0);
		input.close();
		return n;
	}

	private static void calculateChange (double n)  {

		String denominations[] = { "dollars", "quarters", "dimes", "nickels", "pennies" };
		int values[] = { 100, 25, 10, 5, 1 };

		System.out.println("\nThe total change is...");
		for (int i = 0; i < values.length; i++) {
			int denomValue = values[i];
			values[i] = (int) (n / denomValue);
			n -= denomValue * values[i];
			System.out.println(values[i] + " " + denominations[i]);
		} 
	} 

} 
