import java.util.Date;

public class Main {

    public static void main(String[] args) {

        int cantidad_tests = 10000000;

        // En estas pruebas se utilizaron arreglos con datos fijos y no con datos generados al azar, debido a que esto puede
        // afectar el resultado.
        System.out.println("MergeSort con arreglo(22 int) ordenado: " + testTime(cantidad_tests, new MergeSort(), new Sorted()));
        System.out.println("BubbleSort con arreglo(22 int) ordenado: " + testTime(cantidad_tests, new BubbleSort(), new Sorted()));

        System.out.println("MergeSort con arreglo(22 int) desordenado: " + testTime(cantidad_tests, new MergeSort(), new Unsorted()));
        System.out.println("BubbleSort con arreglo(22 int) desordenado: " + testTime(cantidad_tests, new BubbleSort(), new Unsorted()));

        System.out.println("MergeSort con arreglo(100 int) ordenado: " + testTime(cantidad_tests, new MergeSort(), new Sorted(true)));
        System.out.println("BubbleSort con arreglo(100 int) ordenado: " + testTime(cantidad_tests, new BubbleSort(), new Sorted(true)));

        System.out.println("MergeSort con arreglo(100 int) desordenado: " + testTime(cantidad_tests, new MergeSort(), new Unsorted(true)));
        System.out.println("BubbleSort con arreglo(100 int) desordenado: " + testTime(cantidad_tests, new BubbleSort(), new Unsorted(true)));

        /*
        *  Se realizaron 10 millones de ordenamientos por cada método de ordenamiento y con arreglos ordenados/desordenados y de diferentes tamaños.
        *  Cuando el MergeSort recibe un arreglo ordenado con pocos datos(22 ints), el tiempo que demora es mucho más alto que el método BubbleSort (con 22 ints),
        *  haciendo de esta forma el BubbleSort más "eficiente" a la hora de ordenar un arreglo ordenado con pocos datos
        *  En el otro caso, cuando un arreglo con pocos datos esta completamente desordenado, el BubbleSort demora casi lo mismo que el MergeSort
        *  En cambio, cuando se tratan de ordenar grandes cantidades de datos (100 ints), el MergeSort es mucho más eficiente
        *  (más de un 70% en un arreglo ordenado y más del doble en un arreglo desordenado) que el BubbleSort.
        *
        *  Conclusion: Si se quieren ordenar pequeñas cantidades de datos, se usa BubbleSort, si son grandes cantidades, MergeSort
        *
        * */
    }

    public static long testTime(int times, ISort sortMethod, ArrayType arrayType) {
        Date v_start = new Date();

        for (int i = 0; i < times; i++) {
            sortMethod.sort(arrayType.getArray());
        }
        
        Date v_end = new Date();

        return (v_end.getTime() - v_start.getTime());
    }

}
