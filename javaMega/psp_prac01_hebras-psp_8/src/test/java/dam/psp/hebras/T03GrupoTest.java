package dam.psp.hebras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class T03GrupoTest {
	private static final int NUM_FIESTEROS = 5;
	private static final int AFORO = NUM_FIESTEROS;
	private static final int NUM_DIGITOS = 3;

	private static final String N = System.lineSeparator(); // salto de línea del sistema

	@Test
	void test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		PuertaDisco pd = new PuertaDisco(AFORO);
		List<Fiestero> fiesteros = new ArrayList<>();
		for (int i = 0; i < NUM_FIESTEROS; i++) {
			Fiestero f = new Fiestero(pd, generaDni(i));
			assertEquals(f.getDni() + " FUERA", f.toString());
			fiesteros.add(f);
			f.start();
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				// ignorada
			}
		}

		for (Fiestero f : fiesteros) {
			try {
				f.join();
				assertEquals(f.getDni() + " FUERA", f.toString());
			} catch (InterruptedException e) {
				// ignorada
			}
		}

		String salida = bos.toString();
		String[] salidas = salida.split(N);
		assertEquals(16 * NUM_FIESTEROS, salidas.length);
		for (int i = 0; i < NUM_FIESTEROS; i++) {
			String dniI = generaDni(i);
			assertTrue(salida.contains(dniI + " FUERA\tEntrando"));
			assertTrue(salida.contains(dniI + " ENTRANDO\tHa entrado"));
			assertTrue(salida.contains(dniI + " BAILANDO\tSaliendo"));
			assertTrue(salida.contains(dniI + " SALIENDO\tHa salido"));
		}
		assertFalse(salida.contains("aforo: " + (AFORO + 1)));

		System.setOut(originalOut);
	}

	private static String generaDni(int num) {
		String dni = "";
		for (int i = 0; i < NUM_DIGITOS; i++) {
			dni += num;
		}
		return dni + (char) ('A' + (num % 26));
	}
}
