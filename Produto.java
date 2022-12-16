import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Produto {

    private int idProduto;
    private String descricao;
    private String tamanho;
    private String cor;


    public Produto(
        int idProduto,
        String descricao,
        String tamanho,
        String cor
        
    )throws SQLException{
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO Produto (idProduto, descricao, tamanho, cor) VALUES (?, ?, ?, ?)"
        );
        stmt.setInt(1, idProduto);
        stmt.setString(2, descricao);
        stmt.setString(3, tamanho);
        stmt.setString(4, cor);
        stmt.execute();
        stmt.close();
    } 

    public static void listarProduto() throws SQLException{
        Connection connec = DAO.createConnection();
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM Produto;"
        );
        while(rs.next()){
            System.out.println(
                "ID: " + rs.getInt("idProduto") + "\n" +
                "Descrição: " + rs.getString("descricao") + "\n"
                + "Tamanho: " + rs.getString("tamanho") + "\n"
                + "Cor: "  + rs.getString("cor")
            );
        }
    }

    public static void updateProduto(int idProduto, String descricao, String tamanho, String cor) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "UPDATE Produto SET descricao = ?, tamanho = ?, cor = ?, WHERE idProduto = ?;"
        );
        stmt.setString(1, "descricao");
        stmt.setString(2, "tamanho");
        stmt.setString(3, "cor");
        stmt.setInt(4, 1);
        stmt.execute();
        stmt.close();
    }

    public static void deleteProduto(int idProduto) throws SQLException{
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
                "DELETE FROM Produto WHERE idProduto = ?;"
        );
        stmt.setInt(1, idProduto);
        stmt.execute();
        stmt.close();
    }
    
    public int getIdProduto(){
        return idProduto;
    }
    public void setId(int idProduto){
        this.idProduto = idProduto;
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
    @Override
    public String toString(){
        return "Id: " + idProduto + "\n"
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

        return this.getIdProduto() == other.getIdProduto();
    }
}
