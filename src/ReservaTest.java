import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservaTest {

    private Reserva reserva = new Reserva(LocalDate.parse("2020-01-01"), LocalDate.parse("2020-01-02"));
    @Test
    void getFechaInicio() {
        assertEquals(LocalDate.parse("2020-01-01"), reserva.getFechaInicio());
    }

    @Test
    void getFechaFin() {
        assertEquals(LocalDate.parse("2020-01-02"), reserva.getFechaFin());
    }


}