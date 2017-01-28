package graphs;

import java.util.ArrayList;
import java.util.List;

/*public class Node {

	State state;
	List<Node> adj;
	int val;

	// Write Constructor Here
	public Node(int n) {
		this.val = n;
		this.adj = new ArrayList<Node>();
		this.state = State.UnVisited;
	}

}*/

public class DFSSearchForNode {

	public static boolean DFS(Node source, Node target) {
		boolean ans = false;
		if (source == target)
			return true;

		if (source == null || target == null)
			return false;

		source.state = State.Visited;
		for (Node adjNode : source.adj) {
			if (adjNode == target) {
				return true;
			} else {
				if (adjNode.state != State.Visited) {
					 ans = DFS(adjNode, target);
				}
				if(ans) break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Node source = new Node(1);
		Node s1 = new Node(1);
		Node s2 = new Node(2);
		Node s3 = new Node(3);
		Node s4 = new Node(4);
		Node s5 = new Node(6);
		Node s6 = new Node(19);
		Node s7 = new Node(21);
		Node s8 = new Node(4);
		Node s9 = new Node(6);
		Node s10 = new Node(8);

		source.adj.add(s1);
		source.adj.add(s3);
		source.adj.add(s4);
		s1.adj.add(s2);
		s1.adj.add(s5);
		s1.adj.add(s6);
		s6.adj.add(s7);
		s6.adj.add(s8);
		s7.adj.add(s9);
		//s9.adj.add(s10);

		System.out.println(DFS(source, s10));

	}

}
