import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {
	
	public char[][] carregaLabirinto(String fileName) {
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
	
	public boolean labirinto(String fileName) {
		char[][] labirinto = carregaLabirinto(fileName);
		return percorreLabirinto(labirinto, 0, 0);
	}
	
	private boolean percorreLabirinto(char[][] labirinto, int linha, int coluna) {
		if (labirinto[linha][coluna] == ' ' && labirinto[linha][coluna] != 'D') {
			if (labirinto[linha][coluna+1] == ' ') { // direita
				char[][] l = labirinto;
				l[linha][coluna+1] = 'I';
				imprimeLabirinto(l);
				return percorreLabirinto(labirinto, linha, coluna+1);
			} else if (labirinto[linha+1][coluna] == ' ') { // abaixo
				labirinto[linha+1][coluna] = 'I';
				imprimeLabirinto(labirinto);
				return percorreLabirinto(labirinto, linha+1, coluna);
			} else if (labirinto[linha-1][coluna] == ' ' && linha > 0) { // acima
				labirinto[linha-1][coluna] = 'I';
				imprimeLabirinto(labirinto);
				return percorreLabirinto(labirinto, linha-1, coluna);
			} else if (labirinto[linha][coluna-1] == ' ' && coluna > 0) { // esquerda
				labirinto[linha][coluna-1] = 'I';
				imprimeLabirinto(labirinto);
				return percorreLabirinto(labirinto, linha, coluna-1);
			}
		}
		return true;
	}
	
	private void imprimeLabirinto(char[][] labirinto) {
		for (int linha = 0; linha < labirinto.length; linha++) {
			for (int coluna = 0; coluna < labirinto.length; coluna++) {
				System.out.print(labirinto[linha][coluna]);
			}
			System.out.println();
		}
	}
				
}
