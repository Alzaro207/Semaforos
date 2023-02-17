package act2Sem;

import java.util.concurrent.Semaphore;

public class Recurso {
	private int recurso;// Variable recurso
	private Semaphore semaforo;// Semaforo que controlará los recursos

	public Recurso(int k) {
		this.recurso = k;

		semaforo = new Semaphore(k);// creamo un objeto semaforo
	}

	public void reserva(int r) {
		try {
			semaforo.acquire(r);// Reservamos los recursos llamando al semaforo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void libera(int l) {
		semaforo.release(l);// Liberamos los recursos llamando al semaforo

	}
}