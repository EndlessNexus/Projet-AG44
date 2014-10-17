import java.util.Scanner;


public class GameLevelAnalyzer {
	private Graph graph;
	private Scanner scanner = new Scanner(System.in);
	private String filePath;
	
	GameLevelAnalyzer() {
		this.getLevelFilePath();
		graph = new Graph(filePath);
	}
	
	public void getLevelFilePath () {
		System.out.println("\n\n\nVeuillez entrer le chemin d'accès au fichier contenant le niveau: ");
		filePath = scanner.nextLine();
	}
	
	public void getGameLevel () {
		System.out.println("\nVoici les différents niveaux du jeu, ainsi que les endroits que ces niveaux contiennent:\n");
		graph.showStronglyConnectedComponents();
	}
	
	
	
}
