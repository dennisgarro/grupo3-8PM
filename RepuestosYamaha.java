import java.util.Scanner;

class Repuesto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int disponibilidad;

    public Repuesto(String nombre, String descripcion, double precio, int disponibilidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getDisponibilidad() { return disponibilidad; }
}

public class RepuestosYamaha {
    private static Repuesto[] repuestos;
    private static Scanner scanner = new Scanner(System.in);

    public void yamaha()
        {
            boolean ejecutar = true;
        
        while (ejecutar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarRepuestos();
                    break;
                case 2:
                    mostrarDisponibles();
                    break;
                case 3:
                    mostrarTodos();
                    break;
                case 4:
                    buscarPorNombre();
                    break;
                case 5:
                    ejecutar = false;
                    System.out.println("GRACIAS");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n!!!! SISTEMA DE INVENTARIO YAMAHA !!!!");
        System.out.println("1. Registrar repuestos");
        System.out.println("2. Mostrar repuestos disponibles");
        System.out.println("3. Mostrar todos los repuestos");
        System.out.println("4. Buscar repuesto por nombre");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void registrarRepuestos() {
        System.out.println("\nIngrese la cantidad de repuestos a registrar:");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        repuestos = new Repuesto[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nRepuesto #" + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            
            int disponibilidad;
            do {
                System.out.print("Disponibilidad (1 = disponible, 0 =no disponible): ");
                disponibilidad = scanner.nextInt();
                if (disponibilidad != 0 && disponibilidad != 1) {
                    System.out.println("Error: Solo se permite 0 o 1");
                }
            } while (disponibilidad != 0 && disponibilidad != 1);
            
            scanner.nextLine();
            
            repuestos[i] = new Repuesto(nombre, descripcion, precio, disponibilidad);
            System.out.println("\nRepuesto guardado correctamente");
        }
    }

    private static void mostrarDisponibles() {
        if (repuestos == null || repuestos.length == 0) {
            System.out.println("\nNo hay repuestos registrados");
            return;
        }

        System.out.println("\n=== ARTÍCULOS DISPONIBLES ===");
        int contadorDisponibles = 0;
        
        for (Repuesto repuesto : repuestos) {
            if (repuesto.getDisponibilidad() == 1) {
                contadorDisponibles++;
                mostrarRepuesto(repuesto);
            }
        }
        
        System.out.println("\nTotal de artículos disponibles: " + contadorDisponibles);
    }

    private static void mostrarTodos() {
        if (repuestos == null || repuestos.length == 0) {
            System.out.println("\nNo hay repuestos registrados.");
            return;
        }

        System.out.println("\n=== TODOS LOS REPUESTOS ===");
        for (Repuesto repuesto : repuestos) {
            mostrarRepuesto(repuesto);
        }
    }

    private static void buscarPorNombre() {
        if (repuestos == null || repuestos.length == 0) {
            System.out.println("\nNo hay repuestos registrados.");
            return;
        }

        System.out.print("\nIngrese el nombre del repuesto a buscar: ");
        String nombreBuscar = scanner.nextLine();
        boolean encontrado = false;

        for (Repuesto repuesto : repuestos) {
            if (repuesto.getNombre().toLowerCase().contains(nombreBuscar.toLowerCase())) {
                if (!encontrado) {
                    System.out.println("\n!!! RESULTADOS DE LA BÚSQUEDA !!!");
                    encontrado = true;
                }
                mostrarRepuesto(repuesto);
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontraron repuestos con ese nombre.");
        }
    }

    private static void mostrarRepuesto(Repuesto repuesto) {
        System.out.println("\nNombre: " + repuesto.getNombre());
        System.out.println("Descripción: " + repuesto.getDescripcion());
        System.out.println("Precio: $" + repuesto.getPrecio());
        System.out.println("Estado: " + (repuesto.getDisponibilidad() == 1 ? "Disponible" : "No disponible"));
    }
} 