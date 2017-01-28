package graphs;

import java.util.LinkedList;
import java.util.Queue;

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

public class BFSSearchForNode {

	
	public static boolean BFS(Node source, Node target){
		if(source ==  target) return true;
		
		if(source==null || target == null) return false;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(source);
		
		
		while(!q.isEmpty()){
			Node currentNode = q.poll();
			currentNode.state = State.Visiting;
			for(Node adjacentNode : currentNode.adj){
				if(adjacentNode == target){
					return true;
				} else {
					if(adjacentNode.state == State.UnVisited){
						q.add(adjacentNode);
					}
				}
			}
			currentNode.state = State.Visited;
		}
		
		return false;
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

		System.out.println(BFS(source, s10));

	}


}
