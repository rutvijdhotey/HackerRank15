package google;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public static List<String> summaryRanges(int[] nums) {
		List<String> ansList = new ArrayList<String>();
		if (nums.length == 0 || nums == null) {
			return ansList;
		}

		if (nums.length == 1) {
			ansList.add(Integer.toString(nums[0]));
			return ansList;
		}

		int rangeStart = nums[0];
		int current = rangeStart;
		String rangeS = Integer.toString(rangeStart);
		StringBuilder string = new StringBuilder(rangeS);
		int latestEnd = rangeStart;
		for (int i = 1; i < nums.length; i++) {
			int diff = nums[i] - current;
			if (nums[i] - current != 1) {
				if (latestEnd != rangeStart) {
					string.append("->").append(latestEnd);
				}
				current = nums[i];
				rangeStart = nums[i];
				latestEnd = rangeStart;

				ansList.add(string.toString());
				string = new StringBuilder(Integer.toString(rangeStart));
			} else {
				latestEnd = nums[i];
				current = nums[i];
			}
		}
		
		if (latestEnd != rangeStart) {
			string.append("->").append(latestEnd);
		}
		
		ansList.add(string.toString());
		return ansList;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2147483648,-2147483647,2147483647};
		List<String> ans =summaryRanges(arr);
	}

}
