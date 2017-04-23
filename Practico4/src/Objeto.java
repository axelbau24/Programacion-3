
public class Objeto {

    private float peso;
    private float valor;
    private String nombre;

    public Objeto(String nombre, float valor, float peso) {
        setPeso(peso);
        setValor(valor);
        setNombre(nombre);
    }

    /**
     * @return Relacion valor por peso
     */
    public float getRelacion(){
        if(peso == 0) return -1;
        return valor / peso;
    }

    public void setPeso(float peso) {
        if (peso > 0) this.peso = peso;
    }

    public void setValor(float valor) {
        if (valor >= 0) this.valor = valor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public float getValor() {
        return valor;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return nombre + ": $" + valor + " - " + peso + "kg";
    }

    public boolean equals(Object obj) {
        Objeto o = (Objeto)obj;
        return o.getNombre().equals(nombre) && o.getPeso() == peso && o.getValor() == valor;
    }
}
