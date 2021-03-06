import java.util.ArrayList;
import java.util.List;

// Grafo utilizando listas de adyacencia
public class GrafoDirigido implements Grafo {

    private ArrayList<Object>[] vList; // Lista de adyacencia, los vertices se controlan por su indice.
    private Object[] vertices; // Vertice generico, el indice va a ser el mismo que en el de la lista

    public Object[] getVertices() {
        return vertices;
    }

    public GrafoDirigido() {
        vertices = new Object[0];
    }

    public int cantVertices() {
        return vertices.length;
    }

    /**
     * Comprueba si existe una arista(arco) entre dos vertices
     * @param i Primer vertice
     * @param j Segundo vertice
     * @return Si hay conexion entre estos vertices
     */
    public boolean existeArista(Object i, Object j) {
        for (int k = 0; k < cantVertices(); k++) {
            if (vertices[k].equals(i) && vList[k].contains(j)) return true;
        }
        return false;
    }

    /**
     * Crea una arista entre dos vertices
     * @param v1 Primer vertice
     * @param v2 Segundo vertice
     */
    public void insertarArista(Object v1, Object v2) {
        if (!existeArista(v1, v2)) {
            for (int i = 0; i < vList.length; i++) {
                if (vertices[i].equals(v1)) {
                    vList[i].add(v2);
                }
            }
        }
    }

    /**
     * Crea un vertice, se agrega una nueva ArrayList a la lista de adyacencia (array vList),
     * y se guarda el valor del vertice (array vertices)
     *
     * @param value Valor generico del vertice
     */
    public void insertarVertice(Object value) {
        Object[] verts = new Object[cantVertices() + 1];
        ArrayList<Object> l[] = new ArrayList[cantVertices() + 1];

        if (cantVertices() > 0) {
            for (int i = 0; i < cantVertices(); i++) {
                verts[i] = vertices[i];
                l[i] = vList[i];
            }
        }
        vList = l;
        vertices = verts;

        vList[cantVertices() - 1] = new ArrayList<>();
        vertices[cantVertices() - 1] = value;
    }

    /**
     * Busca todos los vecinos de un vertice
     * @param vertice Vertice donde se buscaran vecinos
     * @return Lista con todos los vecinos
     */
    public List<Object> vecinos(Object vertice) {
        for (int i = 0; i < vList.length; i++) {
            if (vertice.equals(vertices[i])) return new ArrayList<>(vList[i]);
        }
        return new ArrayList<>();
    }

    /**
     * Se busca un camino entre dos vertices (mas largo)
     * @param v1 Vertice inicial
     * @param v2 Vertice final
     * @return Lista con el camino recorrido (De inicio a fin)
     */
    public List<Object> caminoSimple(Object v1, Object v2) {
        List<Object> camino = new ArrayList<>();
        List<Object> aux = new ArrayList<>();
        camino.add(v1);
        aux.addAll(caminoSimple(v1, v2, camino, new ArrayList<>())); // TODO
        aux.add(v2);
        return aux;
    }

    
    /**
     * Se busca un camino entre dos vertices (el mas largo)
     * @param v1 Vertice inicial
     * @param v2 Vertice final
     * @param camino Donde se ira guardando el camino actual
     * @param masLargo Donde se guarda el camino deseado
     * @return Lista con los vertices que forman el camino
     */
    private List<Object> caminoSimple(Object v1, Object v2, List<Object> camino, List<Object> masLargo) {
        List<Object> vecinos = vecinos(v1);

        for (Object vecino : vecinos) {
            if (vecino.equals(v2) && (camino.size() > masLargo.size() || masLargo.isEmpty())) {
                masLargo.clear();
                masLargo.addAll(camino);
            }
            else {
                if (!camino.contains(vecino)) {
                    camino.add(vecino);
                    caminoSimple(vecino, v2, camino, masLargo);
                    camino.remove(vecino);
                }
            }
        }

        return masLargo;
    }


}
