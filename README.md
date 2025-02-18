Traccia dell'esame

a) Scrivere un insieme di server Enterprise JavaBeans e un client che rappresenti gli abbonati di un servizio di streaming. Per ogni abbonato, una entità dovrà raccogliere le informazioni su ID (int), nome (stringa), cognome (string), tipo abbonamento (enum o stringa contenente "normale", "studente" oppure "premium"), data scadenza abbonamento (data), data di caricamento dati (data), stato (enum o stringa contenente "valido", "non valido" oppure "sospeso").

Tramite JPA, si deve gestire la persistenza degli abbonati su DB (EsameDB), dove la chiave primaria è la ID
  1. devono essere previste una query per ottenere tutti gli abbonati validi, ed una query che restituisca tutte le entity del database;
  2. deve essere previsto un bean Singleton che inizializzi l'archivio;
  3. scrivere un client basato su invocazione di bean stateless che preveda la stampa di:
     1. Tutti gli abbonati con abbonamento non scaduto (in riferimento alla data di scadenza);
     2. Tutti gli abbonati con abbonamento valido, non scaduto e di tipo premium;
Dati di esempio DB:

| ID | Nome | Cognome | Tipo | Scadenza | Stato |
|-----------|-----------|-----------|-----------|-----------|-----------|
| 1  | Leonardo | Rossi    | normale  | 30 01 2025 | sospeso    |
| 2  | Sofia    | Ferrari  | premium  | 30 01 2025 | valido     |
| 3  | Tommaso  | Esposito | studente | 30 01 2025 | valido     |
| 4  | Aurora   | Bianchi  | premium  | 30 01 2024 | non valido |

b)  Scrivere un client basato su messaggi e la corrispondente parte lato server che invii un messaggio per inserire un nuovo abbonato o aggiornare lo stato di uno esistente. Quando viene effettuato questo inserimento, viene stampato sulla console del server un messaggio di avviso "DATA_INSERIMENTO: Inserimento abbonamento NOME COGNOME di tipo TIPO" (nota: sostituire le parole in maiuscolo con il valore corrispondente). Se viene inserita una abbonamento già esistente in archivio, la cui scadenza è stata aggiornata (rinnovo), tramite un evento verrà stampato il messaggio "abbonamento rinnovato!".

c) Rendendo i metodi del bean invocabili come Web Services, scrivere un cliente che stampi tutti gli abbonamenti non scaduti.

Nota:
  1. Il DataSource deve chiamarsi: jdbc/EsameDS;
  2. PersistenceUnit e DB devono chiamarsi rispettivamente EsamePU ed EsameDB;
  3. Il DatabasePopulator deve prevedere la database definition;
  4. La ConnectionFactory deve chiamarsi: jms/javaee7/ConnectionFactory;
  5. Il topic deve chiamarsi: jms/javaee7/Topic.
Ordine scrittura del progetto:
  1. Entità, Interfacce, EJB, Client EJB;
  2. JMS: MDB e Client;
  3. Web Services: Server, Client
