import java.util.ArrayList;
import java.util.List;

public class DFSRecursivo extends DFS{

    /**
     * Recorrido DFS (Depth First Search) recursivo
     * @param vertice Vertice inicial de donde empieza el recorrido
     * @return Lista con todos los vertices recorridos
     */
    protected List<Object> recorrer(Vertice vertice) {
        List<Object> verts = new ArrayList<>();

        if (!vertice.isVisited()) {
            verts.add(vertice);
            vertice.setVisited(true);

            for (Object ve : grafo.vecinos(vertice)) {
                verts.addAll(recorrer(getVertice(ve)));
            }
            vertice.setFinished(true);
        }
        else if(!vertice.isFinished()) ciclo = true;
        return verts;
    }

}
