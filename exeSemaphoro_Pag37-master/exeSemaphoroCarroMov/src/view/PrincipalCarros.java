package view;

import java.util.concurrent.Semaphore;

import controller.carroMov;

public class PrincipalCarros {

	public static void main(String[] args) {
		int permissoes = 1;

		Semaphore semaforo = new Semaphore(permissoes);

		Thread Carro1 = new carroMov(1, semaforo, "Norte para Sul");
		Thread Carro2 = new carroMov(2, semaforo, "Sul para Norte");
		Thread Carro3 = new carroMov(3, semaforo, "Leste para Oeste");
		Thread Carro4 = new carroMov(4, semaforo, "Oeste para Leste");
		Carro1.start();
		Carro2.start();
		Carro3.start();
		Carro4.start();
	}
}