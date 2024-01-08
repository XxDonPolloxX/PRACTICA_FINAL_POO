import java.time.LocalDate;
import java.util.Date;

/**
 * Esta clase hereda de Reserva, que representa la reserva de un bungalo con sus actividades asociadas.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class ReservaActividad extends Reserva{
    private Actividad actividad;
    private int num_participantes;

    /**
     * Este es el constructor de la clase.
     * @param a Actividad
     * @param participantes Numero de participantes
     * @param inicio Fecha de inicio
     * @param fin  Fecha de fin
     */
    public ReservaActividad(Actividad a, int participantes, LocalDate inicio, LocalDate fin){
        super(inicio, fin);
        actividad = a;
        num_participantes = participantes;
    }

    /**
     * Este método devuelve la actividad de la reserva.
     * @return Devuelve las actividades de la reserva.
     */
    public Actividad getActividad(){return actividad;}

    public boolean validar_fecha_restaurante(){ //Esta funcion la utilizaremos en añadir actividad, si devuelve false no se añade (se pone en null)
        if(actividad.getId().substring(0, 1) == "AR") {
            if (getFechaFin() == getFechaInicio()) {
                return true;
            }
            else {return false;}
        }
        else {return true;}
    }

    /**
     * Este método devuelve el precio de la reserva.
     * @return Devuelve el precio de la reserva.
     */
    public float getPrecio(){
        return actividad.getPrecio();
    }

}
