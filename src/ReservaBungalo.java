import java.util.ArrayList;

public class ReservaBungalo extends Reserva{
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String id;
    private Cliente cliente;
    private static int numReserva = 0;

    public ReservaBungalo(Bungalo b, Cliente c){
        id = calcular_id();
        bungalo = b;
        cliente = c;
        actividades = new ArrayList<Reserva>();
        numReserva += 1;
    }
    public String getId(){
        return id;
    }
    public Bungalo getBungalo(){
        return bungalo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public ArrayList<Reserva> getActividades(){
        return  actividades;
    }

    public String calcular_id(){
        String id;
        id = "R" + numReserva;
        return id;
    }

}
