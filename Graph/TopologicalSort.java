package Graph;

import java.util.*;

public class TopologicalSort {
    private boolean detectCycleUtil(List<List<Integer>> adj, int numCourses, int[] visited, int v){
        if(visited[v]==1)return true;
        if(visited[v]==2)return false;
        visited[v]=1;
        for(int neighbor : adj.get(v)){
            if(detectCycleUtil(adj, numCourses, visited, neighbor)){
                return true;
            }
        }
        visited[v]=2;
        return false;
    }
    private boolean detectCycle(List<List<Integer>> adj, int numCourses){
        int[]visited = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(visited[i]==0 && detectCycleUtil(adj, numCourses, visited, i)){
                return true;
            }
        }
        return false;
    }
    private void dfs(List<List<Integer>> adj, boolean[] visited, int v, Stack<Integer> stack){
        visited[v] = true;
        for(int neighbor: adj.get(v)){
            if(!visited[neighbor]){
                dfs(adj, visited, neighbor, stack);
            }
        }
        stack.push(v);
    }
    private int[] find(int[][] prerequisites, int numCourses){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] preq: prerequisites){
            adj.get(preq[1]).add(preq[0]);
        }
        
        if(detectCycle(adj, numCourses)){
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                dfs(adj, visited, i, stack);
            }
        }

        int [] order = new int[numCourses];
        int k=0;
        while(!stack.isEmpty()){
            order[k++]=stack.pop();
        }
        return order;
    }
    public static void main(String[] args){
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        TopologicalSort Solution = new TopologicalSort();
        int[] order = Solution.find(prerequisites, numCourses);
        System.out.println(Arrays.toString(order));
    }
}