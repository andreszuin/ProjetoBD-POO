package application;
import javax.swing.*;
import java.sql.*;

public class Conecta {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/Dados";
    private String usuario = "postgres";
    private String senha = "aula321";
    public Connection conn;
    /**realiza a conexão com o banco de dados*/
    public void conexao(){
        try {
            System.setProperty("jdbc.Drivers",driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null,"conexão realizada com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao conectar!\n"+ex,"Erro", JOptionPane.ERROR_MESSAGE);
            Main.mainstage.close();
            System.exit(0);
        }
    }
    /**executa strings de sql*/
    public void executa(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"erro no executa");
        }
    }
    /**finaliza a conexão com o banco de dados*/
    public void desconnect(){
        try {
            conn.close();
            //JOptionPane.showMessageDialog(null,"desconectado com sucesso");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao desconectar");
        }

    }
}
