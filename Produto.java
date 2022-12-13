import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Produto {

    private int id;
    private String descricao;
    private String tamanho;
    private String cor;

    public static ArrayList<Produto> produtos = new ArrayList<>();

    public Produto(
        int id,
        String descricao,
        String tamanho,
        String cor
        
    )throws SQLException{
        this.id = id;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Produto ( descricao, tamanho, cor) VALUES (?, ?, ?)"
        );
        stmt.setInt(1, id);
        stmt.setString(2, descricao);
        stmt.setString(3, tamanho);
        stmt.setString(4, cor);
        stmt.execute();
        stmt.close();
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getTamanho(){
        return tamanho;
    }
    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }
    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    public static void listarProduto() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Produto;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("id") + 
                "Descrição: " + rs.getString("descricao") + 
                "Tamanho: " + rs.getString("tamanho") + 
                "Cor: "  + rs.getString("cor")
            );
        }
    }

    public static void updateProduto(int id) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Produto SET descricao = ?, tamanho = ? WHERE id = ?;"
        );
        stmt.setString(1, "teste");
        stmt.setString(2, "Batata");
        stmt.setInt(3, id);
        stmt.execute();
        stmt.close();
    }

    public void deleteProduto(int id) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "DELETE FROM Produto WHERE id = ?;"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
    
    @Override
    public String toString(){
        return "Id: " + id + "\n"
        + "Descrição: " + descricao + "\n"
        + "Tamanho: " + tamanho + "\n"
        + "Cor: " + cor + "\n";
    } 

    @Override 
    public boolean equals (Object object){
        if(object == null || !(object instanceof Produto)){
            return false;
        }
        final Produto other = (Produto) object;

        return this.getId() == other.getId();
    }
}
