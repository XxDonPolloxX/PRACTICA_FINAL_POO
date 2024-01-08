/**
 * Esta clase es un decorador de ServicioEspecialDecorator que añade un asistente
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class ServicioAsistente extends ServicioEspecialDecorator{
    /**
     * Este es el constructor de la clase.
     * @param b es el bungalo al que se le añade el servicio.
     */
    public ServicioAsistente(Bungalo b){
        super(b);
    }

    /**
     * Este método devuelve el nombre del servicio.
     * @return Devuelve el nombre del servicio.
     */
    public String getNombre(){return super.getNombre() + " Asistente";}

    /**
     * Este método devuelve el precio del servicio.
     * @return Devuelve el precio del servicio.
     */
    public float getPrecio(){return super.getPrecio() + 50;}
}
