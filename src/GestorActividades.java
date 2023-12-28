import java.io.Serializable;
import java.util.ArrayList;

public class GestorActividades implements Serializable {
    private ArrayList<Actividad> actividades;
    private int numeroActividades;
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
        actividades.add(new Actividad(descripcion, precio, numeroActividades));
        numeroActividades += 1;
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
        boolean flag = false;
        for(i=0;i<actividades.size();i++){
            if(actividades.get(i).getId().equals(id)){
                System.out.println("Id: " + actividades.get(i).getId());
                System.out.println("Descripción: " + actividades.get(i).getDescripcion());
                System.out.println("Precio: " + actividades.get(i).getPrecio() + " €");
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Error: No se ha encontrado la actividad");
        }
    }
    public void menuActividades(){
        String s;
        do{
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Agregar actividad");
            System.out.println("2. Listar actividades");
            System.out.println("3. Recuperar actividad");
            System.out.println("4. Volver al menú principal");
            s = MyInput.readString();
            switch(s){
                case "1":
                    agregarActividad();
                    break;
                case "2":
                    listarActividades();
                    break;
                case "3":
                    System.out.println("Introduzca el id de la actividad:");
                    s = MyInput.readString();
                    recuperarActividad(s);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(!s.equals("4"));
    }
}
