/**
 * Esta clase es la encargada de decorar los bungalows con los servicios especiales.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class ServicioEspecialDecorator extends BungaloAdaptado{
    private Bungalo bungalo;

    /**
     * Este es el constructor de la clase.
     * @param b es el bungalo al que se le añade el servicio.
     */
    public ServicioEspecialDecorator(Bungalo b){
        super("",0,0, 0);
        bungalo = b;
    }

    /**
     * Este método devuelve el nombre del servicio.
     * @return Devuelve el nombre del servicio.
     */
    public String getNombre(){return bungalo.getNombre();}

    /**
     * Este método devuelve el id del bungalo.
     * @return Devuelve el id del bungalo.
     */
    public String getId(){return bungalo.getId();}

    /**
     * Este método devuelve la capacidad del bungalo.
     * @return Devuelve la capacidad del bungalo.
     */
    public int getCapacidad(){return bungalo.getCapacidad();}

    /**
     * Este método devuelve el precio del bungalo.
     * @return Devuelve el precio del bungalo.
     */
    public float getPrecio(){return bungalo.getPrecio();}

}
