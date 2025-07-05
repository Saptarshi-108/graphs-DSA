import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.HashMap;

public class bfs_graph {
    public ArrayList<Integer> bfsOfGraph(int V,ArrayList<ArrayList<Integer>> arr){
        ArrayList < Integer > bfs = new ArrayList <> ();
        boolean vis[] = new boolean[V];
        Queue <Integer> q = new LinkedList<>();

        q.add(0);
        vis[0]=true;

        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: arr.get(node)){
                if (vis[it]==false){
                    vis[it] = true;
                    q.add(it);
                }
            } 
        }

        return bfs;

    }
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int V = sc.nextInt();
    int E = sc.nextInt(); 

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        adj.get(u).add(v);
        adj.get(v).add(u); 
    }

    bfs_graph g = new bfs_graph();
    ArrayList<Integer> res = g.bfsOfGraph(V, adj);

    for (int val : res) {
        System.out.print(val + " ");
    }
}

}
