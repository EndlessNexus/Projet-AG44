import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedComponents {

	private int index;
	private Stack<Vertex> stack;
	private ArrayList<ArrayList<Vertex>> stronglyConnectedComponents;

	StronglyConnectedComponents() {
		index = 0;
		stack = new Stack<Vertex>();
		stronglyConnectedComponents = new ArrayList<ArrayList<Vertex>>();
	}

	public ArrayList<ArrayList<Vertex>> getStronglyConnectedComponents(
			Vertex[] graph) {
		for (int i = 0; i < graph.length; i++) { // LENGTH ?
			if (graph[i].getIndexValue() == -1) {
				recursivity(graph[i]);
			}
		}
		return stronglyConnectedComponents;
	}

	public void recursivity(Vertex vertex) {
		vertex.setIndexValue(index);
		vertex.setLowLinkValue(index);
		index++;
		stack.push(vertex);

		// Pour chaque vertex adjacent
		Iterator<Vertex> adjacentVertexIterator = vertex.getAdjacencyList()
				.iterator();
		while (adjacentVertexIterator.hasNext()) {
			Vertex adjacentVertex = adjacentVertexIterator.next();
			// Si le vertex adjacent n'a pas encore été visité, on applique la
			// récursivité dessus
			if (adjacentVertex.getIndexValue() == -1) {
				recursivity(adjacentVertex);
				vertex.setLowLinkValue(Math.min(vertex.getLowLinkValue(),
						adjacentVertex.getLowLinkValue()));
			}
			// Si le successeur est dans la pile, et donc est un strongly
			// connected component
			else if (stack.contains(adjacentVertex)) {
				vertex.setLowLinkValue(Math.min(vertex.getLowLinkValue(),
						adjacentVertex.getIndexValue()));
			}
		}

		// Si le vertex est une racine, on génère la liste de strongly connected
		// components
		if (vertex.getLowLinkValue() == vertex.getIndexValue()) {
			ArrayList<Vertex> stronglyConnectedList = new ArrayList<Vertex>();
			Vertex vertexToAdd;
			do {
				vertexToAdd = stack.pop();
				stronglyConnectedList.add(vertexToAdd);
			} while (vertexToAdd != vertex);
			// On ajoute cette liste à notre ensemble de strongly connected
			// components
			stronglyConnectedComponents.add(stronglyConnectedList);
		}
	}
}
