package pl.edu.agh.soa.projekt.mdnm;


import javax.faces.bean.ManagedBean;

@ManagedBean(name = "MessageBean")
public class MessageBean {

    public static String message;

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }


}
