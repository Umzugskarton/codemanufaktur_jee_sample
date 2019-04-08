package usermangement;

import java.io.Serializable;

public interface IPasswordHashing extends Serializable {
    String hash(String passwd);

    boolean checkPasswd(String encrypted, String decrypted);
}
