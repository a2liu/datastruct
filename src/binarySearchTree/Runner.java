package binarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	public static void main(String[] h) throws IOException {
		BTree<Float> tree = new BTree<Float>();
		
		BufferedReader consoleLine = new BufferedReader(new InputStreamReader(System.in));
		boolean on = true;
		String input;
		while (on) {
			input = consoleLine.readLine();
			if (input.equals("off")) {
				on = false;
			} else if (input.split(" ")[0].equals("add") && isNumber(input.split(" ")[1])) {
				System.out.println(tree.add(Float.parseFloat(input.split(" ")[1]))
						? "Successfully added " + input.split(" ")[1] 
								: input.split(" ")[1] + "is already in the tree.");
				
			} else if (input.split(" ")[0].equals("rm") && isNumber(input.split(" ")[1])) {
				System.out.println(tree.remove(Float.parseFloat(input.split(" ")[1]))
						? "Successfully removed " + input.split(" ")[1] 
								: input.split(" ")[1] + "is not in the tree.");
			} else {
				switch (input.charAt(1)) {
				case 'o':
					System.out.println(tree.postOrder().toString());
					break;
				case 'n':
					System.out.println(tree.inOrder().toString());
					break;
				case 'r':
					System.out.println(tree.preOrder().toString());
					break;
				case 'm':
					System.out.println(tree.dump());
					System.out.println("Tree is now empty.");
				default:
					System.out.println("That's not a recognized command!");	
				}
			}
		}
	}
	
	/**
	 * checks if a string is an integer
	 * @param in string to test
	 * @return true if the string can be parsed to an integer
	 */
	public static boolean isNumber(String in) {
		try{
			Float.parseFloat(in);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}