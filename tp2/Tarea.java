import java.util.UUID;

public class Tarea {
    private String codigo;
    private String descripcion;
    private String nombre;
    private String estado;
    private boolean esAlta;

    // Constructor de 3 parámetros; esAlta siempre inicia en true
    public Tarea(String nombre, String descripcion, String estado) {
        this.codigo = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.esAlta = true;
    }

    // Getters y setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isAlta() {
        return esAlta;
    }

    public void setAlta(boolean esAlta) {
        this.esAlta = esAlta;
    }

    @Override
    public String toString() {
        return "Tarea [" +
               "código=" + codigo +
               ", nombre='" + nombre + '\'' +
               ", descripción='" + descripcion + '\'' +
               ", estado='" + estado + '\'' +
               ", esAlta=" + esAlta +
               ']';
    }
}
