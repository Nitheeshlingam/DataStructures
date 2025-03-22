package Graph;

import java.util.*;

public class UnionFind{
    static int[] dsuf;
    private static int find(int v){
        if(dsuf[v]==-1){
            return v;
        }
        return dsuf[v] = find(dsuf[v]);
    }

    private static void unionOp(int fromP, int toP){
         fromP = find(fromP);
         toP = find(toP);
         dsuf[fromP]=toP;
    }

    private static boolean isCyclic(List<int[]> edges){
        for(int[] edge: edges){
            int fromP = find(edge[0]);
            int toP = find(edge[1]);

            if(fromP == toP){
                return true;
            }

            unionOp(fromP,toP);
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Edges: ");
        int E = sc.nextInt();
        System.out.print("Enter no of vertices: ");
        int V = sc.nextInt();
        System.out.println("Enter the edges {from,to}: ");
        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<E; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new int[]{from,to});
        }
        sc.close();
        dsuf = new int[V];
         Arrays.fill(dsuf, -1);

        if(isCyclic(edges)){
            System.out.println("TRUE");
        }
        else{
            System.out.print("FALSE");
        }
    }
}



