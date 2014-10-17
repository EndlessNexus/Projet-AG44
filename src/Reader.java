import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

	protected String path = "";
	protected int order = 0;
	protected String matrix[];
	protected InputStream flux;

	Reader() {
	};

	Reader(String path) {

		try {
			InputStream flux = new FileInputStream(path);
			InputStreamReader reader = new InputStreamReader(flux);
			BufferedReader buffer = new BufferedReader(reader);
			String line;

			// On obtient la première ligne, qui correspond à la taille du graph
			line = buffer.readLine();
			// On le converti en int
			order = Integer.parseInt(line);

			// On crée le tableau de string contenant chaque ligne de la matrice
			matrix = new String[8];

			// On capture toute les lignes de la matrice et on les mets dans le
			// tableau
			for (int i = 0; i < 8; i++) {
				matrix[i] = buffer.readLine();
				// On affiche la ligne capturée
			}

			buffer.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public int getOrder() {
		return this.order;
	}

	public String[] getMatrix() {
		return this.matrix;
	}
}
