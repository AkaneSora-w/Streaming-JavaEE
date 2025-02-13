package abbonato;

import javax.enterprise.event.Observes;

public class InserimentoNotification {
    public void norify (@Observes @InserimentoQualifier Abbonato a)
    {
        System.out.println(a.getId() + ": Inserimento abbonamento " + 
                a.getNome() + " " + a.getCognome() + " di tipo " + 
                a.getTipo_abbonamento());
    }
}
