public class TablaDispersa {
    private Tarea[] tabla;
    private int numElementos;
    private double factorCarga;

    public TablaDispersa() {
        this.tabla = new Tarea[101];
        this.numElementos = 0;
        this.factorCarga = 0.0;
    }

    public boolean insertar(Tarea t) {
        if (numElementos >= tabla.length * 0.75) {
            return false;
        }
        int posicion = calcularPosicion(t.getCodigo());
        int i = 0;
        while (tabla[posicion] != null && tabla[posicion].isAlta()) {
            i++;
            posicion = resolverColision(posicion, i);
        }
        tabla[posicion] = t;
        numElementos++;
        calcularFactorCarga();
        return true;
    }

    public Tarea buscar(String codigo) {
        int posicion = calcularPosicion(codigo);
        int i = 0;
        while (tabla[posicion] != null) {
            if (tabla[posicion].getCodigo().equals(codigo) && tabla[posicion].isAlta()) {
                return tabla[posicion];
            }
            i++;
            posicion = resolverColision(posicion, i);
        }
        return null;
    }

    public boolean eliminar(String codigo) {
        Tarea t = buscar(codigo);
        if (t != null) {
            t.setAlta(false);
            numElementos--;
            calcularFactorCarga();
            return true;
        }
        return false;
    }

    public void mostrarTabla() {
        System.out.println("Contenido de la tabla:");
        for (Tarea t : tabla) {
            if (t != null && t.isAlta()) {
                System.out.println("  " + t);
            }
        }
    }

    private int calcularPosicion(String codigo) {
        double A = 0.6180339887;
        long valor = obtenerValorNumerico(codigo);
        double producto = valor * A;
        double decimal = producto - Math.floor(producto);
        return (int) (decimal * tabla.length);
    }

    private long obtenerValorNumerico(String clave) {
        long valor = 0;
        for (int j = 0; j < Math.min(clave.length(), 10); j++) {
            valor = valor * 27 + clave.charAt(j);
        }
        return Math.abs(valor);
    }

    private int resolverColision(int posicionInicial, int i) {
        return (posicionInicial + i * i) % tabla.length;
    }

    private void calcularFactorCarga() {
        this.factorCarga = (double) numElementos / tabla.length;
    }

    public double getFactorCarga() {
        return factorCarga;
    }
}
