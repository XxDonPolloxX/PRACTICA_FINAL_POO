public class Restaurante  extends  Actividad{

    private String id;
    public Restaurante(String descripcion, float precio, int num){
        super(descripcion, precio, num);
        id = "AR" + num;
    }

}
