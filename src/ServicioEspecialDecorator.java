public class ServicioEspecialDecorator extends BungaloAdaptado{
    private BungaloAdaptado bungalo;
    public ServicioEspecialDecorator(BungaloAdaptado b){
        super("",0,0);
        bungalo = b;
    }

}
