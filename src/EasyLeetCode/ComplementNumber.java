package EasyLeetCode;

public class ComplementNumber {
	public int findComplement(int num) {
        int complement = ~num & ((Integer.highestOneBit(num) << 1) - 1);
        return complement;
    }
}
