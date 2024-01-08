import java.io.Serializable;

/**
 * Esta clase representa una actividad que se puede realizar en el Bungalo.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Actividad implements Serializable {
    private String id;
    private String descripcion;
    private float precio;

    /**
     * Este es el constructor de la clase.
     * @param descripcion es la descripción de la actividad.
     * @param precio es el precio de la actividad.
     * @param numActividad es el número de actividad que se ha creado.
     */
    public Actividad( String descripcion, float precio, int numActividad){
        this.id = "A" + numActividad;
        this.descripcion = descripcion;
        this.precio = precio;
        numActividad += 1;
    }

    /**
     * Este método devuelve el id de la actividad.
     */
    public String getId(){
        return id;
    }

    /**
     * Este método devuelve la descripción de la actividad.
     */
    public String getDescripcion(){
        return descripcion;
    }

    /**
     * Este método devuelve el precio de la actividad.
     */
    public float getPrecio(){
        return precio;
    }

}
