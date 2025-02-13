package abbonato;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
@WebService
public class AbbonatoEJB implements AbbonatoEJBRemote {

    @Inject
    private EntityManager em;
    
    @Override
    public void aggiungiAbbonato(Abbonato a) {
        em.persist(a);
    }

    @Override
    public void rimuoviAbbonato(Abbonato a) {
        em.remove(em.merge(a));
    }

    @Override //cambiato da Abbonato in void
    public void aggiornaAbbonato(Abbonato a) {
        em.merge(a);
    }

    @Override
    public Abbonato cercaPerId(int id) {
        TypedQuery<Abbonato> q = em.createNamedQuery(Abbonato.TROVA_PER_ID, Abbonato.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public List<Abbonato> cercaValido() {
        TypedQuery<Abbonato> q = em.createNamedQuery(Abbonato.TROVA_VALIDO, Abbonato.class);
        return q.getResultList();
    }

    @Override
    public List<Abbonato> cercaTutti() {
        TypedQuery<Abbonato> q = em.createNamedQuery(Abbonato.TROVA_TUTTI , Abbonato.class);
        return q.getResultList();    
    }

    @Override
    public List<Abbonato> cercaNonScaduti() {
        TypedQuery<Abbonato> q = em.createNamedQuery(Abbonato.TROVA_NON_SCADUTO , Abbonato.class);
        LocalDate data = LocalDate.now(); //aggiunto l'accquisizione dell'ora corrente
        q.setParameter("scadenza", data);
        return q.getResultList();
    }

    @Override
    public List<Abbonato> cercaValidoNonScadutoPremium() {
        TypedQuery<Abbonato> q = em.createNamedQuery(Abbonato.TROVA_VALIDO_NON_SCADUTO , Abbonato.class);
        LocalDate data = LocalDate.now(); //aggiunto l'accquisizione dell'ora corrente
        q.setParameter("scadenza", data);
        return q.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
