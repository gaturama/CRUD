import java.util.Scanner;
import java.sql.SQLException;

public class Verdureira {
    
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        
        System.out.println("SEJA BEM VINDO A VERDUREIRA COLHEITA FELIZ");
            
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
                    Produto.listarProduto();
                    break;
                case 3: 
                    System.out.println("Informe o Id do produto que você gostaria de alterar: ");
                    int idProduto = scanner.nextInt();
                    Produto.updateProduto(idProduto);
                    break;
                case 4: 
                    deleteProduto(scanner);
                    break;
                case 5:
                    cadastrarFabricante(scanner);
                    break;
                case 6:
                    Fabricante.listarFabricante();
                    break;
                case 7: 
                    System.out.println("Informe o Id do fabricante que você gostaria de alterar: ");
                    int idFabricante = scanner.nextInt();
                    Fabricante.updateFabricante(idFabricante);
                    break;
                case 8: 
                    deleteFabricante(scanner);
                    break;
            }
        }while(op!= 0);
        scanner.close();
    }


    public static void cadastrarProduto(Scanner scanner) throws SQLException{
        try{
            System.out.println("Cadastro de Produtos");
            System.out.println("Digite o Id do produto");
            int id = scanner.nextInt();
            System.out.println("Digite a descrição do produto: ");
            String descricao = scanner.next();
            System.out.println("Digite o tamanho do produto: ");
            String tamanho = scanner.next();
            System.out.println("Digite a cor do produto: ");
            String cor = scanner.next();
            
            new Produto(id,descricao, tamanho, cor);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Produto");
        }
    }
    
    public static void deleteProduto(Scanner scanner) throws SQLException{
        try{
            System.out.println("Informe o id do produto: ");
            int idProduto = scanner.nextInt();
            Produto.deleteProduto(idProduto);
            System.out.println("Produto removido com sucesso!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
        
    public static void cadastrarFabricante(Scanner scanner){
        try{
            System.out.println("Cadastro de Fabricantes");
            System.out.println("Digite o Id do fabricante: ");
            int id = scanner.nextInt();
            System.out.println("Digite nome do fabricante: ");
            String nome = scanner.next();
            System.out.println("Digite o produto desse fabricante: ");
            int idProduto = scanner.nextInt();
            
            new Fabricante(id, nome, idProduto);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Fabricante");
        }
    }
    
    public static void deleteFabricante(Scanner scanner) throws SQLException{
        try{
        System.out.println("Informe o id do fabricante");
        int idFabricante = scanner.nextInt();
        Fabricante.deleteFabricante(idFabricante);
        System.out.println("Fabricante removido com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
