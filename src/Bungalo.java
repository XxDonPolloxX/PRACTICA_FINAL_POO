public class Bungalo {
    private Reserva reserva_0; // Es una instancia de reserva para poder pillar todas las reservas del bungalo
    private String id;
    private String nombre;
    private int capacidad;
    private float precio;

    public Bungalo(String id, String nombre, int capacidad, float precio){
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
    }
}
