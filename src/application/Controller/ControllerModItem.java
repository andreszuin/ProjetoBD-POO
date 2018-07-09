package application.Controller;

import application.Conecta;
import application.MController.ControllerConsole;
import application.MController.ControllerJogo;
import application.MController.ControllerJogoD;
import application.MController.ControllerJogoF;
import application.Model.Console;
import application.Model.JogoDigital;
import application.Model.JogoFisico;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLException;

public class ControllerModItem extends ControllerMaster{
    public Pane consolePane;
    public Pane fisicoPane;
    public Pane digitalPane;

    //console
    public TextField consoleId;
    public TextField consolePre;
    public TextField consoleMar;
    public TextField consoleMod;
    public TextField consoleCor;
    public TextField consoleMem;
    public TextField consoleCtr;
    public TextField consoleEst;
    public TextArea consoleDesc;
    //fisico
    public TextField fisicoId;
    public TextField fisicoPre;
    public TextField fisicoTit;
    public TextField fisicoPro;
    public TextField fisicoGen;
    public TextField fisicoPla;
    public TextField fisicoIdi;
    public TextField fisicoEst;
    public TextField fisicoAno;
    public TextArea fisicoDesc;
    //digital
    public TextField digitalId;
    public TextField digitalPre;
    public TextField digitalTit;
    public TextField digitalPro;
    public TextField digitalGen;
    public TextField digitalPla;
    public TextField digitalIdi;
    public TextField digitalTam;
    public TextField digitalAno;
    public TextField digitalIns;
    public TextField digitalKey;
    public TextArea digitalDesc;
    Conecta conex = new Conecta();
    Console con = new Console();
    ControllerConsole controlC = new ControllerConsole();
    JogoFisico jf = new JogoFisico();
    ControllerJogoF controlF = new ControllerJogoF();
    JogoDigital jd = new JogoDigital();
    ControllerJogoD controlD = new ControllerJogoD();

