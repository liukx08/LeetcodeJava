import java.util.*;

/**
 * Created by liukx08 on 4/12/2017.
 */
public class EvaluateDivision_399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // This is actually a graph, the denominator and numerator are graph node, the division value is weight
        // DFS, find a path from query[0] to query[1]
        if(equations==null||equations.length==0||queries==null||queries.length==0)return new double[0];
        Map<String,List<String>> graph=new HashMap<>(); // store neighbor list
        Map<String,List<Double>> value=new HashMap<>(); // store weight to each neighbor
        int m=equations.length,n=queries.length;
        // initialize graph
        for(int i=0;i<m;i++){
            if(!graph.containsKey(equations[i][0])){
                graph.put(equations[i][0],new ArrayList<String>());
                value.put(equations[i][0],new ArrayList<Double>());
            }
            if(!graph.containsKey(equations[i][1])){
                graph.put(equations[i][1],new ArrayList<String>());
                value.put(equations[i][1],new ArrayList<Double>());
            }
            graph.get(equations[i][0]).add(equations[i][1]);
            graph.get(equations[i][1]).add(equations[i][0]);
            value.get(equations[i][0]).add(values[i]);
            value.get(equations[i][1]).add(1.0/values[i]);
        }
        double[] res=new double[n];
        // DFS in graph to find a path from query[0] to query[1] (not shortest!! => no BFS)
        for(int i=0;i<n;i++){
            res[i]=DFS(queries[i][0],queries[i][1],graph,value,new HashSet<String>(),1.0);
        }
        return res;
    }

    private double DFS(String start,String end,Map<String,List<String>> graph,Map<String,List<Double>> value,HashSet<String> visited,double res){
        if(visited.contains(start))return -1.0; // dead end
        if(!graph.containsKey(start)||!graph.containsKey(end))return -1.0;  // start or end node doesn't exist
        if(start.equals(end))return res;    // arrive at end
        visited.add(start); // visited mark
        // get neighbor list
        List<String> neighbor=graph.get(start);
        List<Double> distance=value.get(start);
        double curr=-1.0;
        for(int i=0;i<neighbor.size();i++){
            curr=DFS(neighbor.get(i),end,graph,value,visited,res*distance.get(i));
            if(curr!=-1.0)break;  // find a path, break
        }
        return curr;
    }
}
