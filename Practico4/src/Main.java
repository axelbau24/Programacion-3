import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Objeto> objetos = new ArrayList<>();

        // Objeto = (Nombre , Valor, Peso)
        objetos.add(new Objeto("A", 100, 5));
        objetos.add(new Objeto("B", 500, 5));
        objetos.add(new Objeto("C", 30, 8));
        objetos.add(new Objeto("D", 100, 1));
        objetos.add(new Objeto("E", 1000, 4));
        objetos.add(new Objeto("F", 500, 10));
        objetos.add(new Objeto("G", 4000, 4));
        objetos.add(new Objeto("H", 10000, 15));

        // Se intenta llenar una mochila que tiene un peso limite de 25kg con los objetos
        Mochila m = new Mochila(25, objetos);

        // Se muestran los objetos que entraron a la mochila
        // y que hacen el valor de la misma el mas alto posible
        System.out.println(m.llenar());

    }


}