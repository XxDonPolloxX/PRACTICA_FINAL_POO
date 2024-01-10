import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaActividadTest {

    private Actividad actividad = new Actividad("Actividad de prueba", 10, 1);
    private ReservaActividad reservaActividad = new ReservaActividad(actividad, 2, LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-02"));
    @Test
    void getActividad() {
        assertEquals(actividad, reservaActividad.getActividad());

    }

    @Test
    void validar_fecha_restaurante() {
        assertEquals(true, reservaActividad.validar_fecha_restaurante());
    }

    @Test
    void getPrecio() {
        assertEquals(10, reservaActividad.getPrecio());
    }
}