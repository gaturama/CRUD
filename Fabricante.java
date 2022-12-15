import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fabricante {
    
    private int idFabricante;
    private String nome;
    private int idProduto;


    public Fabricante(
        int idFabricante,
        String nome,
        int idProduto

    ) throws SQLException{
        this.idFabricante = idFabricante;
        this.nome = nome;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Fabricante (idFabricante, nome, produto) VALUES (?, ? , ?)"
        );
        stmt.setInt(1, idFabricante);
        stmt.setString(2, nome);
        stmt.setInt(3, idProduto);
        stmt.execute();
        stmt.close();
    }
    public int getId(){
        return idFabricante;
    }
    public void setId(int idFabricante){
        this.idFabricante = idFabricante;
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
                "Id: " + rs.getInt("idFabricante") + 
                "Nome: " + rs.getString("nome") + 
                "Produto: " + rs.getInt("idProduto")
            );

        }

    }

    public static void updateFabricante(int idFabricante, String nome) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Fabricante SET id = ? WHERE nome = ?;"
            );
            stmt.setInt(1, idFabricante);
            stmt.setString(2, "João");
            stmt.close();
    }
    public static void deleteFabricante(int idFabricante) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Fabricante WHERE id = ?;"
            );
            stmt.setInt(1, idFabricante);
            stmt.execute();
            stmt.close();
    }
    
    @Override 
    public String toString(){
        return "Id: " + idFabricante + "\n"
            + "Nome: " + nome + "\n"
            + "Produto: " + this.idProduto + "\n";
    }
    
    @Override
    public boolean equals (Object object){
        if(object == null || !(object instanceof Fabricante)){
            return false;
        }
        final Fabricante other = (Fabricante) object;
        
        return this.getId() == other.getId();
    }
}
