package application.Controller;
/** exceção para testar se campo a ser preenchido pelo usuário está vazio*/
public class CampoNulloException extends RuntimeException{
    public CampoNulloException(String msg){
        super(msg);
    }
}
