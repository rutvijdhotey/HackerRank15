package binaryTrees;

public class PreOrderSerialization {
	public boolean isValidSerialization(String preorder) {
		//Starting Difference of the Root only
		int diff = 1;
		String[] array = preorder.split(",");

		for (String node : array) {
			//Remove the element as a root : Every Number +2 -1 and every empty number(Leaf) -1.....Ultimately 
			//We will have the diff = 0 if everything is alright
			
			diff--;
			if (diff < 0) {
				return false;
			}
			if (!node.equals("#")) {
				diff += 2;
			}
		}

		return diff == 0;
	}
}
