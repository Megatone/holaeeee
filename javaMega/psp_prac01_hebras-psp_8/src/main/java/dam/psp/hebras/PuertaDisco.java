package dam.psp.hebras;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PuertaDisco {
    private int aforoMaximo;
    private ArrayList<Fiestero> fiesterosDentro = new ArrayList<Fiestero>();
    private ArrayList<Fiestero> colaEntrada = new ArrayList<Fiestero>();
    private ArrayList<Fiestero> colaSalida = new ArrayList<Fiestero>();
    private static final String T = "\t";
    private static final String N = System.lineSeparator();
   
    public PuertaDisco(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    private static String imprimirDnis(ArrayList<Fiestero> lista) {
    	return "[" + lista.stream().map(Fiestero::getDni).collect(Collectors.joining(", ")) + "]" ;
    }
    
    private String pintaHebra() {
        return ((Fiestero) Thread.currentThread()).toString();
    }

    private void pintaTraza(String accion) {
    	String traza = pintaHebra() + T + accion + T + "aforo: " + fiesterosDentro.size() + N;
    	traza += T + "Dentro: " + imprimirDnis(fiesterosDentro) + N;
    	traza += T + "Cola entrada: " + imprimirDnis(colaEntrada) + N;
    	traza += T + "Cola salida: " + imprimirDnis(colaSalida);
    	System.out.println(traza);
    }

    public synchronized void entrar(Fiestero fiestero) throws InterruptedException {
    	pintaTraza("Entrando");
        fiestero.setEstado(Fiestero.Estado.ENTRANDO);
        Thread.sleep(Fiestero.getTiempoTransito());
    
        // Si el aforo está lleno, el fiestero debe esperar
//        while (fiesterosDentro.size() >= aforoMaximo) {
//            colaEntrada.add(fiestero);
//            pintaTraza("Esperando para entrar");
//            wait();
//        }
    	 colaEntrada.remove(fiestero);
         fiesterosDentro.add(fiestero);
         pintaTraza("Ha entrado");
         notifyAll();
    }
    

    public synchronized void bailar(Fiestero fiestero) throws InterruptedException {
    	fiestero.setEstado(Fiestero.Estado.BAILANDO);
        Thread.sleep(Fiestero.getTiempoBaile()); // Simula el tiempo de baile
    }

    public synchronized void salir(Fiestero fiestero) throws InterruptedException {
    	pintaTraza("Saliendo");
        fiestero.setEstado(Fiestero.Estado.SALIENDO);
        Thread.sleep(Fiestero.getTiempoTransito());
        fiesterosDentro.remove(fiestero);
        colaSalida.add(fiestero);

        // El fiestero espera hasta que salga
        if (!colaSalida.isEmpty()) {
            colaSalida.remove(fiestero);
            notifyAll();
        }
        pintaTraza("Ha salido");
        fiestero.setEstado(Fiestero.Estado.FUERA);
    }
}
