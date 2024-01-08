import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase representa la reserva de un cliente de un bungalo con sus actividades asociadas.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class ReservaBungalo extends Reserva{
    private Bungalo bungalo;
    private ArrayList<Reserva> actividades;
    private String id;
    private String cliente;

    /**
     * Este es el constructor de la clase.
     * @param b Bungalo
     * @param DNI Identificador del Cliente
     * @param fecha_inicio Fecha de inicio
     * @param fecha_fin Fecha de fin
     * @param num Numero de reserva
     */
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

    /**
     * Este método retorna el id de la reserva.
     * @return Devuelve el id de la reserva.
     */
    public String getId(){
        return id;
    }

    /**
     * Este método retorna el bungalo de la reserva.
     * @return Devuelve el bungalo de la reserva.
     */
    public Bungalo getBungalo(){
        return bungalo;
    }

    /**
     * Este método retorna el cliente de la reserva.
     * @return Devuelve el cliente de la reserva.
     */
    public String getCliente(){
        return cliente;
    }

    /**
     * Este método añade una actividad a la reserva.
     * @return Devuelve las actividades de la reserva.
     */
    public ArrayList<Reserva> getActividades(){
        return  actividades;
    }
    public void getBungalo(Bungalo b){
        bungalo = b;
    }


    /**
     * @param f_i es la fecha de inicio de la reserva.
     * @param f_f es la fecha de fin de la reserva.
     * @return Devuelve true si hay hueco y false si no lo hay.
     */
    public boolean hayHueco(LocalDate f_i, LocalDate f_f) {
        if (f_i.isAfter(getFechaFin()) || f_f.isBefore(getFechaInicio()))
            return true;
        else
            return false;
    }

    /**
     * Este método muestra si hay hueco en el bungalo.
     * @param f_i es la fecha de inicio de la reserva.
     * @param f_f es la fecha de fin de la reserva.
     * @return Devuelve true si hay hueco y false si no lo hay.
     */
    public boolean bungaloLibre(LocalDate f_i, LocalDate f_f) {
        boolean hueco=true;
        for(Reserva r:actividades)
            hueco=hueco && r.hayHueco(f_i,f_f);
        return hueco;
    }

    /**
     * Este método valida la fecha de la reserva.
     * @param r es la reserva que se quiere añadir.
     * @return Devuelve true si se ha añadido y false si no se ha añadido.
     */
    public boolean validar_fecha(Reserva r){
        if(super.getFechaInicio().isAfter(r.getFechaInicio()) || super.getFechaFin().isBefore(r.getFechaFin())){
            return false;
        }
        else{return true;}
        }

    /**
     * Este metodo retorna el precio de la reserva.
     * @return Devuelve el precio de la reserva.
     */
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
