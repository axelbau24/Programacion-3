
public class Main {

    public static void main(String[] args) {

    	/* Trabajo practico realizado por Bautista Axel*/

        Grafo g1 = generarGrafo(500, 5, true);
        Grafo g2 = generarGrafo(1000, 20, false);
        Grafo g3 = generarGrafo(2000, 100, true);
        Grafo g4 = generarGrafo(5000, 50, false);

        System.out.println("Grafo G1 recursivo: ");
        comprobarGrafo(new DFSRecursivo(), g1);
        System.out.println("Grafo G1 iterativo: ");
        comprobarGrafo(new DFSIterativo(), g1);

        System.out.println("Grafo G2 iterativo: ");
        comprobarGrafo(new DFSIterativo(), g2);
        System.out.println("Grafo G2 recursivo: ");
        comprobarGrafo(new DFSRecursivo(), g2);

        System.out.println("Grafo G3 recursivo: ");
        comprobarGrafo(new DFSRecursivo(), g3);
        System.out.println("Grafo G3 iterativo: ");
        comprobarGrafo(new DFSIterativo(), g3);

        System.out.println("Grafo G4 iterativo: ");
        comprobarGrafo(new DFSIterativo(), g4);
        System.out.println("Grafo G4 recursivo: ");
        comprobarGrafo(new DFSRecursivo(), g4);

        
        /* El DFS iterativo utiliza una pila donde se iran guardando los vertices para despues volver a los mismos una vez que todos sus vecinos fueron
         * visitados, esto causa que el uso de la memoria sea mayor que el método DFS recursivo, este mismo usa una pila de ejecucion interna, pero funciona 
         * de manera mas eficiente y su codigo es mucho mas legible que en el metodo iterativo */
    }

    public static void comprobarGrafo(DFS metodo, Grafo grafo) {
        System.out.println("Vertices recorridos: " + metodo.recorrer(grafo));
        System.out.println("¿Hay ciclos en el grafo? " + metodo.hayCiclo(grafo));
        System.out.println();
    }

    public static Grafo generarGrafo(int cantVertices, int grado, boolean conCiclos) {
        Grafo g = new GrafoDirigido();

        if (cantVertices > grado) {
            for (int i = 0; i < cantVertices; i++) g.insertarVertice(i);

            for (int i = 0; i < cantVertices - grado; i++) {

                for (int j = 1; j <= grado; j++) {
                    g.insertarArista(i, i + j);

                    if (conCiclos) {
                        int arista = (int) (Math.random() * (i + j - 1));
                        g.insertarArista(i, arista);
                    }
                }
            }
        }
        return g;
    }


}
