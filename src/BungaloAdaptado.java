public class

BungaloAdaptado extends Bungalo{
    private int numero;
    public BungaloAdaptado(String nombre, int capacidad, float precio, int num){




        //anterior
        super(nombre, capacidad, precio, num);
        numero = num;
        //nuevo


    }
    public String calcular_id(){
        String id;
        id =  "BA" + numero;
        return id;}
}
