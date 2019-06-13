package pl.edu.agh.soa.projekt.mdnm;

import org.w3c.dom.Text;

import javax.annotation.ManagedBean;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.bean.SessionScoped;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;

@MessageDriven(
        name = "MobileDeviceNotifier",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/notification-queue")
        }
)

public class MobileDeviceNotifier implements MessageListener {

    TextMessage textMessage;
    Date date = new Date();



    public void onMessage(Message message) {
        textMessage = (TextMessage)message;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        date=new Date();
        try {
        MessageBean.message=formatter.format(date)+"\n"+textMessage.getText();
            System.out.println(formatter.format(date)+"\n"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
