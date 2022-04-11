import java.util.*;
public class DFSApp {
	
	private LinkedList<Integer> adj[];
	private boolean visited[];
	
	DFSApp(int vertex)
	{
		adj = new LinkedList[vertex];
		visited = new boolean[vertex];
		
		for(int i=0;i< vertex; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdage(int v, int w)
	{
		adj[v].add(w);
	}
	
	void DFS(int vertex)
	{
		visited[vertex] = true;
		System.out.print(vertex +" ");
		
		Iterator<Integer> iterator = adj[vertex].listIterator();
		while(iterator.hasNext())
		{
			int adj = iterator.next();
			if(!visited[adj])
			{
				DFS(adj);
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DFSApp app = new DFSApp(6);
		app.addEdage(0, 1);
		app.addEdage(0, 2);
		app.addEdage(1, 0);
		app.addEdage(1, 3);
		app.addEdage(2, 0);
		app.addEdage(2, 3);
		app.addEdage(3, 4);
		app.addEdage(3, 5);
		app.addEdage(4, 3);
		app.addEdage(5, 3);
		
		System.out.println("Depth First Traversal: ");
		app.DFS(0);

	}

}
