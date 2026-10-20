
package club.tienda;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import club.usuarios.Usuario;
import club.personal.Empleado;
import club.usuarios.*;


public abstract class Venta {

    // Atributos
    protected LocalDateTime fecha;
    protected double subtotal;
    protected double impuestos;
    protected double descuentos;
    protected double total;
    protected int puntosGanados;
    protected int puntosRedimidos;

    protected List<DetalleVenta> detalleVentas;
    protected Usuario comprador;

    private boolean confirmada;

    // ctor 1: venta nueva
    protected Venta(Usuario comprador) {

        if (comprador == null) {
            throw new IllegalArgumentException(
                "El comprador es obligatorio");
        }

        this.comprador = comprador;
        this.fecha = LocalDateTime.now();
        this.detalleVentas = new ArrayList<>();

        this.subtotal = 0;
        this.impuestos = 0;
        this.descuentos = 0;
        this.total = 0;

        this.puntosGanados = 0;
        this.puntosRedimidos = 0;
        this.confirmada = false;
    }

    // ctor 2: venta historica (persistencia)
    protected Venta(
            Usuario comprador,
            LocalDateTime fecha,
            List<DetalleVenta> detalleVentas,
            double subtotal,
            double impuestos,
            double descuentos,
            double total,
            int puntosGanados,
            int puntosRedimidos,
            boolean confirmada) {

        if (comprador == null || fecha == null ||
                detalleVentas == null) {
            throw new IllegalArgumentException(
                "Datos historicos incompletos");
        }

        this.comprador = comprador;
        this.fecha = fecha;
        this.detalleVentas = new ArrayList<>(detalleVentas);

        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.descuentos = descuentos;
        this.total = total;

        this.puntosGanados = puntosGanados;
        this.puntosRedimidos = puntosRedimidos;
        this.confirmada = confirmada;
    }
    //metodos
    // Agregar un producto a la venta
    public void agregarDetalle(DetalleVenta detalle) {

        if (confirmada) {
            throw new IllegalStateException(
                "No se puede modificar una venta confirmada");
        }

        if (detalle == null) {
            throw new IllegalArgumentException(
                "El detalle no puede ser nulo");
        }

        detalleVentas.add(detalle);

        // Si cambia el carrito, se debe reaplicar
        // cualquier descuento que hubiera sido calculado.
        descuentos = 0;
        puntosGanados = 0;
    }

    // Calcular el subtotal de los productos
    protected double calcularSubtotal() {

        double suma = 0;

        for (DetalleVenta detalle : detalleVentas) {
            suma += detalle.getSubtotal();
        }

        return suma;
    }

    // Cada subclase implementa su propia liquidacion
    public abstract double liquidar();

    // Registrar puntos que se quieren redimir
    public void redimirPuntos(int cantidad) {

        if (confirmada) {
            throw new IllegalStateException(
                "La venta ya esta confirmada");
        }

        if (cantidad < 0) {
            throw new IllegalArgumentException(
                "Los puntos no pueden ser negativos");
        }

        this.puntosRedimidos = cantidad;
        this.puntosGanados = 0;
    }

    // Calcular puntos ganados (2 % del total)
    public int asignarPuntos() {

        if (!(comprador instanceof Socio) &&
                !(comprador instanceof Empleado)) {
            puntosGanados = 0;
            return 0;
        }

        puntosGanados = (int) Math.floor(total * 0.02);

        return puntosGanados;
    }

    // Confirmar una venta
    public void confirmar() {

        if (confirmada) {
            throw new IllegalStateException(
                "La venta ya esta confirmada");
        }

        if (detalleVentas.isEmpty()) {
            throw new IllegalStateException(
                "La venta no tiene productos");
        }

        // Aplicar los calculos de la subclase
        liquidar();

        this.confirmada = true;
    }

    // Getters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public double getTotal() {
        return total;
    }

    public int getPuntosGanados() {
        return puntosGanados;
    }

    public int getPuntosRedimidos() {
        return puntosRedimidos;
    }

    public List<DetalleVenta> getDetalleVentas() {
        return new ArrayList<>(detalleVentas);
    }

    public Usuario getComprador() {
        return comprador;
    }

    public boolean estaConfirmada() {
        return confirmada;
    }
}
