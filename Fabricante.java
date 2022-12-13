import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Fabricante {
    
    private int id;
    private String nome;
    private int idProduto;

    public static ArrayList<Fabricante> fabricantes = new ArrayList<>();

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
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Fabricante SET id = ? WHERE nome = ?;"
            );
            stmt.setInt(1, id);
            stmt.setString(2, "João");
            stmt.close();
    }
    public void deleteFabricante(int id) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "DELETE FROM Fabricante WHERE id = ?;"
            );
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
    }
    
    @Override 
    public String toString(){
        return "Id: " + id + "\n"
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
