import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    private Cliente cliente = new Cliente("12345678L", "Pedro Gomez", "625411234");
    @Test
    void getReservas() {
    }

    @Test
    void getId() {
        assertEquals("12345678L", cliente.getId());
    }

    @Test
    void getNombre() {
        assertEquals("Pedro Gomez", cliente.getNombre());
    }

    @Test
    void getTelefono() {
        assertEquals("625411234", cliente.getTelefono());

    }

}