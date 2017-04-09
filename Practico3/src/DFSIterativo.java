import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSIterativo extends DFS {


    /**
     * Recorrido DFS (Depth First Search) iterativo.
     * @param v Vertice inicial de donde empieza el recorrido
     * @return Lista con todos los vertices recorridos
     */
    protected List<Object> recorrer(Vertice v) {
        List<Object> verts = new ArrayList<>();
        Stack<Object> pilaEjecucion = new Stack<>();

        if (!v.isVisited()) {
            v.setVisited(true);
            pilaEjecucion.push(v);
            verts.add(v);

            List<Object> nextVecinos = grafo.vecinos(v);

            for (int i = 0; i < nextVecinos.size(); i++) {

                // Si el vertice inicial tiene de vecino a si mismo, se borra de
                // la lista de vecinos y decimos que ya hay un ciclo en el grafo.
                if (v.equals(nextVecinos.get(i))) {
                    if (nextVecinos.size() - 1 == i) i--;
                    nextVecinos.remove(v);
                    ciclo = true;
                }


                Vertice vecino = getVertice(nextVecinos.get(i));

                if(!vecino.isVisited()) verts.add(vecino);
                vecino.setVisited(true);

                // Si el vecino todavia no termino su ejecucion, pero tiene a todos sus vecinos visitados
                // entonces lo terminamos y volvemos hacia el ultimo vecino ejecutado
                // (Usando una pila para guardar los vecinos a los que tengo que volver)
                if (!vecino.isFinished() && todosVisitados(vecino)) {

                    ciclo = checkCiclo(vecino);
                    vecino.setFinished(true);

                    if (!pilaEjecucion.peek().equals(v)) pilaEjecucion.pop();
                    if (!pilaEjecucion.isEmpty()) nextVecinos = grafo.vecinos(pilaEjecucion.peek());
                    i = -1;
                }

                // Si este vecino todavia no termino, pero todavia tiene vecinos sin visitar
                // entonces vamos al siguiente conjunto de vecinos (Vecinos del vecino actual)
                else if (!vecino.isFinished()) {
                    pilaEjecucion.push(vecino);
                    nextVecinos = grafo.vecinos(vecino);
                    i = -1;
                }
            }

            v.setFinished(true);

        }

        return verts;
    }


    /**
     * Comprueba si todos los vecinos de un Vertice estan visitados (O si ya no tiene vecinos)
     * @param vertice Vertice a comprobvar
     * @return Si estan todos visitados o no
     */
    private boolean todosVisitados(Vertice vertice) {
        List<Object> vecinos = grafo.vecinos(vertice);

        for (Object valorVertice : vecinos) {
            Vertice v = getVertice(valorVertice);
            if (!v.isVisited()) return false;
        }
        return true;
    }


    /**
     * Si uno de los vecinos de este vecino esta visitado, pero no termino su ejecucion,
     * entonces hay ciclo.
     * @param vertice Vecino al cual se le verificaran sus vecinos.
     * @return Si hay ciclo o no.
     */
    private boolean checkCiclo(Vertice vertice) {
        if (!ciclo) {
            List<Object> vecinos = grafo.vecinos(vertice);

            for (Object valorVertice : vecinos) {
                Vertice v = getVertice(valorVertice);
                if (v.isVisited() && !v.isFinished()) return true;
            }
        }
        return ciclo;
    }

}
