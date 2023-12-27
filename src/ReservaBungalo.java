import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReservaBungalo extends Reserva{
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String id;
    private String cliente;
    private static int numReserva = 0;

    public ReservaBungalo(Bungalo b, String DNI, LocalDate fecha_inicio, LocalDate fecha_fin){
        super(fecha_inicio, fecha_fin);
        if(DNI == null){
            id = "";
        }
        else{
            id = calcular_id();
            numReserva += 1;
        }
        bungalo = b;
        cliente = DNI;
        actividades = new ArrayList<Reserva>();
    }
    public String getId(){
        return id;
    }
    public Bungalo getBungalo(){
        return bungalo;
    }
    public String getCliente(){
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
    public boolean validar_fecha(Reserva r){
        if(super.getFechaInicio().isAfter(r.getFechaInicio()) || super.getFechaFin().isBefore(r.getFechaFin())){
            return false;
        }
        else{return true;}
        }
    public float getPrecio(){
        int i;
        float precio;
        precio = bungalo.getPrecio();
        for(i=0;i<actividades.size();i++){
            precio += actividades.get(i).getPrecio();
        }
        return precio;
    }

}
