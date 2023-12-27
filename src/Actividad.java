import java.io.Serializable;

public class Actividad implements Serializable {
    private String id;
    private String descripcion;
    private float precio;
    public Actividad( String descripcion, float precio, int numActividad){
        this.id = "A" + numActividad;
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

}
