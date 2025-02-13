package abbonato;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface AbbonatoEJBRemote {
    void aggiungiAbbonato (Abbonato a);
    void rimuoviAbbonato (Abbonato a);
    void aggiornaAbbonato (Abbonato a); //cambiato in void
    
    Abbonato cercaPerId (int id); //aggiunta mancanza del parametro
    List<Abbonato> cercaValido();
    List<Abbonato> cercaTutti();
    List<Abbonato> cercaNonScaduti();
    List<Abbonato> cercaValidoNonScadutoPremium();
}
