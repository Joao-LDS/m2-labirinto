import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//	    System.out.println("Digite o nome do arquivo: ");
//	    String fileName = sc.nextLine();
	    
	    Labirinto l = new Labirinto();
	    boolean temCaminho = l.labirinto("labirinto.txt");
	    
	    if (temCaminho) {
	    	System.out.println("Tem caminho");
	    } else {
	    	System.out.println("Não tem caminho");
	    }
	    
	    sc.close();

	}

}
