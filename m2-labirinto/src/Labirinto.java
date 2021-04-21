import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

enum Sentido {
	DIREITA, ESQUERDA, ACIMA, ABAIXO, NENHUM;
}

public class Labirinto {
	
	private boolean passouPelaPosicaoZero = false;
//	private boolean vindoDaEsquerda = false;
//	private boolean vindoDaDireita = false;
//	private boolean vindoDeCima = false;
//	private boolean vindoDeBaixo = false;
	
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
		return percorreLabirinto(labirinto, 0, 0, Sentido.NENHUM);
	}
	
	private boolean percorreLabirinto(char[][] labirinto, int linha, int coluna, Sentido sentido) {
		if (labirinto[linha][coluna] != 'D') {
			if (labirinto[linha][coluna] != 'X') {
				
				if (linha == 0 & coluna == 0 & passouPelaPosicaoZero == false) 
					passouPelaPosicaoZero = true;
				else if (linha == 0 & coluna == 0 & passouPelaPosicaoZero == true) 
					return false;
				
				char[][] l = labirinto;
//				l[linha][coluna] = '|';
				imprimeLabirinto(l);
				
				// AVANÇA
				
				if (coluna+1 < labirinto[linha].length) {
					if (labirinto[linha][coluna+1] == ' ' && !sentido.equals(Sentido.DIREITA)) { // direita
						l = labirinto;
//						l[linha][coluna+1] = '|';
						imprimeLabirinto(l);
						return percorreLabirinto(labirinto, linha, coluna+1, Sentido.ESQUERDA);
					}
				}

				if (linha+1 < labirinto.length) {
					if (labirinto[linha+1][coluna] == ' ' && !sentido.equals(Sentido.ABAIXO)) { // abaixo
						l = labirinto;
//						l[linha+1][coluna] = '|';
						imprimeLabirinto(l);
						return percorreLabirinto(labirinto, linha+1, coluna, Sentido.ACIMA);
					}
				}

				if (linha > 0) {
					if (labirinto[linha-1][coluna] == ' ' && !sentido.equals(Sentido.ACIMA)) { // acima
						l = labirinto;
//						l[linha-1][coluna] = '|';
						imprimeLabirinto(l);
						return percorreLabirinto(labirinto, linha-1, coluna, Sentido.ABAIXO);
					}
				}
				
				if (coluna > 0) {
					if (labirinto[linha][coluna-1] == ' ' && !sentido.equals(Sentido.ESQUERDA)) { // esquerda
						l = labirinto;
//						l[linha][coluna-1] = '|';
						imprimeLabirinto(l);
						return percorreLabirinto(labirinto, linha, coluna-1, Sentido.DIREITA);
					}
				}
				
				// VOLTA
				
//				if (coluna > 0) {
//					if (labirinto[linha][coluna-1] == '|') { // esquerda
//						l = labirinto;
////						l[linha][coluna-1] = '-';
//						imprimeLabirinto(l);
//						return percorreLabirinto(labirinto, linha, coluna-1);
//					}
//				}
//				
//				if (linha > 0) {
//					if (labirinto[linha-1][coluna] == '|') { // acima
//						l = labirinto;
////						l[linha-1][coluna] = '-';
//						imprimeLabirinto(l);
//						return percorreLabirinto(labirinto, linha-1, coluna);
//					}
//				}
//
//				if (linha+1 < labirinto.length) {
//					if (labirinto[linha+1][coluna] == '|') { // abaixo
//						l = labirinto;
////						l[linha+1][coluna] = '-';
//						imprimeLabirinto(l);
//						return percorreLabirinto(labirinto, linha+1, coluna);
//					}
//				}
//
//				if (coluna+1 < labirinto[linha].length) {
//					if (labirinto[linha][coluna+1] == '|') { // direita
//						l = labirinto;
////						l[linha][coluna+1] = '-';
//						imprimeLabirinto(l);
//						return percorreLabirinto(labirinto, linha, coluna+1);
//					}
//				}
				
			} else {
				return percorreLabirinto(labirinto, linha, coluna, Sentido.NENHUM);
			}
		} else {
			return true;
		}
		
		return false;
	}
	
	private void imprimeLabirinto(char[][] labirinto) {
		for (int linha = 0; linha < labirinto.length; linha++) {
			for (int coluna = 0; coluna < labirinto[linha].length; coluna++) {
				System.out.print(labirinto[linha][coluna]);
			}
			System.out.println();
		}
		System.out.println();
	}
				
}
