import java.util.Date;

public class ReservaActividad extends Reserva{
    private Actividad actividad;
    private int num_participantes;
    public ReservaActividad(Actividad a, int participantes, Date inicio, Date fin){
        super(inicio, fin);
        actividad = a;
        num_participantes = participantes;
    }
    public Actividad getActividad(){return actividad;}

    public boolean validar_fecha_restaurante(){ //Esta funcion la utilizaremos en añadir actividad, si devuelve false no se añade (se pone en null)
        if(actividad.getId().substring(0, 1) == "AR") {
            if (getFechaFin() == getFechaInicio()) {
                return true;
            }
            else {return false;}
        }
        else {return true;}
    }
    public float getPrecio(){
        return actividad.getPrecio();
    }

}
