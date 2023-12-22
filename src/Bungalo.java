import javax.management.StringValueExp;

public class Bungalo {
    private Reserva reserva_0; // Es una instancia de reserva para poder pillar todas las reservas del bungalo
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;
    private static int numBungalo = 0;
    public Bungalo(String nombre, int capacidad, float precio){
        this.id = calcular_id();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
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
    public String calcular_id(){
        String id;
        id =  "B" + numBungalo;
        return id;
    }
}
