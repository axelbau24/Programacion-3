import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private List<Objeto> objetos;
    private float pesoLimite;
    private float pesoActual;

    public Mochila(float pesoLimite, ArrayList<Objeto> objetos) {
        this.pesoLimite = pesoLimite;
        this.pesoActual = 0;
        this.objetos = new ArrayList<>(objetos);
    }

    /**
     * Se llenara la mochila con los objetos que mejor relacion valor/peso tengan
     * y se borra el objeto seleccionado (sin importar si se agrego a la mochila o no)
     * @return Lista de objetos de la mochila
     */
    public ArrayList<Objeto> llenar() {
        ArrayList<Objeto> contenido = new ArrayList<>();

        while (!objetos.isEmpty() && pesoActual < pesoLimite) {
            Objeto p = getBestProducto();
            float pesoObj = p.getPeso();

            if (noSupera(pesoObj)) {
                pesoActual += pesoObj;
                contenido.add(p);
            }
            objetos.remove(p);

        }

        return contenido;
    }

    /**
     * Comprueba si agregando un objeto mas a la mochila
     * no se llegue a su limite de peso
     * @param peso peso del producto a agregar
     * @return Si no supera el peso maximo.
     */
    public boolean noSupera(float peso) {
        return peso + pesoActual <= pesoLimite;
    }

    /**
     * De todos los objetos que existen para agregar
     * se selecciona el que mejor relacion precio/peso tenga
     * y que tambien sea el mas caro de la lista
     *
     * @return el producto mas caro con la mejor relacion de todos.
     */
    private Objeto getBestProducto() {
        Objeto producto = new Objeto(null, 0, 0);
        for (Objeto p : objetos) {
            if (p.getRelacion() >= producto.getRelacion() && esElMasCaro(p)) producto = p;
        }

        return producto;
    }

    /**
     * Comprueba si un objeto es el mas caro de todos los candidatos
     * @param objeto Objeto a comprobar
     * @return Si es el mas caro.
     */
    private boolean esElMasCaro(Objeto objeto){
        float valor = objeto.getValor();

        for(Objeto o : objetos){
            if(o.getValor() > valor) return false;
        }
        return true;
    }

}
