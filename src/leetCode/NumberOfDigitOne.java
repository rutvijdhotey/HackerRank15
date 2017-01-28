package leetCode;

public class NumberOfDigitOne {

	public static int numberOfOnes(int n) {
		int ans = 0;
		int x = 1;
		int q = n;

		do {
			int digit = q % 10;
			q /= 10;
			ans += q * x;
			if (digit == 1)
				ans += n % x + 1;
			if (digit > 1)
				ans += x;
			x *= 10;
		} while (q > 0);

		return ans;

	}

}