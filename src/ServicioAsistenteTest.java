import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioAsistenteTest {

    private BungaloAdaptado bungaloAdaptado = new BungaloAdaptado("Bungalo Adaptado de prueba", 10, 10, 1);
    private ServicioAsistente servicioAsistente = new ServicioAsistente(bungaloAdaptado);
    @Test
    void getNombre() {
        assertEquals("Bungalo Adaptado de prueba Asistente", servicioAsistente.getNombre());
    }

    @Test
    void getPrecio() {
        assertEquals(60, servicioAsistente.getPrecio());
    }
}