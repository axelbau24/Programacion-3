
public class ListaNodos implements Lista{

    private Nodo firstNode;
    private int size;

    public ListaNodos() {
        firstNode = null;
        size = 0;
    }

    public void add(Object value) {
        if (firstNode == null) firstNode = new Nodo(value);
        else add(value, firstNode);
        size++;
    }

    public void add(Object value, int index) {
        if (index == 0) {
            if (firstNode == null) add(value);
            else {
                Nodo n = new Nodo(value);
                n.setNext(firstNode);
                firstNode = n;
                size++;
            }
        }
        else if (index <= size()) add(value, index, firstNode);

    }

    private void add(Object value, int index, Nodo nodo) {
        if (index == 1) {
            Nodo n = new Nodo(value);
            n.setNext(nodo.getNext());
            nodo.setNext(n);
            size++;
        }
        else add(value, index - 1, nodo.getNext());
    }


    private void add(Object value, Nodo nodo) {
        if (nodo.getNext() == null) {
            Nodo toAdd = new Nodo(value);
            nodo.setNext(toAdd);
        }
        else add(value, nodo.getNext());
    }

    public void remove(Object value) {
        if (firstNode != null) remove(value, firstNode);
    }

    private void remove(Object value, Nodo n) {
        if (firstNode.equals(value)) removeAt(0);
        else if (n.getNext() != null) {
            if (n.getNext().equals(value)) {
                Nodo remove = n.getNext();
                n.setNext(remove.getNext());
                size--;
            }
            else remove(value, n.getNext());
        }
    }

    public void removeAt(int index) {
        if (firstNode != null) {
            if (index == 0) firstNode = firstNode.getNext();
            else removeAt(index, firstNode);
            size--;
        }
    }

    private void removeAt(int index, Nodo nodo) {
        if (index < size()) {
            if (index == 1) {
                Nodo toRemove = nodo.getNext();
                nodo.setNext(toRemove.getNext());
            }
            else removeAt(index - 1, nodo.getNext());
        }
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public int size() {
        return size;
    }

    public Object at(int i) {
        return at(i, firstNode);
    }

    private Object at(int i, Nodo n) {
        if (i < size()) {
            if (i == 0) return n;
            return at(i - 1, n.getNext());
        }
        return null;
    }

}
