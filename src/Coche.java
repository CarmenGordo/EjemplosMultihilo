import java.util.Random;

//implementar interfaz Runnable.
class Coche implements Runnable {
    private String nombre;
    private int distanciaRecorrida;
    private int distanciaTotal;
    private static final int velocidadMaxima = 120;
    //velocidad aleatoria:
    private Random random;
    private static volatile String ganador = null;

    public Coche(String nombre, int distanciaTotal) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaTotal = distanciaTotal;
        this.random = new Random();
    }

    // método run: simulador del coche
    @Override
    public void run() {
        System.out.println(nombre + " ha comenzado la carrera!");

        while (distanciaRecorrida < distanciaTotal) {
            //incrementos pequeños desde el 1 al 10
            int avance = random.nextInt(10) + 1;
            distanciaRecorrida += avance;

            // no puede exceder la distanciia total
            if (distanciaRecorrida > distanciaTotal) {
                distanciaRecorrida = distanciaTotal;
            }
            System.out.println(nombre + " ha avanzado " + avance + " unidades"+
                    "\n Su distancia total son: " + distanciaRecorrida + " unidades");

            //Thread.sleep: simula el tiempo avanzado en 200s
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(nombre + " se ha parado");
                return;
            }

            if (distanciaRecorrida >= distanciaTotal && ganador == null) {
                ganador = nombre;
                System.out.println(nombre);
            }
        }

        if (ganador == null) {
            System.out.println(nombre + " ha acabado la carrera");
        }
    }

    public static String getGanador() {
        return ganador;
    }
}

