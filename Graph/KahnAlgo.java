package Graph;

import java.util.*;

// public class KahnAlgo {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] indegree = new int[numCourses];
        
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }
        
//         for (int[] pre : prerequisites) {
//             adj.get(pre[1]).add(pre[0]);
//             indegree[pre[0]]++;
//         }
        
//         Queue<Integer> queue = new LinkedList<>();
//         for (int i = 0; i < numCourses; i++) {
//             if (indegree[i] == 0) {
//                 queue.offer(i);
//             }
//         }
        
//         int count = 0;
//         int[] order = new int[numCourses];
//         int index = 0;
        
//         while (!queue.isEmpty()) {
//             int curr = queue.poll();
//             order[index++] = curr;
//             count++;
            
//             for (int neighbor : adj.get(curr)) {
//                 indegree[neighbor]--;
//                 if (indegree[neighbor] == 0) {
//                     queue.offer(neighbor);
//                 }
//             }
//         }
        
//         return count == numCourses ? order : new int[0];
//     }
    
//     public static void main(String[] args) {
//         KahnAlgo solution = new KahnAlgo();
//         int numCourses = 4;
//         int[][] prerequisites ={{1,0},{2,0},{3,1},{3,2}};
//         int[] order = solution.findOrder(numCourses, prerequisites);
//         System.out.println("Course order: " + Arrays.toString(order));
//     }
// }

public class KahnAlgo {
    private int[] findOrder(int numCourses, int [][] prerequisites){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for(int[] preq: prerequisites){
            adj.get(preq[1]).add(preq[0]);
            inDegree[preq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];
        int index = 0;
        int count = 0;
    
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0)queue.offer(i);
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            order[index++]=cur;
            count++;

            for(int neighbor: adj.get(cur)){
                inDegree[neighbor]--;
                if(inDegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }

        }

        return count == numCourses ? order : new int[0];
    }

   

    public static void main(String[] args){
        KahnAlgo solution = new KahnAlgo();
        int numCourses = 4;
        int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int [] order = solution.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}