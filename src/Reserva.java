import java.util.ArrayList;
import java.util.Date;

public class Reserva implements java.io.Serializable{
    private Date fechaInicio;
    private Date fechaFin;
    private ArrayList<Reserva> reservas;
    public Reserva(Date fecha_inicio, Date fecha_fin){
        fechaInicio = fecha_inicio;
        fechaFin = fecha_fin;
    }
    public Date getFechaInicio(){return fechaInicio;}
    public Date getFechaFin(){return  fechaFin;}
    public String getId(){return null;}
    public ArrayList<Reserva> getActividades(){
        return null;
    }
    public Actividad getActividad(){return null;}
    public String getCliente(){return "";}
    public float getPrecio(){return 0;}
}
