package usermangement;

import dao.AccessUser;
import model.User;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.io.Serializable;
import java.util.Set;

@ManagedBean(name = "registerBean")
@SessionScoped
public class RegisterBean implements Serializable {

    @Inject
    AccessUser accessUser;

    @Inject
    IPasswordHashing hashing;

    private String email;
    private String password;
    private String reppassword;
    private String name;
    private String status;
    private String statusColor = "alert-danger";

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReppassword() {
        return reppassword;
    }

    public void setReppassword(String reppassword) {
        this.reppassword = reppassword;
    }

    public void register() {
        User userEntity = new User();
        userEntity.setEmail(email);
        userEntity.setName(name);
        if (password.isEmpty() || reppassword.isEmpty() || email.isEmpty() ||name.isEmpty()) {
            status = "Please fill out every form";

        } else if (password.equals(reppassword)) {
            password = hashing.hash(password);
            userEntity.setPassword(password);

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<User>> validation = validator.validate(userEntity);

            if (!validation.isEmpty()) {
                status = "Use a valid Email!";

            } else {
                try {
                    accessUser.register(userEntity);
                    status = "Succesfully registered";
                    statusColor = "alert-success";
                } catch (Exception e) {
                    System.out.println(e.toString());
                    status = "Something went wrong saving your data!";
                }
            }
        } else {
            status = "The passwords dont match!";
        }
    }

}
