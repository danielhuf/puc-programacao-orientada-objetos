package validation;
import security.*;

public class Checker {
    public boolean check(int cod,String psw) {
        IAuthorization a = DBAuthorization.getAuthorization(cod);

        if (a != null) {
            if (a.getPsw().compareTo(psw) == 0) {  //método para comparar strings!
                if (a.getNumberIncorrectAttempts() < 3) {
                    return true;
                }
            }
            else
                a.incorrectAttempts();
        }
        return false;
    }
}
