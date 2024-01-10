import java.util.ArrayList;
/**
 * Esta clase es el cliente del camping.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Cliente implements java.io.Serializable{
    private ArrayList<Factura> facturas;
    private String nombre;
    private String id;
    private String telefono;
    private ArrayList<ReservaBungalo> reservas;

    /**
     * Este es el constructor de la clase.
     * @param id es el id del cliente.
     * @param nombre es el nombre del cliente.
     * @param telefono es el teléfono del cliente.
     */
    public Cliente(String id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        facturas = new ArrayList<Factura>();
        reservas = new ArrayList<ReservaBungalo>();
    }

    /**
     * Este método devueltve las reservas del  cliente.
     */
    public ArrayList<ReservaBungalo> getReservas(){return reservas;}

    /**
     * Este método devuelve el id del cliente.
     */
    public String getId(){return id;}

    /**
     * Este método devuelve el nombre del cliente.
     */
    public String getNombre(){return nombre;}

    /**
     * Este método devuelve el teléfono del cliente.
     */
    public String getTelefono(){return telefono;}

    /**
     * Este método añade una factura al cliente.
     */
    public ArrayList<Factura> getFacturas(){return facturas;}

    /**
     * Este método recupera una reserva del cliente.
     * @param id es el id de la reserva.
     */
    public ReservaBungalo recuperarReserva(String id){
        int i;
        for(i=0;i<reservas.size();i++){
            if(reservas.get(i).getId() == id){
                return reservas.get(i);
            }
        }
        System.out.println("Reserva no encontrada");
        return null;
    }

}
