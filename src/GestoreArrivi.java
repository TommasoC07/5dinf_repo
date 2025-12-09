import java.time.LocalTime;
import java.time.Duration;
/**
 * Classe che implementa il thread per il totem touch screen che aggiunge
 * i clienti alla lista di attesa e genera il numero di attesa.
 * rappresenta il produttore
 * @author frida
 * @version 1.0
 */
public class GestoreArrivi implements Runnable {

    /* variabili d'istanza sono;
     * la risorsa condivisa listaClienti */
    private ListaClienti listaClienti;
    /* ms fra un arrivo e l'altro */
    private final int attesaArrivi = 200;
    private String nome;
    private LocalTime time1;
    /**
     * constructor
     * @param listaClienti
     */
    public GestoreArrivi(ListaClienti listaClienti, String nome) {
        this.listaClienti = listaClienti;
        this.nome = nome;
    }
    /**
     * TODO: cosa fa?
     * @see Runnable
     */
    public void run() {
        try {
            time1 = LocalTime.now();
            System.out.println("Apertura posta\nOrario: " + time1);
            while (!Thread.interrupted()) {
                Thread.sleep(attesaArrivi);
                Integer clienteArrivato = listaClienti.addCliente(nome);
                if (clienteArrivato == null) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Posta Chiusa");
            LocalTime endtime = LocalTime.now();
            System.out.println("Chiusura posta\nOrario: " + endtime);
            Duration duration = Duration.between(time1, endtime);
            System.out.println("La posta è stata aperta: " + duration);
        }
    }
}
