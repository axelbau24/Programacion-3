public class Pila{

    ListaNodos list;

    public Pila(){
        list = new ListaNodos();
    }

    public boolean empty(){
        return list.isEmpty();
    }

    public void push(Object o) {
        list.add(o, 0);
    }

    public Object pop(){
        Object o = list.at(0);
        list.removeAt(0);
        return o;
    }

    public Object peek(){
        return list.at(0);
    }

}
