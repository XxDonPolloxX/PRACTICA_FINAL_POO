public class BungaloAdaptado extends Bungalo{
    public BungaloAdaptado(String nombre, int capacidad, float precio){
        super(nombre, capacidad, precio);
    }
    public String calcular_id(){
        String id;
        id =  "BA" + super.getNumBungalo();
        return id;}
}
