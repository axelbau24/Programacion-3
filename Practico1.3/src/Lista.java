
public interface Lista {

    void add(Object value);

    void add(Object value, int index);

    void remove(Object value);

    void removeAt(int index);

    Object at(int index);

    boolean isEmpty();

    int size();

}
