package application.Model;


import java.util.Date;

public class Jogo extends Produto{
    protected String produtora;
    protected String genero;
    protected String plataforma;
    protected String idioma;
    protected Integer anolancamento;

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(Integer anolancamento) {
        this.anolancamento = anolancamento;
    }
}
