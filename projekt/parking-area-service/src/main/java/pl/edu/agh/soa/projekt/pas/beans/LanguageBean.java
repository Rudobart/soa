package pl.edu.agh.soa.projekt.pas.beans;

import pl.edu.agh.soa.projekt.pas.model.Language;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import lombok.*;

import java.io.IOException;

@ManagedBean
@SessionScoped
public class LanguageBean {

    @Getter
    Language language = Language.POLISH;


    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isPolish(){
        return language==Language.POLISH;
    }
    public void changeLanguage() throws IOException{
        if(language==Language.POLISH)
            language=Language.ENGLISH;
        else if(language==language.ENGLISH)
            language=Language.POLISH;
        reload();

    }

    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());

    }

}
