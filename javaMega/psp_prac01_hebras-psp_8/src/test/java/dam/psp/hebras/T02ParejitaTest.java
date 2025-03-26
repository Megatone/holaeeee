package dam.psp.hebras;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class T02ParejitaTest {
	private static final String N = System.lineSeparator(); // salto de línea del sistema

	@Test
	void test() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		PuertaDisco pd = new PuertaDisco(5);

		Fiestero f1 = new Fiestero(pd, "234B");
		f1.start();
		Fiestero f2 = new Fiestero(pd, "345C");
		f2.start();

		try {
			f1.join();
		} catch (InterruptedException e) {
			// ignorada
		}
		try {
			f2.join();
		} catch (InterruptedException e) {
			// ignorada
		}
		
		String[] salidas = bos.toString().split(N);
		assertEquals(32, salidas.length);
		assertTrue(salidas[0].equals("234B FUERA	Entrando	aforo: 0") || salidas[0].equals("345C FUERA	Entrando	aforo: 0"));
		assertEquals("	Dentro: []", salidas[1]);
		assertEquals("\tCola entrada: []", salidas[2]);
		assertEquals("\tCola salida: []", salidas[3]);
		assertTrue(salidas[4].equals("234B FUERA	Entrando	aforo: 1") || salidas[4].equals("345C FUERA	Entrando	aforo: 1"));
		assertTrue(salidas[5].equals("	Dentro: [234B]") || salidas[5].equals("	Dentro: [345C]"));
		assertEquals("\tCola entrada: []", salidas[6]);
		assertEquals("\tCola salida: []", salidas[7]);
		assertTrue(salidas[8].equals("234B ENTRANDO	Ha entrado	aforo: 2") || salidas[8].equals("345C ENTRANDO	Ha entrado	aforo: 2"));
		assertTrue(salidas[9].equals("	Dentro: [234B, 345C]") || salidas[9].equals("	Dentro: [345C, 234B]"));
		assertEquals("\tCola entrada: []", salidas[10]);
		assertEquals("\tCola salida: []", salidas[11]);
		assertTrue(salidas[12].equals("234B ENTRANDO	Ha entrado	aforo: 2") || salidas[12].equals("345C ENTRANDO	Ha entrado	aforo: 2"));
		assertTrue(salidas[13].equals("	Dentro: [234B, 345C]") || salidas[13].equals("	Dentro: [345C, 234B]"));
		assertEquals("\tCola entrada: []", salidas[14]);
		assertEquals("\tCola salida: []", salidas[15]);
		assertTrue(salidas[16].equals("234B BAILANDO	Saliendo	aforo: 2") || salidas[16].equals("345C BAILANDO	Saliendo	aforo: 2"));
		assertTrue(salidas[17].equals("	Dentro: [234B, 345C]") || salidas[17].equals("	Dentro: [345C, 234B]"));
		assertEquals("\tCola entrada: []", salidas[18]);
		assertEquals("\tCola salida: []", salidas[19]);
		assertTrue(salidas[20].equals("234B BAILANDO	Saliendo	aforo: 2") || salidas[20].equals("345C BAILANDO	Saliendo	aforo: 2") 
				|| salidas[20].equals("234B SALIENDO	Ha salido	aforo: 1") || salidas[20].equals("345C SALIENDO	Ha salido	aforo: 1"));
		assertTrue(salidas[21].equals("	Dentro: [234B]") || salidas[21].equals("	Dentro: [345C]"));
		assertEquals("\tCola entrada: []", salidas[22]);
		assertEquals("\tCola salida: []", salidas[23]);
		assertTrue(salidas[24].equals("234B BAILANDO	Saliendo	aforo: 1") || salidas[24].equals("345C BAILANDO	Saliendo	aforo: 1") 
				|| salidas[24].equals("234B SALIENDO	Ha salido	aforo: 1") || salidas[24].equals("345C SALIENDO	Ha salido	aforo: 1"));
		assertTrue(salidas[25].equals("	Dentro: []") || salidas[25].equals("	Dentro: [234B]") || salidas[25].equals("	Dentro: [345C]"));
		assertEquals("\tCola entrada: []", salidas[26]);
		assertEquals("\tCola salida: []", salidas[27]);
		assertTrue(salidas[28].equals("234B SALIENDO	Ha salido	aforo: 0") || salidas[28].equals("345C SALIENDO	Ha salido	aforo: 0"));
		assertTrue(salidas[29].equals("	Dentro: []"));
		assertEquals("\tCola entrada: []", salidas[30]);
		assertEquals("\tCola salida: []", salidas[31]);
		System.setOut(originalOut);
	}
}
