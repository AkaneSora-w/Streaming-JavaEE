package abbonato;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(
   className = "org.apache.derby.jdbc.EmbeddedDataSource",
   name = "java:global/jdbc/EsameDS",
   user = "ok", password = "ok",
   databaseName = "EsameDB",
   properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    
    @Inject
    private AbbonatoEJB ejb;
    private Abbonato a1, a2, a3, a4;
    
    @PostConstruct
    private void populateDB() //cambio public in private
    {   //completato l'inserimento dei dati
        a1 = new Abbonato(1, "Leonardo", "Rossi", "normale", LocalDate.parse("2025-01-30"), LocalDate.now(), "sospeso");
        a2 = new Abbonato(2, "Sofia", "Ferrari", "premium", LocalDate.parse("2025-01-30"), LocalDate.now(), "valido");
        a3 = new Abbonato(3, "Tommaso", "Esposito", "studente", LocalDate.parse("2025-01-30"), LocalDate.now(), "valido");
        a4 = new Abbonato(4, "Aurora", "Bianchi", "premium", LocalDate.parse("2024-01-30"), LocalDate.now(), "non valido");
        
        ejb.aggiungiAbbonato(a1);
        ejb.aggiungiAbbonato(a2);
        ejb.aggiungiAbbonato(a3);
        ejb.aggiungiAbbonato(a4);
    }
    
    @PreDestroy
    private void clearDB() //cambio public in private
    {
        ejb.rimuoviAbbonato(a1);
        ejb.rimuoviAbbonato(a2);
        ejb.rimuoviAbbonato(a3);
        ejb.rimuoviAbbonato(a4);
    }
}
