package hackerrank15;

public class LongestPalindormicSequence {

	public static String longestPalindromicSubstring(String S) {
		int maxLen = 0;
		int start = 0;
		if (S.length() == 0) {
			return S;
		}

		boolean[][] boolTable = new boolean[S.length()][S.length()];
		// For len 1

		for (int i = 0; i < S.length(); i++) {
			boolTable[i][i] = true;
			maxLen = 1;
		}

		// For length 2
		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) == S.charAt(i + 1)) {
				maxLen = 2;
				start = i;
				boolTable[i][i + 1] = true;
			}
		}

		int n = S.length();
		// For len 3 and above
		for (int k = 3; k <= S.length(); k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (boolTable[i + 1][j - 1] && S.charAt(i) == S.charAt(j)) {
					boolTable[i][j] = true;
					if (k > maxLen) {
						maxLen = k;
						start = i;
					}
				}
			}
		}

		return S.substring(start, start + maxLen);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromicSubstring("geeksskeeg"));
	}
}
