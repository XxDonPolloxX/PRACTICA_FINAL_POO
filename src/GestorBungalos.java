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
    public void agregar_bungalo(Bungalo b){
        bungalos.add(b);
        System.out.println("Bungalo " + b.getId() +  " añadido con éxito!");
    }
    public void eliminar_bungalo(Bungalo b){
        bungalos.remove(b);
        System.out.println("Bungalo " + b.getId() +  " eliminado con éxito!");
    }
    public Bungalo recuperar_bungalo(String id){

        int i;
        for(i=0;i<bungalos.size();i++)
        {
            if(bungalos.get(i).getId().equals(id)) {
                System.out.println(bungalos.get(i).getNombre());
                return bungalos.get(i);
                }
            }
        System.out.println("Bungalo no encontrado");
        return null;
        }

    }


