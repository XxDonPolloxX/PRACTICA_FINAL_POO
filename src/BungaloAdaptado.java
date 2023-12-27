public class BungaloAdaptado extends Bungalo{
    private int numero;
    public BungaloAdaptado(String nombre, int capacidad, float precio, int num){
        super(nombre, capacidad, precio, num);
        numero = num;
    }
    public String calcular_id(){
        String id;
        id =  "BA" + numero;
        return id;}
}
