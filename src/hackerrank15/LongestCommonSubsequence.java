package hackerrank15;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String s1, String s2){
		if(s1.length() == 0 || s2.length() == 0){
			return 0;
		}
		
		return LCS( s1, s2, s1.length(), s2.length());
	}

	private static int LCS(String s1, String s2, int n, int m) {
		if(m == 0 || n == 0){
			return 0;
		}
		
		if(s1.charAt(n - 1) == s2.charAt(m-1)){
			return 1 + LCS(s1,s2,n-1,m-1);
		} else {
			return Math.max(LCS(s1,s2,n-1,m),LCS(s1,s2,n,m-1));
		}
	}

	
	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ABBCS","BCAAS"));
	}
}
