import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaBungaloTest {


    private Bungalo bungalow = new Bungalo  ("Bungalo de prueba", 10, 10, 1);
    private ReservaBungalo reservaBungalow = new ReservaBungalo(bungalow, "12345678L", LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-05"), 1);
    @Test
    void getId() {
        assertEquals("R1", reservaBungalow.getId());

    }

    @Test
    void getBungalo() {
        assertEquals(bungalow, reservaBungalow.getBungalo());
    }

    @Test
    void getCliente() {
        assertEquals("12345678L", reservaBungalow.getCliente());
    }

    @Test
    void getActividades() {
        assertEquals(0, reservaBungalow.getActividades().size());
    }

    @Test
    void testGetBungalo() {
        assertEquals(bungalow, reservaBungalow.getBungalo());
    }

    @Test
    void hayHueco() {
        assertEquals(false, reservaBungalow.hayHueco(LocalDate.parse("2020-01-03"), LocalDate.parse("2020-01-03")));
    }

    @Test
    void bungaloLibre() {
        assertEquals(true, reservaBungalow.bungaloLibre(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-02")));
    }

    @Test
    void validar_fecha() {
        assertEquals(true, reservaBungalow.validar_fecha(reservaBungalow));
    }

    @Test
    void getPrecio() {
        assertEquals(50, reservaBungalow.getPrecio());
    }
}