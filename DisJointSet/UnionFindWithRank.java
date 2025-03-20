package DisJointSet;

import java.util.*;

class UnionFindWithRank {
    static class Node {
        int parent;
        int rank;
        Node() {
            this.parent = -1;
            this.rank = 0;
        }
    }

    static Node[] dsuf;
    
    static int find(int v) {
        if (dsuf[v].parent == -1)
            return v;
        return dsuf[v].parent = find(dsuf[v].parent);
    }

    static void unionOp(int fromP, int toP) {
        if (dsuf[fromP].rank > dsuf[toP].rank) {
            dsuf[toP].parent = fromP;
        } else if (dsuf[fromP].rank < dsuf[toP].rank) {
            dsuf[fromP].parent = toP;
        } else {
            dsuf[fromP].parent = toP;
            dsuf[toP].rank += 1;
        }
    }

    static boolean isCyclic(List<int[]> edgeList) {
        for (int[] edge : edgeList) {
            int fromP = find(edge[0]);
            int toP = find(edge[1]);

            if (fromP == toP)
                return true;

            unionOp(fromP, toP);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        
        dsuf = new Node[V];
        for (int i = 0; i < V; i++) {
            dsuf[i] = new Node();
        }
        
        List<int[]> edgeList = new ArrayList<>();
        System.out.println("Enter the edges (from to):");
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edgeList.add(new int[]{from, to});
        }
        sc.close();
        
        if (isCyclic(edgeList))
            System.out.println("TRUE");
        else
            System.out.println("FALSE");
    }
} 
