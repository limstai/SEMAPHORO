package controller;

import java.util.concurrent.Semaphore;

public class carroMov extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private String direcao;

	public carroMov(int idCarro, Semaphore semaforo, String direcao) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		this.direcao = direcao;
	}

	public void run() {
		try {
			semaforo.acquire();
			CarroAndando();
			Atravessou();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void CarroAndando() {
		int distanciaTotal = 5;
		int distancia = 0;
		int andando;

		while (distancia < distanciaTotal) {
			andando = (int) ((Math.random() * 3) + 1);
			distancia += andando;

			System.out.println("O carro #" + idCarro + " andou " + distancia + "m. de " + direcao);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void Atravessou() {
		System.out.println("O carro #" + idCarro + " atravessou de " + direcao);
	}

}
