import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase representa la reserva de un cliente de un bungalo con sus actividades asociadas.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Reserva implements java.io.Serializable{
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private ArrayList<Reserva> actividades;

    /**
     * Este es el constructor de la clase.
     * @param fecha_inicio es la fecha de inicio de la reserva.
     * @param fecha_fin es la fecha de fin de la reserva.
     */
    public Reserva(LocalDate fecha_inicio, LocalDate fecha_fin){
        fechaInicio = fecha_inicio;
        fechaFin = fecha_fin;
    }

    /**
     * Este método devuelve la fecha de inicio de la reserva.
     * @return Devuelve la fecha de inicio de la reserva.
     */
    public LocalDate getFechaInicio(){return fechaInicio;}

    /**
     * Este método devuelve la fecha de fin de la reserva.
     * @return Devuelve la fecha de fin de la reserva.
     */
    public LocalDate getFechaFin(){return  fechaFin;}

    /**
     * Este método devuelve el id de la reserva.
     * @return Devuelve el id de la reserva.
     */
    public String getId(){return null;}

    /**
     * Este método devuelve las actividades de la reserva.
     * @return Devuelve las actividades de la reserva.
     */
    public ArrayList<Reserva> getActividades(){
        return null;
    }

    /**
     * Este método devuelve las actividades.
     * @return Devuelve las actividad.
     */
    public Actividad getActividad(){return null;}

    /**
     * Este método devuelve el cliente de la reserva.
     * @return Devuelve el cliente de la reserva.
     */
    public String getCliente(){return "";}

    /**
     * Este método devuelve el precio de la reserva.
     * @return Devuelve el precio de la reserva.
     */
    public float getPrecio(){return 0;}

    /**
     * Este método devuelve el bungalo de la reserva para comprobar que hay hueco.
     * @param f_i es la fecha de inicio de la reserva.
     * @param f_f es la fecha de fin de la reserva.
     * @return Devuelve true si hay hueco y false si no lo hay.
     */
    public boolean hayHueco(LocalDate f_i, LocalDate f_f) {
        if (f_i.isAfter(getFechaFin()) || f_f.isBefore(getFechaInicio()))
            return true;
        else
            return false;
    }
}
