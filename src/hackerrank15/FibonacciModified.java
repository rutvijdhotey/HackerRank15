package hackerrank15;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class FibonacciModified {

	public static BigInteger fibMod(int n, int n0, int n1) {
		HashMap<Integer, BigInteger> memo = new HashMap<Integer, BigInteger>();
		memo.put(0, BigInteger.valueOf(n0));
		memo.put(1,BigInteger.valueOf(n1));
		BigInteger ans = fibMod(n, memo);
		return ans;
	}

	private static BigInteger fibMod(int n, HashMap<Integer, BigInteger> memo) {

		int i = 2;
		while (i <= n) {
			BigInteger num1 = memo.get(i - 2);
			BigInteger num2 = memo.get(i - 1);
			BigInteger num = num1.add(num2.pow(2));
			memo.put(i, num);
			i++;
		}

		return memo.get(n-1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = 0, n0 = 0, n = 0;
		n0 = scan.nextInt();
		n1 = scan.nextInt();
		n = scan.nextInt();

		scan.close();
		System.out.println(fibMod(n, n0, n1));
	}
}
