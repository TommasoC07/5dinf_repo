
/**
 * Classe con il main, che avvia l'app
 * che rappresenta il flusso dei clienti di un ufficio postale
 * messi in attesa da un totem elettronico che assegna
 * un numero progressivo e stampa il ticket.
 * Clienti gestiti da un solo sportello
 * @author frida
 * @version 1.0
 */
public class SimulatorePoste {
    public static void main(String[] args) {
        ListaClienti listaClienti = new ListaClienti();
        Thread arriviThread = new Thread(new GestoreArrivi(listaClienti, "Totem 1"));
        Thread arriviThread2 = new Thread(new GestoreArrivi(listaClienti, "Totem 2"));
        Thread sportelloThread = new Thread(new Sportello(listaClienti, "Marzia"));
        Thread sportelloThread2 = new Thread(new Sportello(listaClienti, "Cinzia"));

        arriviThread.start();
        arriviThread2.start();
        sportelloThread.start();
        sportelloThread2.start();

    }
}
