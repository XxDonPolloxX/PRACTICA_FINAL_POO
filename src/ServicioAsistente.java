public class ServicioAsistente extends ServicioEspecialDecorator{
    public ServicioAsistente(Bungalo b){
        super(b);
    }
    public String getNombre(){return super.getNombre() + " Asistente";}
}
