public class ServicioEspecialDecorator extends BungaloAdaptado{
    private Bungalo bungalo;
    public ServicioEspecialDecorator(Bungalo b){
        super("",0,0);
        bungalo = b;
    }
    public String getNombre(){return bungalo.getNombre();}
    public String getId(){return bungalo.getId();}
    public int getCapacidad(){return bungalo.getCapacidad();}
    public float getPrecio(){return bungalo.getPrecio();}

}
