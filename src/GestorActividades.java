import java.util.ArrayList;

public class GestorActividades {
    private ArrayList<Actividad> actividades;
    public GestorActividades(){
        actividades = new ArrayList<Actividad>();
    }
    public ArrayList<Actividad> getActividades(){return actividades;}
    public void agregarActividad(){
        String descripcion;
        float precio;
        System.out.println("Introduzca la descripción de la actividad: ");
        descripcion = MyInput.readString();
        System.out.println("Introduzca el precio de la actividad: ");
        precio = MyInput.readFloat();
        actividades.add(new Actividad(descripcion, precio));
        System.out.println("La actividad: " + actividades.getLast().getId() + " se ha añadido con éxito");
    }
    public void listarActividades(){
        int i;
        for(i=0;i<actividades.size();i++){
            System.out.println(actividades.get(i).getId() + ": " + actividades.get(i).getDescripcion());
        }
    }
    public void recuperarActividad(String id){
        int i;
        for(i=0;i<actividades.size();i++){
            if(actividades.get(i).getId().equals(id)){
                System.out.println("Id: " + actividades.get(i).getId());
                System.out.println("Descripción: " + actividades.get(i).getDescripcion());
                System.out.println("Precio: " + actividades.get(i).getPrecio() + " €");
            }
        }
    }
}
