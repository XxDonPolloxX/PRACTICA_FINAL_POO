import javax.management.StringValueExp;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Bungalo implements Serializable {
    private ReservaBungalo reserva_0; // Es una instancia de reserva para poder pillar todas las reservas del bungalo
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;
    private static int numBungalo;
    public Bungalo(String nombre, int capacidad, float precio){
        this.id = calcular_id();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.reserva_0 = new ReservaBungalo(this, null, null, null);
        numBungalo += 1;
    }

    public String getId() {
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public float getPrecio(){
        return precio;
    }
    public int getNumBungalo(){
        return numBungalo;
    }
    public ReservaBungalo getReserva_0(){return reserva_0;}
    public String calcular_id(){
        String id;
        id =  "B" + numBungalo;
        return id;
    }

}
