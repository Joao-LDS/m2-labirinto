import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

	    System.out.println("Digite o nome do arquivo: ");
	    String fileName = sc.nextLine();
	    
	    char[][] labirinto = Labirinto.carregaLabirinto(fileName);
	    
	    if (Labirinto.labirinto(labirinto)) {
	    	
	    } else {
	    	
	    }
	    
	    sc.close();

	}

}
