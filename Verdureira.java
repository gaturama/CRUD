import java.util.Scanner;

public class Verdureira {
    
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        
        System.out.println("SEJA BEM VINDO A VERDUREIRA COLHEITA FELIZ")
            
        do{
            System.out.println("============================");
            System.out.println("1 - Cadastrar Produto: ");
            System.out.println("2 - Listar Produto: ");
            System.out.println("3 - Atualizar Produto: ");
            System.out.println("4 - Excluir Produto: ");
            System.out.println("5 - Cadastrar Fabricante: ");
            System.out.println("6 - Listar Fabricante: ");
            System.out.println("7 - Atualizar Fabricante: ");
            System.out.println("8 - Excluir Fabricante: ");
            System.out.println("============================");
            
            try{
                op = scanner.nextInt();
            }catch (Exception e){
                op = 0;
            }
            
            switch (op) {
                case 1:
                    cadastrarProduto(scanner);
                    break;
                case 2:
                    listarProduto();
                    break;
                case 3: 
                    alterarProduto(scanner);
                    break;
                case 4: 
                    excluirProduto(scanner);
                    break;
                case 5:
                    cadastrarFabricante(scanner);
                    break;
                case 6:
                    listarFabricante();
                    break;
                case 7: 
                    alterarFabricante(scanner);
                    break;
                case 8: 
                    excluirFabricante(scanner);
                    break;
            }
        }while(opcao!= 0);
        scanner.close();
    }
}
