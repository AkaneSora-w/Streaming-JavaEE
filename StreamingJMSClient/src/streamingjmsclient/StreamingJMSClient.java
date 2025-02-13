package streamingjmsclient;

import abbonato.MessageWrapper;
import java.time.LocalDate;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StreamingJMSClient {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        //aggiunto il casto per connection factory e destination
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination de = (Destination) ctx.lookup("jms/javaee7/Topic");
        //completato wrapper
        MessageWrapper wrapper = new MessageWrapper(4, "Aurora", "Bianchi", "premium", LocalDate.parse("2025-01-30"), "valido");
        
        try(JMSContext jmsContext = cf.createContext())
        {
            jmsContext.createProducer().send(de, wrapper);
        }
    }
    
}
