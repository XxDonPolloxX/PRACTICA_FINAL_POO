import java.util.ArrayList;

public class Cliente implements java.io.Serializable{
    private ArrayList<Factura> facturas;
    private String nombre;
    private String id;
    private String telefono;
    private ArrayList<ReservaBungalo> reservas;
    public Cliente(String id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        facturas = new ArrayList<Factura>();
        reservas = new ArrayList<ReservaBungalo>();
    }
    public ArrayList<ReservaBungalo> getReservas(){return reservas;}
    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getTelefono(){return telefono;}
    public ArrayList<Factura> getFacturas(){return facturas;}
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
