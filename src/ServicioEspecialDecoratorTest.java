import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioEspecialDecoratorTest {
    private BungaloAdaptado bungaloAdaptado = new BungaloAdaptado("Bungalo Adaptado de prueba", 10, 10, 1);
    private ServicioEspecialDecorator servicioEspecialDecorator = new ServicioEspecialDecorator(bungaloAdaptado);
    @Test
    void getNombre() {
        assertEquals("Bungalo Adaptado de prueba", servicioEspecialDecorator.getNombre());
    }

    @Test
    void getId() {
        assertEquals("BA1", servicioEspecialDecorator.getId());
    }

    @Test
    void getCapacidad() {
        assertEquals(10, servicioEspecialDecorator.getCapacidad());
    }

    @Test
    void getPrecio() {
        assertEquals(10, servicioEspecialDecorator.getPrecio());
    }
}