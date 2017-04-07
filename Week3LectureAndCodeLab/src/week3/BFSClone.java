package week3;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class BFSClone {
	public GraphNode cloneBFS(GraphNode node){
		if(node==null)return node;		// corner case
		Map<GraphNode,GraphNode> map=new HashMap<>(); // store copied nodes
		Deque<GraphNode> queue=new ArrayDeque<GraphNode>();	// build queue for BFS
		queue.offer(node);	// add the initial node into queue
		map.put(node, new GraphNode(node.label));	// copy the initial node
		while(!queue.isEmpty()){
			GraphNode curr=queue.poll();	// dequeue from queue
			GraphNode copy=map.get(curr);	// get copied current node
			for(GraphNode nei:curr.neighbors){	// traverse neighbor list
				GraphNode newNei=map.get(nei);	// check if each neighbor is copied(visited)
				if(newNei==null){		// no!
					queue.offer(nei);	// add this neighbor node into queue
					map.put(nei, new GraphNode(nei.label));	// copy this neighbor
				}
				copy.neighbors.add(map.get(nei));	// add copied neighbor node into node's neighbor list
			}
		}
		return map.get(node);
	}
}
