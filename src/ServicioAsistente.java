public class ServicioAsistente extends ServicioEspecialDecorator{
    public ServicioAsistente(Bungalo b){
        super(b);
    }
    public String getNombre(){return super.getNombre() + " Asistente";}
    public float getPrecio(){return super.getPrecio() + 50;}
}
