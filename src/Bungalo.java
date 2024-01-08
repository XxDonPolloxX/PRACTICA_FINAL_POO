import javax.management.StringValueExp;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Esta clase representa un bungalo.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Bungalo implements Serializable {
    private ReservaBungalo reserva_0; // Es una instancia de reserva para poder pillar todas las reservas del bungalo
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;

    /**
     * Este es el constructor de la clase.
     * @param nombre es el nombre del bungalo.
     * @param capacidad es la capacidad del bungalo.
     * @param precio es el precio del bungalo.
     * @param num es el número de bungalo que se ha creado.
     */
    public Bungalo(String nombre, int capacidad, float precio, int num){
        // quito el this
        this.id = this.calcular_id(num);
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        reserva_0 = new ReservaBungalo(this, null, null, null, 0);
    }

    /**
     * Este método devuelve el id del bungalo.
     */
    public String getId() {
        return id;
    }

    /**
     * Este método devuelve el nombre del bungalo.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Este método devuelve la capacidad del bungalo.
     */
    public int getCapacidad(){
        return capacidad;
    }

    /**
     * Este método devuelve el precio del bungalo.
     */
    public float getPrecio(){
        return precio;
    }

    /**
     * Este método devuelve la reserva del bungalo.
     */
    public ReservaBungalo getReserva_0(){return reserva_0;}

    /**
     * Este método calcula el id del bungalo.
     * @param num es el número de bungalo que se ha creado.
     */
    public String calcular_id(int num){
        String id;
        id =  "B" + num;
        return id;
    }

}
