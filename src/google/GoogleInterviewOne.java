package google;

public class GoogleInterviewOne {
	
	
	public int solution(int[] A) {
		int ans = -1;
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		int sumTillNow = 0;
		for (int i = 0; i < A.length; i++) {
			left[i] = sumTillNow;
			sumTillNow += A[i];
		}

		sumTillNow = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			right[i] = sumTillNow;
			sumTillNow = A[i];
		}

		for (int i = 0; i < A.length; i++) {
			if (left[i] == right[i]) {
				ans = i;
				break;
			}
		}

		return ans;

	}
	
	public static void main(String[] args) {
		
	}

}
