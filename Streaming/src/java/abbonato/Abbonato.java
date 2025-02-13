package abbonato;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static abbonato.Abbonato.TROVA_NON_SCADUTO;
import static abbonato.Abbonato.TROVA_PER_ID;
import static abbonato.Abbonato.TROVA_TUTTI;
import static abbonato.Abbonato.TROVA_VALIDO;
import static abbonato.Abbonato.TROVA_VALIDO_NON_SCADUTO;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT a FROM Abbonato a WHERE a.id = :id"),
    @NamedQuery(name = TROVA_VALIDO, query = "SELECT a FROM Abbonato a WHERE a.stato = 'valido'"),
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT a FROM Abbonato a "),
    @NamedQuery(name = TROVA_NON_SCADUTO, query = "SELECT a FROM Abbonato a WHERE a.data_scadenza > :scadenza"),
    @NamedQuery(name = TROVA_VALIDO_NON_SCADUTO, query = "SELECT a FROM Abbonato a WHERE a.stato = 'valido' AND a.data_scadenza > :scadenza AND a.tipo_abbonamento = 'premium'")
})
@XmlRootElement
//cambiato AbbonatoEntity in Abbonato
public class Abbonato implements Serializable {
    
    public static final String TROVA_PER_ID = "abbonato.trovaPerId";
    public static final String TROVA_VALIDO = "abbonato.trovaValido";
    public static final String TROVA_TUTTI = "abbonato.trovaTutti";
    public static final String TROVA_NON_SCADUTO = "abbonato.trovaNonScaduto";
    public static final String TROVA_VALIDO_NON_SCADUTO = "abbonato.trovaValidoNonScaduto";

    @Id
    private int id;
    private String nome;
    private String cognome;
    private String tipo_abbonamento;
    private LocalDate data_scadenza; //sostituzione Date con LocalDate
    private String stato;

    public Abbonato() {
    }

    public Abbonato(int id, String nome, String cognome, String tipo_abbonamento, LocalDate data_scadenza, LocalDate data_caricamento, String stato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.tipo_abbonamento = tipo_abbonamento;
        this.data_scadenza = data_scadenza;
        if(data_scadenza.isBefore(data_caricamento))
            this.stato = "non valido";
        else
            this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTipo_abbonamento(String tipo_abbonamento) {
        this.tipo_abbonamento = tipo_abbonamento;
    }

    public void setData_scadenza(LocalDate data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipo_abbonamento() {
        return tipo_abbonamento;
    }

    public LocalDate getData_scadenza() {
        return data_scadenza;
    }

    public String getStato() {
        return stato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abbonato)) {
            return false;
        }
        Abbonato other = (Abbonato) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    /*
    @Override
    public String toString() {
        return "abbonato.Abbonato[ id=" + id + " ]";
    }
    */
    @Override
    public String toString() {
        return "Abbonato{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", cognome='" + cognome + '\'' +
               ", tipo_abbonamento='" + tipo_abbonamento + '\'' +
               ", data_scadenza=" + data_scadenza +
               ", stato='" + stato + '\'' +
               '}';
    }
}
