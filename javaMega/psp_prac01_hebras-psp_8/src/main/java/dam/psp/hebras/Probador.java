package dam.psp.hebras;

import java.util.ArrayList;
import java.util.List;

public class Probador {

	private static final int NUM_FIESTEROS = 50;
	private static final int AFORO = 100;
	private static final int NUM_DIGITOS = 3;

	public static void main(String[] args) {
		PuertaDisco pd = new PuertaDisco(AFORO);
		List<Fiestero> fiesteros = new ArrayList<>();
		for (int i = 0; i < NUM_FIESTEROS; i ++) {
			Fiestero f = new Fiestero(pd, generaDni(i));
			fiesteros.add(f);
			f.start();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// ignorada
			}
		}
		for (Fiestero f: fiesteros) {
			try {
				f.join();
			} catch (InterruptedException e) {
				// ignorada
			}
		}
	}

	private static String generaDni(int num) {
		String dni = "";
		for (int i = 0; i < NUM_DIGITOS; i++) {
			dni += num;
		}
		return dni + (char) ('A' + (num % 26));
	}
}