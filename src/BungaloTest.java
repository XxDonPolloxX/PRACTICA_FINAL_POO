import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BungaloTest {
    private Bungalo bungalo = new Bungalo("Bungalo de Prueba", 10, 1, 1);
    @Test
    void getId() {
        assertEquals("B1", bungalo.getId());
    }

    @Test
    void getNombre() {
        assertEquals("Bungalo de Prueba", bungalo.getNombre());
    }

    @Test
    void getCapacidad() {
        assertEquals(10, bungalo.getCapacidad());
    }

    @Test
    void getPrecio() {
        assertEquals(1, bungalo.getPrecio());
    }



    @Test
    void calcular_id() {
        assertEquals("B1", bungalo.calcular_id(1));
    }
}