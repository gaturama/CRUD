import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fabricante {
    
    private int id;
    private String nome;
    private int idProduto;

    public Fabricante(
        int id,
        String nome,
        int idProduto

    ) throws SQLException{
        this.id = id;
        this.nome = nome;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Fabricante (id, nome, produto) VALUES (?, ? , ?)"
        );
        stmt.setInt(1, id);
        stmt.setString(2, nome);
        stmt.setInt(3, idProduto);
        stmt.execute();
        stmt.close();
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String nome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public static void listarFabricante() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Fabricante;"
        );
        while(rs.next()){
            System.out.println(
                "Id: " + rs.getInt("id") + 
                "Nome: " + rs.getString("nome") + 
                "Produto: " + rs.getInt("idProduto")
            );

        }

    }

    public static void updateFabricante(int id) throws SQLException{
        
    }
        
    
}
