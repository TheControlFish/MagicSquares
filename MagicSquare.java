import java.util.*;
public class MagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter Size of Square (N x N):\nN = ");
		int size = kb.nextInt();
		System.out.println();
		int [][]square = new int [size][size];
		for (int row = 0; row < square.length; row++){
			System.out.println("Enter Row " + (row + 1) + ": ");
			for (int col = 0; col < square[row].length; col++){
				square[row][col] = kb.nextInt();
			}
		}
		System.out.println("\nSquare:\n");
		for (int row = 0; row < square.length; row++){
			for (int col = 0; col < square[row].length - 1; col++){
				System.out.print(square[row][col] + ", ");
			}
			System.out.print(square[row][square.length - 1]);
			System.out.println();
		}
		System.out.println();
		if (!valid(square)){
			System.out.println("Not a Valid Square, must only contain the digits 1-" + (square.length * square.length) + ". Each must occur once.");
		}
		else {
			if (magic(square)){
				System.out.println("Yay! Magic Square!");
			}
			else {
				System.out.println("Boo! Not a Magic Square");
			}
		}
	}
	public static boolean valid(int [][]a){
		boolean valid = false;
		for (int n = 1; n <= a.length * a.length; n++){
			for (int row = 0; row < a.length; row++){
				for (int col = 0; col <a[row].length; col++){
					if (a[row][col] == n){
						valid = true;
					}
				}
			}
			if (!valid){
				return false;
			}
			valid = false;
		}
		return true;
	}
	public static boolean magic(int [][]a){
		boolean magic = true;
		int sum = 0;
		int sum1 = 0;
		for (int col = 0; col < a[0].length; col++){
			sum += a[0][col];
		}
		//Testing rows
		for (int row = 1; row < a.length; row++){
			for (int col = 0; col < a[row].length; col++){
				sum1 += a[row][col];
			}
			if (!(sum1==sum)){
				return false;
			}
			sum1 = 0;
		}
		//testing columns
		for (int col = 0; col < a[0].length; col++){
			for (int row = 0; row < a.length; row++){
				sum1 += a[row][col];
			}
			if (!(sum1==sum)){
				return false;
			}
			sum1 = 0;
		}
		//testing diagonal 1
		for (int n = 0; n < a.length; n++){
			sum1 += a[n][n];
		}
		if (!(sum1==sum)){
			return false;
		}
		sum1 = 0;
		//testing diagonal 2
		for (int n = 0; n < a.length; n++){
			sum1 += a[a.length - n - 1][a.length - n - 1];
		}
		if (!(sum1==sum)){
			return false;
		}
		sum1 = 0;
		return magic;
	}

}
