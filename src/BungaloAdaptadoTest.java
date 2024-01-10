import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BungaloAdaptadoTest {
       private BungaloAdaptado bungalo = new BungaloAdaptado("Bungalo Adaptado de Prueba", 10, 1, 1);
    @Test
    void calcular_id() {
        assertEquals("BA1", bungalo.calcular_id());
    }

    @Test
    void getId() {
        assertEquals("BA1", bungalo.getId());
    }
}