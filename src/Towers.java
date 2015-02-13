import java.util.*;
public class Towers {
	
	public static int[][] towers;
	public static int poles = 3;
	public static int discs;
	public static int moves = 0;
	
	public static void main(String[] args) {
		System.out.print("Enter number of discs: ");
		Scanner scanner = new Scanner(System.in);
		
		discs = scanner.nextInt();		
		towers = new int[discs][poles];

		// place the discs on the left-most pole (column)
		for (int disc = 0; disc < discs; disc++) {
			towers[disc][0] = (disc * 2) + 1;
		}
		
		printTowers();			
		solveTowers(discs, 0, 2);
		scanner.close();
		System.out.println("Number of moves: " + moves);
	}
	
	/**
	 * Complete this recursive method to solve the Towers of Hanoi
	 * @param numDiscs - number of discs in the problem
	 * @param startPole - pole the discs start on (zero based)
	 * @param endPole - pole the discs end on (zero based)
	 */
	public static void solveTowers(int numDiscs, int startPole, int endPole) {
		if (numDiscs == 0) {
			// BASE case - do nothing;
		} else {
			int intermediatePole = poles - startPole - endPole;
			
			solveTowers(numDiscs - 1, startPole, intermediatePole);
			moveDisc(startPole, endPole);
			solveTowers(numDiscs - 1, intermediatePole,  endPole);			
		}		
	}
	
	/**
	 * Moves a disc from one pole the another pole
	 * @param fromPole - pole to move the disc from
	 * @param toPole - pole to move the disc to
	 */
	public static void moveDisc(int fromPole, int toPole) {
		moves++;
		int disc = 0;
		while (disc < discs && towers[disc][fromPole] == 0) {
			disc++;
		}
		
		int temp = towers[disc][fromPole];
		towers[disc][fromPole] = 0;
		
		int newDisc = 0;
		while (newDisc < discs && towers[newDisc][toPole] == 0) {
			newDisc++;			
		}
		towers[--newDisc][toPole] = temp;
		printTowers();
	}

	/**
	 * Prints the towers
	 */
	public static void printTowers() {
		System.out.println();
		for (int disc = 0; disc < discs; disc++) {
			for (int pole = 0; pole < poles; pole++) {
				System.out.print(pad(towers[disc][pole]));
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Pads the width of the disc for printing
	 * @param disc - the disc number (1 to 4 if there are 4 discs)
	 * @return - padded string for pretty printing
	 */
	public static String pad(int disc) {
		// pad string with spaces
		int columnWidth = (discs * 2) + 2;
		
		
		String output = "";
		if (disc == 0) {
			output = "|";
		} else for (int i = 0; i < disc; i++) {
			output += "*";
		}

		// if length is odd pad end to even length
		if (output.length() % 2 == 1) {
			output += " ";
		}
		// justify pad to center in cell
		while (output.length() < columnWidth) {
			output = " " + output + " ";
		}
		return output;
	}
}