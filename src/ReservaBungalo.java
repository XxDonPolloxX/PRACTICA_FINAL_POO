import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ReservaBungalo extends Reserva{
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String id;
    private String cliente;

    public ReservaBungalo(Bungalo b, String DNI, LocalDate fecha_inicio, LocalDate fecha_fin, int num){
        super(fecha_inicio, fecha_fin);
        if(DNI == null){
            id = "";
        }
        else{
            id = "R" + num;
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


    public boolean hayHueco(LocalDate f_i, LocalDate f_f) {
        if (f_i.isAfter(getFechaFin()) || f_f.isBefore(getFechaInicio()))
            return true;
        else
            return false;
    }
    public boolean bungaloLibre(LocalDate f_i, LocalDate f_f) {
        boolean hueco=true;
        for(Reserva r:actividades)
            hueco=hueco && r.hayHueco(f_i,f_f);
        return hueco;
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
        precio = bungalo.getPrecio()*((getFechaFin().getDayOfYear()-getFechaInicio().getDayOfYear())+1);
        for(i=0;i<actividades.size();i++){
            precio += actividades.get(i).getPrecio();
        }
        return precio;
    }

}
