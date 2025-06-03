package AstridMurgas_20240235;


import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //Creaciòn de lista de Productos con TreeMap
        System.out.println("--------Inventario de Productos--------");
        TreeMap<String, Integer> productos = new TreeMap<>();
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
            System.out.println("3. Salir");
            opc = scan.nextInt();
            switch (opc){
                case 1:
                    //Opción para Actualizar
                    System.out.println("Ingrese el Producto que desea modificar: ");
                    scan.nextLine();
                    String produ = scan.nextLine();
                    if (productos.containsKey(produ)){
                        System.out.println("El producto existe en el registro");
                        System.out.println("Ingrese el nuevo valor del Stock de " + produ + ":");
                        // Validación para asegurarse de que se ingrese un número entero
                        while (!scan.hasNextInt()) {
                            System.out.println("Por favor ingrese un número válido para el stock.");
                            scan.next();
                        }
                        int newStock = scan.nextInt();
                        productos.put(produ, newStock);
                        System.out.println("El stock de " + produ + " ha sido actualizado a " + newStock);
                    } else {
                        System.out.println("El producto no está registrado.");
                    }
                    break;

                case 2:
                    // Opción para consultar el inventario
                    System.out.println("¿Cómo desea filtrar los productos?");
                    System.out.println("1. Filtrar por nombre");
                    System.out.println("2. Filtrar por stock");
                    System.out.println("3. Ver todo el inventario");
                    int filtro = scan.nextInt();

                    switch (filtro) {
                        case 1:
                            // Filtrar por nombre
                            System.out.println("Ingrese el nombre o parte del nombre del producto a buscar:");
                            scan.nextLine();
                            String nombreFiltro = scan.nextLine();
                            boolean encontrado = false;
                            for (String producto : productos.keySet()) {
                                if (producto.contains(nombreFiltro)) {
                                    System.out.println("Producto: " + producto + " | Stock: " + productos.get(producto));
                                    encontrado = true;
                                }
                            }
                            if (!encontrado) {
                                System.out.println("No se encontraron productos que coincidan con el filtro.");
                            }
                            break;

                        case 2:
                            // Filtrar por stock
                            System.out.println("¿Quiere filtrar por stock mayor o menor a un valor?");
                            System.out.println("1. Stock menor a X");
                            System.out.println("2. Stock mayor a X");
                            int tipoFiltroStock = scan.nextInt();
                            System.out.println("Ingrese el valor de stock:");
                            int valorStock = scan.nextInt();

                            boolean encontradoStock = false;
                            for (String producto : productos.keySet()) {
                                int stock = productos.get(producto);
                                if ((tipoFiltroStock == 1 && stock < valorStock) || (tipoFiltroStock == 2 && stock > valorStock)) {
                                    System.out.println("Producto: " + producto + " | Stock: " + stock);
                                    encontradoStock = true;
                                }
                            }
                            if (!encontradoStock) {
                                System.out.println("No se encontraron productos con ese filtro de stock.");
                            }
                            break;

                        case 3:
                            //Mostrar el contenido del inventario
                            System.out.println("Inventario completo:");
                            if (productos.isEmpty()) {
                                System.out.println("El inventario está vacío.");
                            } else {
                                for (String producto : productos.keySet()) {
                                    System.out.println("Producto: " + producto + " | Stock: " + productos.get(producto));
                                }
                            }
                            break;

                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }

                case 3:
                    // Opción para salir
                    System.out.println("¡Gracias por usar el sistema de Inventario!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }while(opc!=3);
    }
}