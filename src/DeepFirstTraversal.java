import java.util.ArrayList;

public class DeepFirstTraversal {

	private ArrayList<Vertex> dfsList;
	private int postOrder = 1;

	DeepFirstTraversal() {
		dfsList = new ArrayList<Vertex>();
		postOrder = 1;
	}

	public ArrayList<Vertex> getDeepFirstTraversal(Vertex graph[]) {
		for (int i = 0; i < graph.length; i++) {
			if (!graph[i].getDiscovered())
				dfs(graph[i]);
		}
		return dfsList;
	}

	public void dfs(Vertex vertex) {
		// On marque le vertex
		vertex.setDiscovered(true);
		// Pour tout les vertex adjacents
		for (int j = 0; j < vertex.getAdjacencyList().size(); j++) {
			// Si le vertex adjacent n'est pas marqué
			if (!vertex.getAdjacencyList().get(j).getDiscovered()) {
				// On applique la récursivité
				dfs(vertex.getAdjacencyList().get(j));
			}
		}
		// On lui attribue la valeur de postOrder
		vertex.setPostOrder(this.postOrder);
		// On ajoute le vertex à la dfsList
		dfsList.add(vertex);

		// On incrémente la valeur de postOrder
		this.postOrder++;

		// Si le vertex choisi n'a pas de valeur de postOrder, on lui en assigne
		// une
		if (vertex.getPostOrder() == -1) {
			vertex.setPostOrder(postOrder);
		}
	}
}
