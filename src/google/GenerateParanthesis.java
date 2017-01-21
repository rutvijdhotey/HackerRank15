package google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GenerateParanthesis {


	public static List<String> generateParenthesis(int n) {
		String oneBracket = "()";
		List<String> answers = new ArrayList<>();
		HashSet<String> answerSet = new HashSet<>();

		if (n < 1) {
			return answers;
		} else {
			answerSet.add(oneBracket);
			answerSet =  new HashSet<>(insertInto(answerSet, oneBracket, n));
		}

		return new ArrayList<String>(answerSet);
	}

	private static HashSet<String> insertInto(HashSet<String> answerSet, String oneBracket, int n) {
		List<String> currentList = new ArrayList<>(answerSet);
		List<String> newList = new ArrayList<>();
		int currentStep = 1;
		while (currentStep < n ) {
			for (String s : currentList) {

				// Insert in between
				for (int i = 0; i < s.length(); i++) {
					newList = new ArrayList<>();
					if (s.charAt(i) == '(') {
						
						String newString = insertBracket(s, i+1, oneBracket);
						if(!answerSet.contains(newString)){
							newList.add(newString);
						}
					}
				}

				// Insert One at the start
				String newString = insertBracket(s, 0, oneBracket);
				newList.add(newString);

				// Insert one at the end
				newString = insertBracket(s, s.length(), oneBracket);
				newList.add(newString);
			}
			currentStep++;
			currentList = new ArrayList<>(newList);
			
		}
		
		return new HashSet<>(currentList);

	}

	private static String insertBracket(String s, int i, String oneBracket) {
		StringBuilder neww = new StringBuilder(s);
		neww.insert(i, oneBracket);
		return neww.toString();
	}

	public static void main(String[] args) {
		List<String> list=  generateParenthesis(3);
	}
}
