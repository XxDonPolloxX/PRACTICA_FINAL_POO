import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class FacturaTest {

    private Bungalo bungalow = new Bungalo  ("Bungalo de prueba", 10, 1, 1);
    private Actividad actividad = new Actividad("Actividad de prueba", 10, 1);
    private ArrayList<Actividad> actividades = new ArrayList<Actividad>(asList(actividad));
    private LocalDate fechaInicio = LocalDate.parse("2020-01-01");
    private LocalDate fechaFin = LocalDate.parse("2020-01-02");
    private Reserva reserva = new ReservaBungalo(   bungalow, "12345678L", fechaInicio, fechaFin, 1 );
 //   public Factura(Cliente c, float precio, LocalDate fecha_factura, Reserva reservas, int numFactura, ArrayList<String> conceptoInicial){
    private Factura factura = new Factura(new Cliente("12345678L", "Pedro Gomez", "625411234"), 100, fechaFin, reserva, 1, new ArrayList<String>(asList("Factura", "Cliente" )));
    @Test
    void getId() {
        assertEquals("00000001", factura.getId());
    }

    @Test
    void getCliente() {
        assertEquals("12345678L", factura.getCliente().getId());
    }

    @Test
    void getFechaFacturacion() {
        assertEquals(fechaFin, factura.getFechaFacturacion());
    }

    @Test
    void getReservas() {
        assertEquals(reserva, factura.getReservas());
    }

    @Test
    void getCosteTotal() {
        assertEquals(100, factura.getCosteTotal());
    }

    @Test
    void calcular_id() {
        assertEquals("00000001", factura.calcular_id(1));
    }


}