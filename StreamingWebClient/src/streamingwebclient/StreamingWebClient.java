package streamingwebclient;

import abbonato.Abbonato;
import java.util.List;

public class StreamingWebClient {

    public static void main(String[] args) {
        System.out.println("Abbonati non scaduti: "); //aggiunta della stampa
        List<abbonato.Abbonato> abbonati = cercaNonScaduti(); //cambio AbbonatoEntity in abbonato.Abbonato
        for (Abbonato a : abbonati) {
            System.out.println(a);
        }
    }
    //aggiunto java.util e cambiato AbbonatoEJBRemote in abbonato.Abbonato
    private static java.util.List<abbonato.Abbonato> cercaNonScaduti() {
        abbonato.AbbonatoEJBService service = new abbonato.AbbonatoEJBService(); //aggiunto abbonato dopo new
        abbonato.AbbonatoEJB port = service.getAbbonatoEJBPort(); //correzione da service.AbbonatoEJB.getPort
        return port.cercaNonScaduti();
    }
    
}
