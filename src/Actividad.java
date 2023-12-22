public class Actividad {
    private String id;
    private String descripcion;
    private float precio;
    private static int numActividad = 0;
    public Actividad( String descripcion, float precio){
        this.id = calcular_id();
        this.descripcion = descripcion;
        this.precio = precio;
        numActividad += 1;
    }
    public String getId(){
        return id;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public float getPrecio(){
        return precio;
    }
    public String calcular_id(){
        String id;
        id = "A" + numActividad;
        return id;
    }
}
