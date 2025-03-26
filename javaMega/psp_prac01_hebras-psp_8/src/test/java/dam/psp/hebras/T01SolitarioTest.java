package dam.psp.hebras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T01SolitarioTest {
	private static final String N = System.lineSeparator(); // salto de línea del sistema

	@Test
	void test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		PuertaDisco pd = new PuertaDisco(5);

		Fiestero f = new Fiestero(pd, "234B");
		f.start();

		try {
			f.join();
		} catch (InterruptedException e) {
			// ignorada
		}

		String[] salidas = bos.toString().split(N);
		assertEquals(16, salidas.length);
		assertEquals("234B FUERA\tEntrando\taforo: 0", salidas[0]);
		assertEquals("\tDentro: []", salidas[1]);
		assertEquals("\tCola entrada: []", salidas[2]);
		assertEquals("\tCola salida: []", salidas[3]);
		assertEquals("234B ENTRANDO\tHa entrado\taforo: 1", salidas[4]);
		assertEquals("\tDentro: [234B]", salidas[5]);
		assertEquals("\tCola entrada: []", salidas[6]);
		assertEquals("\tCola salida: []", salidas[7]);
		assertEquals("234B BAILANDO\tSaliendo\taforo: 1", salidas[8]);
		assertEquals("\tDentro: [234B]", salidas[9]);
		assertEquals("\tCola entrada: []", salidas[10]);
		assertEquals("\tCola salida: []", salidas[11]);
		assertEquals("234B SALIENDO\tHa salido\taforo: 0", salidas[12]);
		assertEquals("\tDentro: []", salidas[13]);
		assertEquals("\tCola entrada: []", salidas[14]);
		assertEquals("\tCola salida: []", salidas[15]);

		System.setOut(originalOut);
	}
}
