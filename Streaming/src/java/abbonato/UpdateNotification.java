package abbonato;

import javax.enterprise.event.Observes;

public class UpdateNotification {
    public void notify (@Observes Abbonato a)
    {
        System.out.println(a.getId() + ":Abbonamento rinnovato!"); //completato la stampa
    }
}
