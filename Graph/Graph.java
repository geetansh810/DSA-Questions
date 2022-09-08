package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {

    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest)
            return true;

        visited[src] = true;
        for (Edge source : graph[src]) {
            if (!visited[source.nbr]) {
                boolean path = hasPath(graph, source.nbr, dest, visited);
                if (path)
                    return true;
            }
        }
        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }

        visited[src] = true;
        for (Edge source : graph[src]) {
            if (!visited[source.nbr]) {
                printAllPaths(graph, source.nbr, dest, visited, path + " " + source.nbr);
            }
        }
        visited[src] = false;
    }

    static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    static String spath;
    static Integer spathwt = Integer.MAX_VALUE;
    static String lpath;
    static Integer lpathwt = Integer.MIN_VALUE;
    static String cpath;
    static Integer cpathwt = Integer.MAX_VALUE;
    static String fpath;
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge>[] graph, int src, int dest,
                                   boolean[] visited, int criteria, int k,
                                   String psf, int wsf) {

        if (src == dest) {
            if (wsf < spathwt) {
                spath = psf;
                spathwt = wsf;
            }

            if (lpathwt < wsf) {
                lpath = psf;
                lpathwt = wsf;
            }

            if (wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }
            if (wsf < criteria && wsf > fpathwt) {
                fpathwt = wsf;
                fpath = psf;
            }
            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }
            return;
        }

        visited[src] = true;
        for (Edge source : graph[src]) {
            if (!visited[source.nbr]) {
                multisolver(graph, source.nbr, dest, visited, criteria, k, psf + "" + source.nbr, wsf + source.wt);
            }
        }
        visited[src] = false;
    }

    static boolean isConnected;
    public static void connectedEdges(ArrayList<Edge>[] graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for (int v = 0; v < vertices; v++) {
            if (!visited[v]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getAllConnectedEdges(graph, v, visited, comp);
                comps.add(comp);
            }
        }
        System.out.println(comps);
        isConnected = comps.size() == 1;
    }

    public static void getAllConnectedEdges(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        comp.add(src);
        visited[src] = true;
        for (Edge source : graph[src]) {
            if (!visited[source.nbr]) {
                getAllConnectedEdges(graph, source.nbr, visited, comp);
            }
        }
    }

    public static void DFS(ArrayList< Edge>[]graph, int src, ArrayList< Integer> comp, boolean[]visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (!visited[e.nbr]) {
                DFS(graph, e.nbr, comp, visited);
            }
        }
    }

    public static void drawTreeForComponent(int[][] arr, int i, int j, boolean[][] visited){
        if(i<0 || j<0 || i >=arr.length || j >=arr[0].length || visited[i][j] || arr[i][j] == 1)
            return;

        visited[i][j]=true;

        drawTreeForComponent(arr, i-1, j, visited);
        drawTreeForComponent(arr, i, j+1, visited);
        drawTreeForComponent(arr, i, j-1, visited);
        drawTreeForComponent(arr, i+1, j, visited);
    }

    public static int countIslands(int[][] graph){
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        int count = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j <graph[i].length ; j++) {

                if(graph[i][j] == 0 && !visited[i][j]){
                    drawTreeForComponent(graph, i, j, visited);
                    count++;
                }

            }
        }
        return count;
    }


    public static void main(String[] args) {

        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        System.out.println(hasPath(graph, 0, 4, new boolean[vertices]));
        printAllPaths(graph, 0, 6, new boolean[vertices], 0 + "");
        int criteria = 30;
        int k = 4;
        multisolver(graph, 0, 6, new boolean[vertices], 30, 4, 0 + "", 0);
        System.out.println("Smallest Path = " + spath + "@" + spathwt);
        System.out.println("Largest Path = " + lpath + "@" + lpathwt);
        System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
        System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);

        connectedEdges(graph, vertices);
        System.out.println(isConnected);
        System.out.println('1'-'0');
    }

}
