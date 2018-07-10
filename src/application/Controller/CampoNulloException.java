package application.Controller;

public class CampoNulloException extends RuntimeException{
    /** exceção para testar se campo a ser preenchido pelo usuário está vazio*/
    public CampoNulloException(String msg){
        super(msg);
    }
}
