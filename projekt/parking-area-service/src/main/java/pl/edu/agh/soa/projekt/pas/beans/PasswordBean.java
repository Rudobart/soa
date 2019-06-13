package pl.edu.agh.soa.projekt.pas.beans;

import pl.edu.agh.soa.projekt.pas.service.user.UserService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PasswordBean {
    @EJB
    private UserService userService;

    private String username = SecurityUtils
            .getLoggedUser()
            .orElseThrow(IllegalStateException::new)
            .getUsername();
    private String newPassword;
    private String newPasswordConfirmed;
    private String message;

    public void changePassword() {
        if (!newPassword.equals(newPasswordConfirmed)) {
            message = "Hasła różnią się od siebie";
            return;
        }

        try {
            userService.changePassword(username, newPassword);
            SecurityUtils.redirect("index.xhtml");
        } catch (Exception e) {
            message = "Coś poszło nie tak";
        }
    }

    public boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    public boolean isAdmin() {
        return SecurityUtils.isAdmin();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirmed() {
        return newPasswordConfirmed;
    }

    public void setNewPasswordConfirmed(String newPasswordConfirmed) {
        this.newPasswordConfirmed = newPasswordConfirmed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
