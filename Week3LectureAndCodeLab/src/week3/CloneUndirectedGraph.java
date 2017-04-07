package week3;

import java.util.Map;
import java.util.HashMap;

public class CloneUndirectedGraph {
	public GraphNode clone(GraphNode node){
		if(node==null)return node;		// base case
		Map<GraphNode,GraphNode> map=new HashMap<>();
		return DFShelper(node,map);
	}
	
	private GraphNode DFShelper(GraphNode node,Map<GraphNode,GraphNode> map){
		map.put(node,new GraphNode(node.label));	// copy node, use map to store the copied nodes
		for(GraphNode nei:node.neighbors){	// search node's neighbors
			GraphNode newNei=map.get(nei);	// check if traversed before?
			if(newNei==null)newNei=DFShelper(newNei,map);	// if no! DFS this neighbor node
			map.get(node).neighbors.add(newNei);	// add the new neighbor node to copied node's neighbor list 
		}
		return map.get(node); // return copied node
	}
}
