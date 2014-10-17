import java.util.ArrayList;

public class Vertex {
	private int value, preOrder, postOrder, indexValue, lowLinkValue;
	private boolean discovered;
	private ArrayList<Vertex> adjacencyList = new ArrayList<Vertex>();

	// Constructeurs
	Vertex() {
		value = -1;
		preOrder = -1;
		postOrder = -1;
		discovered = false;
		adjacencyList = new ArrayList<Vertex>();
		indexValue = -1;
	}

	Vertex(int initValue) {
		this.value = initValue;
		this.preOrder = -1;
		this.postOrder = -1;
		this.discovered = false;
		adjacencyList = new ArrayList<Vertex>();
		indexValue = -1;
	}

	Vertex(Vertex v) {
		this.value = v.value;
		this.preOrder = v.preOrder;
		this.postOrder = v.postOrder;
		this.discovered = false;
		adjacencyList = v.adjacencyList;
		indexValue = -1;
	}

	// Showers
	public void showAdjacencyList() {
		// On mets en évidence le vertex concerné
		System.out.print("[" + value + "]");
		// Pour chaque vertex de l'adjacencyList
		for (int j = 0; j < adjacencyList.size(); j++) {
			// On affiche sa valeur
			System.out.print(adjacencyList.get(j).getValue());
			if (j < adjacencyList.size() - 1)
				System.out.print("->");
		}
	}

	// Getters & Setters
	public boolean getDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getPreOrder() {
		return preOrder;
	}

	public void setPreOrder(int preOrder) {
		this.preOrder = preOrder;
	}

	public int getPostOrder() {
		return postOrder;
	}

	public void setPostOrder(int postOrder) {
		this.postOrder = postOrder;
	}

	public ArrayList<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<Vertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public int getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(int indexValue) {
		this.indexValue = indexValue;
	}

	public int getLowLinkValue() {
		return lowLinkValue;
	}

	public void setLowLinkValue(int lowLinkValue) {
		this.lowLinkValue = lowLinkValue;
	}

}
