import java.util.*;

public class BFSApp {
	
	private int Vertex;
	private LinkedList<Integer> adj[];
	
	BFSApp(int vertex)
	{
		Vertex = vertex;
		adj = new LinkedList[vertex];
		for(int i=0;i<vertex;++i)
		{
			adj[i]= new LinkedList();
		}
		
	}
	
	void addEdage(int v, int w)
	{
		adj[v].add(w);
	}
	
	void BFS(int s)
	{
		boolean visited[]= new boolean[Vertex];
		LinkedList<Integer> queue = new LinkedList();
		visited[s] = true;
		queue.add(s);
		
		while(queue.size()!=0)
		{
			s=queue.poll();
			System.out.print(s + " ");
			
			Iterator<Integer> i =adj[s].listIterator();
			while(i.hasNext())
			{
				int n= i.next();
				if(!visited[n])
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFSApp app = new BFSApp(6);
		app.addEdage(0, 1);
		app.addEdage(0, 3);
		app.addEdage(0, 4);
		app.addEdage(4, 5);
		app.addEdage(3, 5);
		app.addEdage(1, 2);
		app.addEdage(1, 0);
		app.addEdage(2, 1);
		app.addEdage(4, 1);
		app.addEdage(3, 1);
		app.addEdage(5, 4);
		app.addEdage(5, 3);
		
		System.out.println("Following is breath First Traversal of the graph is as follows :  ");
		app.BFS(0);

	}

}
