import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class bfs_dfs {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> arr) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for (Integer it : arr.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

        vis[node] = true;
        ls.add(node);

        for (Integer neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, ls);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean vis[] = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        
        dfs(0, vis, adj, ls); 
        return ls;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices (V): ");
        int V = sc.nextInt();

        System.out.print("Enter the number of edges (E): ");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bfs_dfs g = new bfs_dfs();

        System.out.println("\nBFS Traversal:");
        ArrayList<Integer> bfsResult = g.bfsOfGraph(V, adj);
        for (int val : bfsResult) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("\nDFS Traversal:");
        ArrayList<Integer> dfsResult = g.dfsOfGraph(V, adj);
        for (int val : dfsResult) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        sc.close();
    }
}