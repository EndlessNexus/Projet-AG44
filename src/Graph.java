import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
	private int order;
	private Vertex graph[];
	private String matrix[];
	private ArrayList<Vertex> dfsList;
	private ArrayList<ArrayList<Vertex>> stronglyConnectedComponents;

	// Constructeurs
	Graph() {
		// On initialise les variables du graph
		order = 0;
		dfsList = new ArrayList<Vertex>();
		stronglyConnectedComponents = new ArrayList<ArrayList<Vertex>>();
	};

	Graph(String path) {
		// On initialise les variables du graph
		order = 0;
		dfsList = new ArrayList<Vertex>();
		stronglyConnectedComponents = new ArrayList<ArrayList<Vertex>>();

		// On crée un reader se basant sur le chemin d'accès au graph
		Reader reader = new Reader(path);
		// L'ordre du graph est donné par le reader
		order = reader.getOrder();

		// On crée un graph contenant tout les vertex
		graph = new Vertex[reader.getOrder()];
		matrix = reader.getMatrix();
		for (int i = 0; i < reader.getOrder(); i++) {
			graph[i] = new Vertex(i + 1);
		}

		// On génère l'adjacencyList de chaque vertex
		for (int i = 0; i < order; i++) {
			// Les vertex connectées sont présents tout les deux charactères
			for (int j = 0; j < reader.getOrder() * 2; j += 2) {
				// On ajoute le vertex uniquement s'il est connecté (!= 0)
				if (Integer.parseInt(matrix[i].substring(j, j + 1)) != 0) {
					graph[i].getAdjacencyList().add(graph[j / 2]);
				}
			}
		}
		// On fait le calcul des strongly connected components
		this.computeStronglyConnectedComponents();

		// On effectue un DeepFirstTraversal
		this.computeDeepFirstTraversal();

	}

	// Calcul des strongly connected components
	public void computeStronglyConnectedComponents() {
		stronglyConnectedComponents = new StronglyConnectedComponents()
				.getStronglyConnectedComponents(graph);
	}

	// Calcul du deep first traversal avec post order numérotation
	public void computeDeepFirstTraversal() {
		dfsList = new DeepFirstTraversal().getDeepFirstTraversal(graph);
	}

	// Showers

	// Affichage des adjacencyList de chaque vertex du graph
	public void showAdjacencyLists() {
		System.out.println("Graph Adjacency Lists:");
		// Pour chaque vertex du graph
		for (int i = 0; i < order; i++) {
			// Affichage de l'adjacencyList de chaque vertex
			graph[i].showAdjacencyList();
			System.out.println("");
		}
		System.out.println("");
	}

	// Affichage de la matrice d'où est issue le graph
	public void showMatrix() {
		System.out.println("Graph Adjacency Matrix:");
		for (int i = 0; i < order; i++)
			System.out.println(matrix[i]);
		System.out.println("");
	}

	// Affichage du nombre de vertex contenu dans le graph
	public void showOrder() {
		System.out.println("Graph Order:" + order + "\n");
	}

	// Affichage de la Post Order numérotation de chaque vertex contenu dans le
	// graph
	public void showPostOrder() {
		System.out.println("Graph Post Order value:");
		for (int i = 0; i < order; i++) {
			System.out.println("Vertex [" + graph[i].getValue()
					+ "] Post Order Value: " + graph[i].getPostOrder());
		}
		System.out.println("");
	}

	// Affichage de la liste des vertex du graph réspectant la Post Order
	// numérotation
	public void showPostOrderList() {
		System.out.println("Post Order List:");
		System.out.print("{");
		for (int i = 0; i < dfsList.size(); i++) {
			System.out.print(dfsList.get(i).getValue());
			if (i < dfsList.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.println("}\n");
	}

	// Affichage des différents strongly Connected Elements
	public void showStronglyConnectedComponents() {
		for (int i = 0; i < stronglyConnectedComponents.size(); i++) {
			System.out.print("{");
			for (int j = 0; j < stronglyConnectedComponents.get(i).size(); j++) {
				System.out.print(stronglyConnectedComponents.get(i).get(j)
						.getValue());
				if (j < stronglyConnectedComponents.get(i).size() - 1) {
					System.out.print(",");
				}
			}
			System.out.println("}");
		}
		System.out.println("");
	}
}
