import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements java.io.Serializable{
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<Reserva> reservas;
    public Reserva(LocalDate fecha_inicio, LocalDate fecha_fin){
        fechaInicio = fecha_inicio;
        fechaFin = fecha_fin;
    }
    public LocalDate getFechaInicio(){return fechaInicio;}
    public LocalDate getFechaFin(){return  fechaFin;}
    public String getId(){return null;}
    public ArrayList<Reserva> getActividades(){
        return null;
    }
    public Actividad getActividad(){return null;}
    public String getCliente(){return "";}
    public float getPrecio(){return 0;}
}
