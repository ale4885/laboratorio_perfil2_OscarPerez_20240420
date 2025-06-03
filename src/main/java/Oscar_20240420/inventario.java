package Oscar_20240420;



class Inventario {
    // Usaremos un arreglo de objetos Producto
    private Producto[] productos;
    private int totalProductos; // Contador para saber cuántos productos reales tenemos

    public Inventario(int capacidadMaxima) {
        this.productos = new Producto[capacidadMaxima];
        this.totalProductos = 0;
    }

    /**
     * Agrega un nuevo producto al inventario.
     * @param id El ID del producto.
     * @param cantidad La cantidad inicial del producto.
     * @return true si se agregó correctamente, false si no hay espacio.
     */
    public boolean agregarProducto(String id, int cantidad) {
        if (totalProductos < productos.length) {
            productos[totalProductos] = new Producto(id, cantidad);
            totalProductos++;
            System.out.println(" Producto '" + id + "' agregado al inventario con " + cantidad + " unidades.");
            return true;
        } else {
            System.out.println(" No hay espacio disponible para más productos en el inventario.");
            return false;
        }
    }

    /**
     * Actualiza el stock de un producto existente.
     * @param idProducto El ID del producto a actualizar.
     * @param nuevaCantidad La nueva cantidad de stock.
     */
    public void actualizarStock(String idProducto, int nuevaCantidad) {
        boolean encontrado = false;
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i] != null && productos[i].getId().equalsIgnoreCase(idProducto)) {
                productos[i].setCantidad(nuevaCantidad);
                System.out.println(" Stock actualizado correctamente para el producto: '" + idProducto + "'. Nuevo stock: " + nuevaCantidad + ".");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println(" Producto no registrado: '" + idProducto + "'. No se pudo actualizar el stock.");
        }
    }

    /**
     * Muestra una alerta para los productos con stock bajo (menos de 10 unidades).
     */
    public void alertarStockBajo() {
        System.out.println("\n--- Alerta de Stock Bajo (< 10 unidades) ---");
        boolean hayStockBajo = false;
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i] != null && productos[i].getCantidad() < 10) {
                System.out.println(" Alerta: El stock del producto '" + productos[i].getId() + "' es bajo: " + productos[i].getCantidad() + " unidades.");
                hayStockBajo = true;
            }
        }
        if (!hayStockBajo) {
            System.out.println("Todos los productos tienen un stock adecuado.");
        }
    }

    /**
     * Muestra todos los productos en el inventario.
     */
    public void listarTodosLosProductos() {
        System.out.println("\n--- Listado Completo de Productos ---");
        if (totalProductos == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i] != null) {
                System.out.println(productos[i]);
            }
        }
    }
}