import java.util.*;
class CountComponents
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Graph graph = new Graph(n);
        for(int i=0;i<m;i++)
        {
            int v=sc.nextInt();
            int w=sc.nextInt();
            graph.addEdge(v,w);
        }
        int total=graph.countComponents();
        System.out.println(total);
    }
}
class Graph
{
    int V;
    LinkedList<Integer> adj[];
    public Graph(int v)
    {
        this.V = v;
        adj = new LinkedList[V];
        for(int i=0;i<v;i++)
        {
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w)
    {
        adj[v-1].add(w);
        adj[w-1].add(v);
    }
    
    public void DFS(int start, boolean vis[])
    {
         vis[start-1] = true;
         Iterator<Integer> i = adj[start-1].listIterator();
         while(i.hasNext())
         {
             int n = i.next();
             if(!vis[n-1])
             {
                 DFS(n, vis);
             }
         }
    }
    
    public int check(int start, int end)
    {
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        DFS(start, visited);
        if(visited[end-1])
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    public int countComponents()
    {
        int count=0;
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            visited[i]=false;
        }
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                DFS(i+1,visited);
                count++;
            }
        }
        return count;
    }
}