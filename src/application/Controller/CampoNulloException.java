package application.Controller;

public class CampoNulloException extends RuntimeException{
    /** exceção para testar se campo a ser preenchido pelo usuário está vazio
     * @param msg mensagem de erro*/
    public CampoNulloException(String msg){
        super(msg);
    }
}
