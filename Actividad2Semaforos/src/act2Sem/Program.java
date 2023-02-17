package act2Sem;

public class Program {

	public static void controlHilos(int n, int k) {
		Recurso controlRecursos = new Recurso(k);// Objeto Recurso
		Thread[] hilos = new Thread[n];// Array de Hilos

		for (int i = 0; i < n; i++) {// Recorremos el número n de hilos
			final int hilo = i + 1;
			hilos[i] = new Thread(() -> {// Un hilo por cada vuelta
				try {

					int r = (int) (Math.random() * k + 1);
					controlRecursos.reserva(r);// Se reserva un numero aleatorio de recursos

					System.out.println("Hilo " + hilo + " >> Reserva: " + r + " recursos.");
					Thread.sleep(1000);// le damos tiempo entre la reserva y la liberacion de los recursos

					controlRecursos.libera(r);// Aplicamos el método libera

					System.out.println("Hilo " + hilo + " >> Libera: " + r + " recursos.");

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		for (Thread t : hilos) {// Iniciamos cada hilo
			t.start();
		}
	}

	public static void main(String[] args) {// Asignamos 5 hilos de prueba y un solo recurso
		int hilos = 5;
		System.out.println("Numero de hilos = " + hilos);
		int rec = 1;
		System.out.println("Numero de recursos = " + rec);
		controlHilos(hilos, rec);// Se llama a la funcion para empezar el programa
	}
}