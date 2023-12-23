import java.util.ArrayList;
import java.util.Date;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Reserva> reservas;
    public Reserva(Date fecha_inicio, Date fecha_fin){
        fechaInicio = fecha_inicio;
        fechaFin = fecha_fin;
    }
    public Date getFechaInicio(){return fechaInicio;}
    public Date getFechaFin(){return  fechaFin;}
}
