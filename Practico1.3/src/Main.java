
public class Main {

    public static void main(String[] args) {

        Pila pila = new Pila();

        System.out.println("Empty: " + pila.empty());

        pila.push(12);
        pila.push(9);
        pila.push(1);

        System.out.println("Empty: " + pila.empty());

        System.out.println(pila.peek());

        pila.push(2);

        System.out.println(pila.pop());

        System.out.println(pila.pop());

        System.out.println(pila.peek());
    }
}
