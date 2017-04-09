import java.util.List;

public interface Grafo {

    int cantVertices();
    boolean existeArista(Object i, Object j);
    void insertarArista(Object i, Object j);
    void insertarVertice(Object i);
    List<Object> vecinos(Object vertice);
    Object[] getVertices();
    List<Object> caminoSimple(Object v1, Object v2);

}
