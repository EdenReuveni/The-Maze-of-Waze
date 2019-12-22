package dataStructure;

import java.util.*; 


public class DGraph implements graph{

	static int mcCounter=0;
	public HashMap<Integer, node_data> nodesMap = new HashMap<Integer, node_data>();
	public HashMap<Integer,HashMap<Integer,edge_data> > edgesMap = new HashMap<Integer,HashMap<Integer,edge_data> >();



	@Override
	public node_data getNode(int key) {
		if (nodesMap.containsKey(key))
			return nodesMap.get(key);
		return null;
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return edgesMap.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		mcCounter++;
		nodesMap.put(n.getKey(), n);

	}

	@Override
	public void connect(int src, int dest, double w) {
		if(nodesMap.containsKey(src) && nodesMap.containsKey(dest)) {
			mcCounter++;
			EdgeData edgeToInsert = new EdgeData(src, dest, w);
			if(edgesMap.containsKey(src)) {
				
				if(!edgesMap.get(src).containsKey(dest)) {
					edgesMap.get(src).put(dest, edgeToInsert);	
					
				}
				
			}
			else {
			HashMap<Integer,edge_data> innerEdgeHash = new HashMap<Integer,edge_data>(); 
			innerEdgeHash.put(dest, edgeToInsert);
			edgesMap.put(src, innerEdgeHash);
			}
			
			
			
		}
		
		
	}
	

	@Override
	public Collection<node_data> getV() {
		return nodesMap.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return edgesMap.get(node_id).values();

	}

	@Override
	public node_data removeNode(int key) {
		if(nodesMap.containsKey(key)) {
			mcCounter++;
			node_data  nd = nodesMap.get(key); 
			nodesMap.remove(key);
			edgesMap.remove(key);
			edgesMap.entrySet().forEach(entry->{///return to this remove all the destinon node
			 
			});
			
			
			
			
			
		return nd;	
		}
		return null;
		
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		if(edgesMap.containsKey(src) && edgesMap.get(src).containsKey(dest)) {
			mcCounter++;
			edge_data ed = edgesMap.get(src).get(dest);
			edgesMap.get(src).remove(dest);
			return ed;			
		}
		return null;
	}

	@Override
	public int nodeSize() {
		return nodesMap.size();
	}

	@Override
	public int edgeSize() {
		return edgesMap.size();
	}

	@Override
	public int getMC() {
		return mcCounter;
	}


	
	

}
