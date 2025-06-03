package AstridMurgas_20240235;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //Creaciòn de lista de Productos con TreeMap
        System.out.println("--------Inventario de Productos--------");
        TreeMap<String, Number> productos = new TreeMap<>();
        Scanner scan = new Scanner(System.in);

        //Agregaciòn de Productos
        productos.put("Takis", 10);
        productos.put("Brownie", 5);
        productos.put("Jugo", 15);
        productos.put("Kolashanpan", 20);
        int opc;
        do {
            System.out.println("¡Bienvenido a el sistema de Inventario!");
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Actualizar inventario");
            System.out.println("2. Consultar Inventario");
            opc = scan.nextInt();
            switch (opc){
                case 1:
                    System.out.println("Ingrese el Producto que desea modificar: ");
                    scan.nextLine();
                    String produ = scan.nextLine();
                    if (productos.containsKey(produ)){
                        System.out.println("El producto existe en el registro");
                        System.out.println("Ingrese el nuevo valor del Stock de " + produ + ":");
                        scan.nextLine();
                        Number newStock = scan.nextInt();
                    }
            }
        }while(opc<=2);
    }
}