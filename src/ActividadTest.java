import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActividadTest {


    private Actividad actividad = new Actividad("Actividad de Prueba", 10, 1);
    @Test
    void getId() {
        assertEquals("A1", actividad.getId());
    }

    @Test
    void getDescripcion() {
        assertEquals("Actividad de Prueba", actividad.getDescripcion());
    }

    @Test
    void getPrecio() {
        assertEquals(10, actividad.getPrecio());
    }
}