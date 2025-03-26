package dam.psp.hebras;

public class Fiestero extends Thread {

	public enum Estado {
		FUERA, ENTRANDO, BAILANDO, SALIENDO
	}

	private PuertaDisco puertaDisco;
	private String dni;
	private Estado estado;
	private static final int TIEMPO_TRANSITO = 500;
	private static final int TIEMPO_BAILE = 5500;

	public Fiestero(PuertaDisco puertaDisco, String dni) {
		this.dni = dni;
		this.puertaDisco = puertaDisco;
		this.estado = Estado.FUERA; // el fiestero empieza fuera
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public static int getTiempoTransito() {
		return TIEMPO_TRANSITO;
	}
	
	public static int getTiempoBaile() {
		return TIEMPO_BAILE;
	}

	@Override
	public String toString() {
		return dni + " " + estado;
	}
	
	@Override
	public void run() {
		try {
			puertaDisco.entrar(this);
			puertaDisco.bailar(this);
			puertaDisco.salir(this);
		} catch(InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}