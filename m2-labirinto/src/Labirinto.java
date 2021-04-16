import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
	
	public static char[][] carregaLabirinto(String fileName) {
		char[][] array = null;
		
		try {
			FileReader fr = new FileReader("src/" + fileName);
			BufferedReader br = new BufferedReader(fr);
			
			int lines = Integer.parseInt(br.readLine());
			int columns = Integer.parseInt(br.readLine());
			array = new char[lines][columns];
			String line = br.readLine();
			
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length; j++) {
					array[i][j] = line.charAt(j);
				}
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo " + fileName + " não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro ao ler " + fileName + ".");
		}
		
		return array;
	}
	
	public static boolean labirinto(char[][] labirinto) {
		// web 13/04 17min
		return true;
	}
				
}
