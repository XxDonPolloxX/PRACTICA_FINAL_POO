import java.util.ArrayList;
import java.util.Scanner;


public class GestorBungalos {
    private ArrayList<Bungalo> bungalos;

    public GestorBungalos() {
        this.bungalos = new ArrayList<Bungalo>();
    }
    public ArrayList<Bungalo> getBungalos(){
        return bungalos;
    }
    public void agregar_bungalo(){
        String opcion = "n", nombre;
        int capacidad;
        float precio;
        Bungalo b;
        System.out.println("Desea añadir un bungalo adaptado s/n:");
        opcion = MyInput.readString();
        System.out.println("Introduzca el nombre:");
        nombre = MyInput.readString();
        System.out.println("Introduzca la capacidad:");
        capacidad = MyInput.readInt();
        System.out.println("Introduzca el precio:");
        precio = MyInput.readFloat();

        if(opcion.equals("s")){
            b = new BungaloAdaptado(nombre, capacidad, precio);
        }
        else{
            b = new Bungalo(nombre, capacidad, precio);
        }
        bungalos.add(b);
        System.out.println("Bungalo " + b.getId() +  " añadido con éxito!");
    }
    public void eliminar_bungalo(){ //Aqui falta comprobar si el bungalo tiene reservas
        String id;
        int i;
        System.out.print("Introduce el id del bungalo a eliminar:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            if(id.equals(bungalos.get(i).getId())){
                System.out.println("Bungalo " + bungalos.get(i).getId() +  " eliminado con éxito!");
                bungalos.remove(bungalos.get(i));

            }
        }

    }
    public Bungalo recuperar_bungalo(String id){
        int i;
        for(i=0;i<bungalos.size();i++)
        {
            if(bungalos.get(i).getId().equals(id)) {
                System.out.println("Nombre: " + bungalos.get(i).getNombre());
                System.out.println("Precio: " + bungalos.get(i).getPrecio());
                System.out.println("Capacidad: " + bungalos.get(i).getCapacidad());
                return bungalos.get(i);
                }
            }
        System.out.println("Bungalo no encontrado");
        return null;
        }
        public String mostrarBungalos(){
        int i;
        String opcion;
        System.out.println("¿Desea mostrar la información de bungalos adaptados? En caso negativo se mostrará la información de los no adaptados (s/n):");
        opcion = MyInput.readString();
        String cadena_bungalos= "";
            if(opcion.equals("s")){
                for(i=0;i<bungalos.size();i++){
                    if("BA".equals(bungalos.get(i).getId().substring(0, 2))){
                        cadena_bungalos += bungalos.get(i).getId() + ": " + bungalos.get(i).getCapacidad() + " ";

                    }
                }

            }
            else{
                for(i=0;i<bungalos.size();i++){
                    if(!"BA".equals(bungalos.get(i).getId().substring(0,2))){
                        cadena_bungalos += bungalos.get(i).getId() + ": " + bungalos.get(i).getCapacidad() + " ";
                    }
                }
            }
        return cadena_bungalos;
        }



    }


