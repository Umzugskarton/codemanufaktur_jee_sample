package usermangement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class PasswordHashing implements IPasswordHashing, Serializable {
    @Override
    public String hash(String passwd) {
        return new BCryptPasswordEncoder().encode(passwd);
    }

    @Override
    public boolean checkPasswd(String encrypted, String decrypted) {
        return new BCryptPasswordEncoder().matches(decrypted, encrypted);
    }
}
