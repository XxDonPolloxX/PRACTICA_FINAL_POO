/**
 * Esta clase representa un bungalo adaptado.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class BungaloAdaptado extends Bungalo{
    private int numero;
    private String id;

    /**
     * Este es el constructor de la clase.
     * @param nombre es el nombre del bungalo.
     * @param capacidad es la capacidad del bungalo.
     * @param precio es el precio del bungalo.
     * @param num es el número de bungalo que se ha creado.
     */
    public BungaloAdaptado(String nombre, int capacidad, float precio, int num){


        //anterior
        super(nombre, capacidad, precio, num);
        numero = num;
        this.id = calcular_id();


        //nuevo
    }

    /**
     * Este método calcula el id del bungalo.
     */
    public String calcular_id(){
        String id;
        id =  "BA" + numero;
        return id;}

    /**
     * Este método devuelve el id del bungalo.
     */
    public String getId(){return this.id;}
}
