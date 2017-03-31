
public class Nodo {

    private Nodo next;
    private Object value;

    public Nodo(Object v) {
        value = v;
        next = null;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo n) {
        next = n;
    }

    public Object getValue() {
        return value;
    }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public String toString() {
        return value.toString();
    }
}
