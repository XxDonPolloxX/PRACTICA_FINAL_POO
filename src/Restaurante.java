public class Restaurante  extends  Actividad{
    private static int numRestaurante;
    private String id;
    public Restaurante(String descripcion, float precio){
        super(descripcion, precio);
        id = calcular_id();
        numRestaurante += 1;
    }
    public String calcular_id(){
        String id;
        id = "AR" + numRestaurante;
        return id;
    }
}
