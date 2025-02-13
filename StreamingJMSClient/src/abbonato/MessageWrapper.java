package abbonato;

import java.io.Serializable;
import java.time.LocalDate;

public class MessageWrapper implements Serializable{
    private int id;
    private String nome;
    private String cognome;
    private String tipo;
    private LocalDate scadenza;
    private String stato;

    public MessageWrapper(int id, String nome, String cognome, String tipo, LocalDate scadenza, String stato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.tipo = tipo;
        this.scadenza = scadenza;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public String getStato() {
        return stato;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    
}
