public class ServicioCatering extends ServicioEspecialDecorator {

    public ServicioCatering(Bungalo b){
        super(b);
    }
    public String getNombre(){return super.getNombre() + " Catering";}
}