    public void showConsole(){
        fisicoPane.setVisible(false);
        digitalPane.setVisible(false);
        consolePane.setVisible(true);
    }
    public void showFisico(){
        digitalPane.setVisible(false);
        consolePane.setVisible(false);
        fisicoPane.setVisible(true);
    }
    public void showDigital(){
        fisicoPane.setVisible(false);
        consolePane.setVisible(false);
        digitalPane.setVisible(true);
    }
    //console
    public void encontrarC(){
        conex.conexao();
        try{
            conex.executa("select * from produto NATURAL JOIN console where prodid='" +consoleId.getText()+"'");
            conex.rs.first();
            consoleMod.setText(conex.rs.getString("nome"));
            Double pre = conex.rs.getBigDecimal("preço").doubleValue();
            consolePre.setText(String.valueOf(pre));
            consoleDesc.setText(conex.rs.getString("descrição"));
            consoleMar.setText(conex.rs.getString("marca"));
            consoleCor.setText(conex.rs.getString("cor"));
            consoleMem.setText(conex.rs.getString("hd"));
            consoleCtr.setText(String.valueOf(conex.rs.getInt("qntcontrole")));
            consoleEst.setText(String.valueOf(conex.rs.getInt("qntestoque")));

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }

    public void modificarC(){
        con.setId(Integer.parseInt(consoleId.getText()));
        con.setDescricao(consoleDesc.getText());
        Double prec = Double.parseDouble(consolePre.getText());
        con.setPreco(BigDecimal.valueOf(prec));
        con.setNome(consoleMod.getText());
        con.setMarca(consoleMar.getText());
        con.setCor(consoleCor.getText());
        con.setMemoria(consoleMem.getText());
        con.setCtrls(Integer.parseInt(consoleCtr.getText()));
        con.setEstq(Integer.parseInt(consoleEst.getText()));
        controlC.modConsole(con);
        consoleDesc.setText(null);
        consolePre.setText(null);
        consoleMod.setText(null);
        consoleMar.setText(null);
        consoleCor.setText(null);
        consoleMem.setText(null);
        consoleCtr.setText(null);
        consoleId.setText(null);
        consoleEst.setText(null);
    }

    public void excluirC(){
        con.setId(Integer.parseInt(consoleId.getText()));
        controlC.excConsole(con);
        consoleDesc.setText(null);
        consolePre.setText(null);
        consoleMod.setText(null);
        consoleMar.setText(null);
        consoleCor.setText(null);
        consoleMem.setText(null);
        consoleCtr.setText(null);
        consoleId.setText(null);
        consoleEst.setText(null);
    }
    //fisicos
    public void encontrarF(){
        conex.conexao();
        try{
            conex.executa("select * from produto NATURAL JOIN jogo NATURAL JOIN jogofisico where prodid='" +fisicoId.getText()+"'");
            conex.rs.first();
            fisicoTit.setText(conex.rs.getString("nome"));
            Double pre = conex.rs.getBigDecimal("preço").doubleValue();
            fisicoPre.setText(String.valueOf(pre));
            fisicoDesc.setText(conex.rs.getString("descrição"));
            fisicoPro.setText(conex.rs.getString("produtora"));
            fisicoGen.setText(conex.rs.getString("genero"));
            fisicoIdi.setText(conex.rs.getString("idioma"));
            fisicoPla.setText(conex.rs.getString("plataforma"));
            fisicoAno.setText(String.valueOf(conex.rs.getInt("anolançamento")));
            fisicoEst.setText(String.valueOf(conex.rs.getInt("qtdestoque")));

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }
    public void modificarF(){
        jf.setId(Integer.parseInt(fisicoId.getText()));
        jf.setDescricao(fisicoDesc.getText());
        Double prec = Double.parseDouble(fisicoPre.getText());
        jf.setPreco(BigDecimal.valueOf(prec));
        jf.setNome(fisicoTit.getText());
        jf.setProdutora(fisicoPro.getText());
        jf.setGenero(fisicoGen.getText());
        jf.setPlataforma(fisicoPla.getText());
        jf.setIdioma(fisicoIdi.getText());
        jf.setAnolancamento(Integer.parseInt(fisicoAno.getText()));
        jf.setEstq(Integer.parseInt(fisicoEst.getText()));
        controlF.modJogoF(jf);
        fisicoDesc.setText(null);
        fisicoId.setText(null);
        fisicoPre.setText(null);
        fisicoTit.setText(null);
        fisicoPro.setText(null);
        fisicoGen.setText(null);
        fisicoPla.setText(null);
        fisicoIdi.setText(null);
        fisicoAno.setText(null);
        fisicoEst.setText(null);
    }

    public void excluirF(){
        jf.setId(Integer.parseInt(fisicoId.getText()));
        controlF.excJogoF(jf);
        fisicoDesc.setText(null);
        fisicoId.setText(null);
        fisicoPre.setText(null);
        fisicoTit.setText(null);
        fisicoPro.setText(null);
        fisicoGen.setText(null);
        fisicoPla.setText(null);
        fisicoIdi.setText(null);
        fisicoAno.setText(null);
        fisicoEst.setText(null);
    }
    //digitais
    public void encontrarD(){
        conex.conexao();
        try{
            conex.executa("select * from produto NATURAL JOIN jogo NATURAL JOIN jogodigital where prodid='" +digitalId.getText()+"'");
            conex.rs.first();
            digitalTit.setText(conex.rs.getString("nome"));
            Double pre = conex.rs.getBigDecimal("preço").doubleValue();
            digitalPre.setText(String.valueOf(pre));
            digitalDesc.setText(conex.rs.getString("descrição"));
            digitalPro.setText(conex.rs.getString("produtora"));
            digitalGen.setText(conex.rs.getString("genero"));
            digitalIdi.setText(conex.rs.getString("idioma"));
            digitalPla.setText(conex.rs.getString("plataforma"));
            digitalAno.setText(String.valueOf(conex.rs.getInt("anolançamento")));
            digitalTam.setText(String.valueOf(conex.rs.getInt("tamanho")));
            digitalKey.setText(conex.rs.getString("jogokey"));
            digitalIns.setText(conex.rs.getString("download"));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"erro ao buscar os dados\nerro:"+ex);
        }
        conex.desconnect();
    }

    public void modificarD(){
        jd.setId(Integer.parseInt(digitalId.getText()));
        jd.setDescricao(digitalDesc.getText());
        Double prec = Double.parseDouble(digitalPre.getText());
        jd.setPreco(BigDecimal.valueOf(prec));
        jd.setNome(digitalTit.getText());
        jd.setProdutora(digitalPro.getText());
        jd.setGenero(digitalGen.getText());
        jd.setPlataforma(digitalPla.getText());
        jd.setIdioma(digitalIdi.getText());
        jd.setAnolancamento(Integer.parseInt(digitalAno.getText()));
        jd.setTamanho(Double.parseDouble(digitalTam.getText()));
        jd.setKey(digitalKey.getText());
        jd.setInstrucoes(digitalIns.getText());
        controlD.modJogoD(jd);
        digitalDesc.setText(null);
        digitalId.setText(null);
        digitalPre.setText(null);
        digitalTit.setText(null);
        digitalPro.setText(null);
        digitalGen.setText(null);
        digitalPla.setText(null);
        digitalIdi.setText(null);
        digitalAno.setText(null);
        digitalTam.setText(null);
        digitalKey.setText(null);
        digitalIns.setText(null);
    }

    public void excluirD(){
        jd.setId(Integer.parseInt(digitalId.getText()));
        controlD.excJogoD(jd);
        digitalDesc.setText(null);
        digitalId.setText(null);
        digitalPre.setText(null);
        digitalTit.setText(null);
        digitalPro.setText(null);
        digitalGen.setText(null);
        digitalPla.setText(null);
        digitalIdi.setText(null);
        digitalAno.setText(null);
        digitalTam.setText(null);
        digitalKey.setText(null);
        digitalIns.setText(null);
    }
}