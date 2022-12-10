import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionDB {

    public static void main(String[] args) {
        try {
            Connection connec = DAO.createConnection();
            // Usuario usuario = new Usuario("manezinho.ilha", "Manézinho da ilha", "347");

            /* INSERT Usuário */
            /* PreparedStatement stmt = connec.preparedStatement(
                "INSERT INTO usuario (username, name, password) VALUES (?,?,?)"
            );
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getName());
            stmt.setString(3, usuario.getPassword());
            stmt.execute();*/

            /* SELECT ALL USERS */
            imprimirUsuarios(connec);

            /* DELETE id = 2 */
            PreparedStatement stmt = connec.prepareStatement(
                "DELETE FROM usuario WHERE id =?;"
            );    

            /* UPDATE id = 1 */
            stmt = connec.prepareStatement(
                "UPDATE usuario SET username = ?, name =?, password =? WHERE id =?"
 
            );
            stmt.setString(1, "jorge.pneu");
            stmt.setString(2, "Jorge dos pneus");
            stmt.setString(3, "654321");
            stmt.setInt(4, 1);
            stmt.execute();
            imprimirUsuarios(connec);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void imprimirUsuarios(Connection connec) throws Exception {
        ResultSet rs = connec.createStatement().executeQuery(
            "SELECT * FROM usuario;"
        );
        while (rs.next()) {
            Usuario usuario2 = new Usuario(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("name"),
                rs.getString("password")
            );
            System.out.println(usuario2);
            System.out.println("===============================");
        }
    }
}
