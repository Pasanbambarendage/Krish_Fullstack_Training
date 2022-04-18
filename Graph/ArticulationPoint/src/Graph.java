import java.util.*; 
public class Graph {
	private int vertex;
	private LinkedList<Integer> adj[];
	int time=0;
	static final int NIL =-1;
	
	public Graph(int v) 
	{
		// TODO Auto-generated constructor stub
		vertex= v;
		adj= new LinkedList[v];
		for(int i=0; i<v; i++)
		{
			adj[i]= new LinkedList();
		}
	}
	
	void addEdage(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void APUtill(int u, boolean visited[], int disc[],  
            int low[], int parent[], boolean isAP[])
	{
		//Count of the children in DFS tree.
		int children=0;
		
		//Mark the current node as visited.
		visited[u]=true;
		
		//Initialize discovery time and low value
		disc[u] = low[u]=++time;
		
		//Go through all vertices adj to this
		Iterator<Integer> i= adj[u].iterator();
		while(i.hasNext())
		{
			int v= i.next();
			if(!visited[v])
			{
				children++;
				parent[v] = u;
				APUtill(v, visited, disc, low, parent, isAP);
				
				low[u] = Math.min(low[u], low[v]);
				if(parent[u] == NIL && children >1)
				{
					isAP[u]=true;
				}
				
				if(parent[u] !=NIL && low [v]>= disc[u])
				{
					isAP[u]= true;
				}
			}
			else if (v != parent[u]) 
			{
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		
	}
	
	void AP()
	{
		boolean visited[] = new boolean [vertex];
		int disc [] = new int [vertex];
		int low[] = new int[vertex];
		int parent [] =new int [vertex];
		boolean isAP[] = new boolean [vertex];
		
		for(int i =0; i< vertex; i++)
		{
			parent[i] = NIL;
			visited[i] = false;
			isAP[i] = false;
		}
		
		for(int i =0; i< vertex; i++)
		{
			if(visited[i] == false)
			{
				APUtill(i, visited, disc, low, parent, isAP);
			}
		}
		
		for(int i=0; i< vertex; i++)
		{
			if(isAP[i]== true)
			{
				System.out.print(i + " ");
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Articulation Point in the graph : ");
		Graph graph =new Graph(5);
		
		graph.addEdage(1, 0);
		graph.addEdage(0, 2);
		graph.addEdage(2, 1);
		graph.addEdage(0, 3);
		graph.addEdage(3, 4);
		
		graph.AP();

	}

}
