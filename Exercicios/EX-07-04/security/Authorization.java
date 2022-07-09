package security;
import validation.*;

public class Authorization implements IAuthorization {
    private int codigo, incAttempts = 0;
    private String password;

    public Authorization(int c, String p) {
        codigo = c;
        password = p;
    }
    
    public int getCode() {
        return codigo;
    }
    public String getPsw() {
        return password;
    }
    public void incorrectAttempts() {
        incAttempts++;
    }
    public int getNumberIncorrectAttempts() {
        return incAttempts;
    }
}