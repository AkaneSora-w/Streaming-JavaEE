package abbonato;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class AbbonatoMDB implements MessageListener {
    @Inject
    private AbbonatoEJB ejb;
    
    @Inject
    Event<Abbonato> event;
    
    @Inject @InserimentoQualifier //aggiunto evento per qualifier
    Event<Abbonato> inserimentoEvent;
    
    public AbbonatoMDB() {
    }
    
    @Override
    public void onMessage(Message msg) { //corretto in void
        try{
            MessageWrapper wrapper = msg.getBody(MessageWrapper.class);
            //aggiunto logica di business mancata
            int id = wrapper.getId();
            Abbonato a = ejb.cercaPerId(id);
            if(a != null)
            {
                a.setData_scadenza(wrapper.getScadenza());
                ejb.aggiornaAbbonato(a);
                event.fire(a);
            }
            else
            {
                a = new Abbonato();
                a.setId(id);
                a.setNome(wrapper.getNome());
                a.setCognome(wrapper.getCognome());
                a.setTipo_abbonamento(wrapper.getTipo());
                a.setData_scadenza(wrapper.getScadenza());
                a.setStato(wrapper.getStato());
                ejb.aggiungiAbbonato(a);
                inserimentoEvent.fire(a);
            }
            
        } catch (JMSException ex) { //aggiunto il catch mancata
            Logger.getLogger(AbbonatoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
