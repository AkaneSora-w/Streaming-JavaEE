package streamingstdclient;

import abbonato.Abbonato;
import abbonato.AbbonatoEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StreamingStdClient {
    
    private static AbbonatoEJBRemote ejb;

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        //aggiunta la stringa CHENJUNHUANG all'interno del lookup
        ejb = (AbbonatoEJBRemote) ctx.lookup("java:global/CHENJUNHUANGStreaming/AbbonatoEJB!abbonato.AbbonatoEJBRemote");
        
        System.out.println("Tutti abbonati con abbonamento non scaduto: ");
        List<Abbonato> abbonati = ejb.cercaNonScaduti(); //aggiunto ejb mancata davanti a cercaNonScaduti
        for (Abbonato a : abbonati) {
            System.out.println(a);
        }
        
        System.out.println("Tutti abbonati con abbonamento valido, non scaduto e premium: "); //agginta la stampa
        abbonati = ejb.cercaValidoNonScadutoPremium(); //aggiunto ejb mancata davanti a cercaValidoNonScadutoPremium
        for (Abbonato a : abbonati) {
            System.out.println(a);
        }
    }
    
}
