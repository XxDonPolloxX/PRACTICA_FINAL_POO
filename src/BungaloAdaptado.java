public class

BungaloAdaptado extends Bungalo{
    private int numero;
    private String id;
    public BungaloAdaptado(String nombre, int capacidad, float precio, int num){




        //anterior
        super(nombre, capacidad, precio, num);
        numero = num;
        this.id = calcular_id();


        //nuevo


    }
    public String calcular_id(){
        String id;
        id =  "BA" + numero;
        return id;}
    public String getId(){return this.id;}
}
