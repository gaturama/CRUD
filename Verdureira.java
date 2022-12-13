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
    
    public static void cadastrarProduto(Scanner scanner){
        try{
            System.out.println("Cadastro de Produtos");
            System.out.println("Digite o Id do produto: ");
            int id = scanner.nextInt();
            System.out.println("Digite a descrição do produto: ");
            String descricao = scanner.next();
            System.out.println("Digite o tamanho do produto: ");
            String tamanho = scanner.next();
            System.out.println("Digite a cor do produto: ");
            String cor = scanner.next();
            
            new Produto(id, descricao, tamanho, cor);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar o Produto");
        }
    }
    
    public static void listarProduto(){
        System.out.println("Listar Produto");
        for(Produto produto : Produto.produtos){
            System.out.println(produto);
        }
    }
    
    public static void excluirProduto(Scanner scanner){
        try{
            System.out.println("Digite o Id do produto: ");
            int id = scanner.nextInt();
            Produto.excluir(id);
            System.out.println("Produto excluído com sucesso!");
        }catch (Exception e){
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
    
    public static void listarFabricante(){
        System.out.println("Listar Fabricante");
        for(Fabricante fabricante : Fabricante.fabricantes){
            System.out.println(fabricante);
        }
    }
    
    public static void excluirFabricante(Scanner scanner){
        try{
            System.out.println("Digite o Id do fabricante: ");
            int id = scanner.nextInt();
            Fabricante.excluir(id);
            System.out.println("Fabricante excluído com sucesso!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
