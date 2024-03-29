package pl.edu.agh.soa.projekt.pas.beans;

import pl.edu.agh.soa.projekt.pas.exception.InvalidCredentialsException;
import pl.edu.agh.soa.projekt.pas.exception.SessionAlreadyExistsException;
import pl.edu.agh.soa.projekt.pas.service.security.SecurityService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SecurityBean {

    @EJB
    private SecurityService securityService;

    private String username;
    private String password;
    private String message;
    private boolean invalidateSessionLink = false;

    public void login() {
        try {
            securityService.login(username, password);
            SecurityUtils.redirect("index.xhtml");
        } catch (InvalidCredentialsException e) {
            message = e.getMessage();
        } catch (SessionAlreadyExistsException e) {
            message = e.getMessage();
            invalidateSessionLink = true;
        }
    }

    public void logout() {
        securityService.logout();
        SecurityUtils.redirect("login.xhtml");
    }

    public void redirectPassword() {
        SecurityUtils.redirect("password.xhtml");
    }


    public void invalidateSession(String username) {
        securityService.invalidateSession(username);
        invalidateSessionLink = false;
        message = null;
        SecurityUtils.redirect("login.xhtml");
    }

    public boolean isAuthenticated() {
        return SecurityUtils.getLoggedUser().isPresent();
    }

    public boolean isAdmin() {
        return SecurityUtils.isAdmin();
    }

    public boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isInvalidateSessionLink() {
        return invalidateSessionLink;
    }

    public void setInvalidateSessionLink(boolean invalidateSessionLink) {
        this.invalidateSessionLink = invalidateSessionLink;
    }
}
