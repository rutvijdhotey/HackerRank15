package graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

	State state;
	List<Node> adj;
	int val;

	// Write Constructor Here
	public Node(int n) {
		this.val = n;
		this.adj = new ArrayList<Node>();
		this.state = State.UnVisited;
	}

}
