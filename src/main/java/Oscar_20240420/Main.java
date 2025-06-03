package Oscar_20240420;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia de Inventario con una capacidad de 10 productos
        Inventario miInventario = new Inventario(10);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Añadimos algunos productos de ejemplo al inicio
        miInventario.agregarProducto("Leche", 25);
        miInventario.agregarProducto("Pan", 8);
        miInventario.agregarProducto("Huevos", 15);
        miInventario.agregarProducto("Mantequilla", 5);
        miInventario.agregarProducto("Café", 12);
        miInventario.agregarProducto("Azúcar", 30);
        miInventario.agregarProducto("Arroz", 7);

        do {
            System.out.println("--- Menú de Inventario ---");
            System.out.println("1. Actualizar Stock de Producto");
            System.out.println("2. Ver Productos con Stock Bajo");
            System.out.println("3. Listar Todos los Productos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el ID del producto a actualizar: ");
                        String idActualizar = scanner.nextLine();
                        System.out.print("Ingrese la nueva cantidad: ");
                        int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                        miInventario.actualizarStock(idActualizar, nuevaCantidad);
                        break;
                    case 2:
                        miInventario.alertarStockBajo();
                        break;
                    case 3:
                        miInventario.listarTodosLosProductos();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema de inventario. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número para la opción o la cantidad.");
                opcion = 0; // Para que el bucle continúe
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
                opcion = 0;
            }

        } while (opcion != 4);

        scanner.close();
    }
}