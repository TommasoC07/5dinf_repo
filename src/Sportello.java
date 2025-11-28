/**
 * Classe che implementa il thread Sportello,
 * che serve i clienti delle
 * poste che arrivano via via, ovvero è il thread
 * consumatore delle risorse condivise
 * listaNumeri, ultimoArrivo, ultimoServito
 * @author frida
 * @version 1.0
 */
public class Sportello implements Runnable {
    /**
     * risorsa condivise fra i due thread (ListaClienti)
     */
    private ListaClienti listaClienti;

    private final int minTempoServizio = 1000;
    private final int maxTempoServizio = 4000;
    private String nome;
    /**
     * constructor
     * @param listaClienti, String nome operatore
     */
    public Sportello(ListaClienti listaClienti, String nome) {
        this.listaClienti = listaClienti;
        this.nome = nome;
    }

    /**
     * TODO: cosa fa?
     * @see Runnable
     */
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Integer clienteServito = listaClienti.rimuoviCliente();
                //tempo di servizio variabile nel range [1,4] secondi
                int tempoServizio = (int) (Math.random() * (maxTempoServizio
                        - minTempoServizio + 1) + minTempoServizio);
                Thread.sleep(tempoServizio);
                //Thread.sleep(1000); //tempo di servizio fisso
                System.out.println("Servito Cliente Numero \t " + clienteServito+
                        " dallo sportello "+ nome);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Sportello Chiuso");
        }
    }
}