package application.Controller;

import application.MController.ControllerConsole;
import application.MController.ControllerJogo;
import application.MController.ControllerJogoF;
import application.Model.Console;
import application.Model.Jogo;
import application.Model.JogoDigital;
import application.Model.JogoFisico;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.math.BigDecimal;

public class ControllerAddItem extends ControllerMaster{
    public Pane consolePane;
    public Pane fisicoPane;
    public Pane digitalPane;
    public Pane jogoPane;

    //console
    public TextField consolePre;
    public TextField consoleMar;
    public TextField consoleMod;
    public TextField consoleCor;
    public TextField consoleMem;
    public TextField consoleCtr;
    public TextField consoleEst;
    public TextArea consoleDesc;
    //jogo
    public TextField jogoPre;
    public TextField jogoTit;
    public TextField jogoPro;
    public TextField jogoGen;
    public TextField jogoPla;
    public TextField jogoIdi;
    public TextField jogoAno;
    public TextArea jogoDesc;
    //fisico
    public TextField fisicoEst;
    //digital
    public TextField digitalTam;
    public TextArea digitalIns;
    public TextField digitalKey;

    private Integer helper = 0;

    Console con = new Console();
    ControllerConsole controlC = new ControllerConsole();
    Jogo j = new Jogo();
    JogoFisico jf = new JogoFisico();
    JogoDigital jd = new JogoDigital();
    ControllerJogo controlJ = new ControllerJogo();

    public void showConsole(){
        fisicoPane.setVisible(false);
        digitalPane.setVisible(false);
        jogoPane.setVisible(false);
        consolePane.setVisible(true);
    }
    public void showJogo(){
        consolePane.setVisible(false);
        jogoPane.setVisible(true);
    }
    public void showAmbos(){
        digitalPane.setVisible(true);
        fisicoPane.setVisible(true);
        helper = 3;
    }
    public void showFisico(){
        digitalPane.setVisible(false);
        fisicoPane.setVisible(true);
        helper = 1;
    }
    public void showDigital(){
        fisicoPane.setVisible(false);
        digitalPane.setVisible(true);
        helper = 2;
    }

    public void adicionarC(){
        con.setDescricao(consoleDesc.getText());
        Double prec = Double.parseDouble(consolePre.getText());
        con.setPreco(BigDecimal.valueOf(prec));
        con.setNome(consoleMod.getText());
        con.setMarca(consoleMar.getText());
        con.setCor(consoleCor.getText());
        con.setMemoria(consoleMem.getText());
        con.setCtrls(Integer.parseInt(consoleCtr.getText()));
        con.setEstq(Integer.parseInt(consoleEst.getText()));
        controlC.addConsole(con);
        consoleDesc.setText(null);
        consolePre.setText(null);
        consoleMod.setText(null);
        consoleMar.setText(null);
        consoleCor.setText(null);
        consoleMem.setText(null);
        consoleCtr.setText(null);
        consoleEst.setText(null);
    }

    public void adicionarJ(){
        j.setDescricao(jogoDesc.getText());
        Double prec = Double.parseDouble(jogoPre.getText());
        j.setPreco(BigDecimal.valueOf(prec));
        j.setNome(jogoTit.getText());
        j.setProdutora(jogoPro.getText());
        j.setGenero(jogoGen.getText());
        j.setPlataforma(jogoPla.getText());
        j.setIdioma(jogoIdi.getText());
        j.setAnolancamento(Integer.parseInt(jogoAno.getText()));
        jogoDesc.setText(null);
        jogoPre.setText(null);
        jogoTit.setText(null);
        jogoPro.setText(null);
        jogoGen.setText(null);
        jogoPla.setText(null);
        jogoIdi.setText(null);
        jogoAno.setText(null);
        if(helper == 1){
            jf.setEstq(Integer.parseInt(fisicoEst.getText()));
            fisicoEst.setText(null);
            controlJ.addJogo(j,jf);
        }
        else if(helper == 2){
            jd.setTamanho(Double.parseDouble(digitalTam.getText()));
            jd.setInstrucoes(digitalIns.getText());
            jd.setKey(digitalKey.getText());
            digitalTam.setText(null);
            digitalIns.setText(null);
            digitalKey.setText(null);
            controlJ.addJogo(j,jd);
        }
        else if(helper == 3){
            jd.setTamanho(Double.parseDouble(digitalTam.getText()));
            jd.setInstrucoes(digitalIns.getText());
            jd.setKey(digitalKey.getText());
            jf.setEstq(Integer.parseInt(fisicoEst.getText()));
            fisicoEst.setText(null);
            digitalTam.setText(null);
            digitalIns.setText(null);
            digitalKey.setText(null);
            controlJ.addJogo(j,jf,jd);
        }
    }

}
