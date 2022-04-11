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
			System.out.print(s + "");
			
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
		BFSApp app = new BFSApp(0)

	}

}
