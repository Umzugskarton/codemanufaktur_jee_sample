package usermangement;

import dao.AccessUser;
import model.User;
import utils.SessionUtils;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    @Inject
    AccessUser accessUser;

    private String password;
    private String email;
    private String status;

    private String statusColor = "alert-danger";

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void login() {
        Optional<User> user = accessUser.loginByEmail(email, password);
        if (user.isPresent()) {
            SessionUtils.getSessionMap().put("user", user.get());
            status = "Logged in!";
            statusColor = "alert-success";
        } else {
            status = "Username or Password wrong.";
        }
    }

    public void logout(){
        SessionUtils.getSessionMap().remove("user");
    }




}
