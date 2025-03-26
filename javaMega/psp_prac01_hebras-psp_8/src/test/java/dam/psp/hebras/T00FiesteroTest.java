package dam.psp.hebras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import dam.psp.hebras.Fiestero.Estado;

class T00FiesteroTest {

	@Test
	void fiesteroTest() {
		Fiestero f = new Fiestero(null, "dni");
		assertEquals("dni", f.getDni());
		assertEquals("dni FUERA", f.toString());
		Fiestero f2 = new Fiestero(null, "123A");
		assertEquals("123A", f2.getDni());
		assertEquals("123A FUERA", f2.toString());
	}
	
	@Test
	void estadoTest() {
		Estado[] estados = Estado.values();
		assertEquals(4, estados.length);
		assertEquals("FUERA", estados[0].toString());
		assertEquals("ENTRANDO", estados[1].toString());
		assertEquals("BAILANDO", estados[2].toString());
		assertEquals("SALIENDO", estados[3].toString());
	}
}
