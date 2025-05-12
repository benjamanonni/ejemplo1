import java.util.Scanner;

public class MainTabla {
    public static void main(String[] args) {
        TablaDispersa tabla = new TablaDispersa();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Buscar tarea");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Ver todas las tareas");
            System.out.println("5. Salir");
            System.out.print("Elegí una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Estado (pendiente / en progreso / finalizada): ");
                    String estado = scanner.nextLine();

                    Tarea nueva = new Tarea(nombre, descripcion, estado);
                    if (tabla.insertar(nueva)) {
                        System.out.println("Tarea agregada.");
                    } else {
                        System.out.println("No se pudo agregar.");
                    }
                    break;

                case 2:
                    System.out.print("Código: ");
                    String codBuscar = scanner.nextLine();
                    Tarea t = tabla.buscar(codBuscar);
                    if (t != null) {
                        System.out.println(t);
                    } else {
                        System.out.println("No encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Código: ");
                    String codEliminar = scanner.nextLine();
                    if (tabla.eliminar(codEliminar)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("No se encontró.");
                    }
                    break;

                case 4:
                    tabla.mostrarTabla();
                    break;

                case 5:
                    System.out.println("Chau!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
