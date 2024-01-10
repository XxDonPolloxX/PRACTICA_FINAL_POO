import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioCateringTest {

    private BungaloAdaptado bungaloAdaptado = new BungaloAdaptado("Bungalo Adaptado de prueba", 10, 10, 1);
    private ServicioCatering servicioCatering = new ServicioCatering(bungaloAdaptado);
    @Test
    void getNombre() {
        assertEquals("Bungalo Adaptado de prueba Catering", servicioCatering.getNombre());
    }

    @Test
    void getPrecio() {
        assertEquals(40, servicioCatering.getPrecio());
    }
}