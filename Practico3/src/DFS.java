import java.util.ArrayList;
import java.util.List;

public abstract class DFS {

    Grafo grafo;
    Vertice[] vertices;
    boolean ciclo;

    /**
     * Recorre un grafo
     * @param g Grafo a recorrer
     * @return Lista de los valores que se recorrieron
     */
    public List<Object> recorrer(Grafo g) {
        List<Object> vertices_recorridos = new ArrayList<>();

        grafo = g;
        vertices = new Vertice[g.cantVertices()];

        // Se guardan los valores de los vertices (de tipo Object)
        // en un arreglo de tipo Vertice para luego poder hacer comparaciones
        for (int i = 0; i < g.cantVertices(); i++) {
            Object valor_vertice = g.getVertices()[i];
            vertices[i] = new Vertice(valor_vertice);
        }

        for (int i = 0; i < g.cantVertices(); i++) {
            if (!vertices[i].isFinished()) vertices_recorridos.addAll(recorrer(vertices[i]));
        }

        return vertices_recorridos;
    }


    /**
     * Forma de recorrido de el grafo
     * @param vertice Vertice inicial
     * @return Lista con todos los vertices recorridos
     */
    protected abstract List<Object> recorrer(Vertice vertice);


    /**
     * Comprueba si existe un ciclo en un grafo
     * @param g Grafo a comprobar
     * @return Si existe un ciclo o no
     */
    public boolean hayCiclo(Grafo g) {
        ciclo = false;
        recorrer(g);
        return ciclo;
    }

    /**
     * Busca a un Object en la lista de vertices y lo convierte en
     * el tipo Vertice para hacer uso de sus atributos (visited, finished)
     * @param o Object a convertir
     * @return Un Vertice con el valor de 'o'
     */
    protected Vertice getVertice(Object o) {
        for (int i = 0; i < grafo.cantVertices(); i++) {
            if (grafo.getVertices()[i].equals(o)) {
                return vertices[i];
            }
        }
        return null;
    }

}

