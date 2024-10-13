public class Main {
    public static void main(String[] args) {
        int distanciaCarrera = 100;
        int numeroCoches = 5;
        String[] nombres = {
                "Fernando Alonso",
                "Hamilton",
                "Carlos Sainz",
                "Pierre Gasly",
                "Lando Norris"
        };
        //Thread[]: para crear los hilos
        Thread[] hilos = new Thread[numeroCoches];

        //crear hilos:
        for (int i = 0; i < numeroCoches; i++) {
            Coche coche = new Coche(nombres[i], distanciaCarrera);
            hilos[i] = new Thread(coche);
            hilos[i].start();
        }

        //necesitan acabar todos los hilos:
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("El hilo se ha parado");
            }
        }

        String ganador = Coche.getGanador();
        if (ganador != null) {
            System.out.println("El ganador de la carrera es: "+ganador+"! :)");
        } else {
            System.out.println("No hay nigun ganador :(");
        }

    }
}