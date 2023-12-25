import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class GestorBungalos {
    private ArrayList<Bungalo> bungalos;
    private GestorClientes listaClientes;
    private GestorActividades actividades;

    public GestorBungalos(GestorClientes clientes, GestorActividades actividades) {
        this.bungalos = new ArrayList<Bungalo>();
        this.listaClientes = clientes;
        this.actividades = actividades;
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
                System.out.println("Precio: " + bungalos.get(i).getPrecio() + " €");
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
        public void agregarReserva(){
            int i;
            boolean flagBungalo = false;
            int personas;
            String opcion;
            String id, DNI;
            ArrayList<Bungalo> bungalosDisponibles = new ArrayList<Bungalo>();
            Date fechaInicio = new Date(), fechaFin = new Date();
            System.out.println("¿Desea reservar un bungalo adaptado (s/n)?");
            opcion = MyInput.readString();
            System.out.println("Introduzca el DNI del cliente");
            DNI = MyInput.readString();
            System.out.println("Introduzca el día de comienzo de la reserva:");
            fechaInicio.setDate(MyInput.readInt());
            System.out.println("Introduzca el mes de comienzo de la reserva:");
            fechaInicio.setMonth(MyInput.readInt());
            System.out.println("Introduzca el año de comienzo de la reserva:");
            fechaInicio.setYear(MyInput.readInt());
            System.out.println("Introduzca el día de fin de la reserva:");
            fechaFin.setDate(MyInput.readInt());
            System.out.println("Introduzca el mes de fin de la reserva:");
            fechaFin.setMonth(MyInput.readInt());
            System.out.println("Introduzca el año de fin de la reserva:");
            fechaFin.setYear(MyInput.readInt());
            System.out.println("Introduzca el número de personas");
            personas = MyInput.readInt();
            System.out.println("Estos son los bungalos disponibles:");
            for(i=0;i<listaClientes.getClientes().size();i++){
                if(listaClientes.getClientes().get(i).getId().equals(DNI)){
                    if(opcion.equalsIgnoreCase("s")){
                        for(i=0;i<bungalos.size();i++){
                            if(bungalos.get(i).getId().substring(0,2).equals("BA")){
                                if(bungalos.get(i).getCapacidad() >= personas){
                                    System.out.println(bungalos.get(i).getId());
                                    bungalosDisponibles.add(bungalos.get(i));
                                }
                            }
                        }
                    }
                    else{
                        for(i=0;i<bungalos.size();i++){
                            if(! bungalos.get(i).getId().substring(0,2).equals("BA")){
                                if(bungalos.get(i).getCapacidad() >= personas){
                                    System.out.println(bungalos.get(i).getId());
                                    bungalosDisponibles.add(bungalos.get(i));
                                }
                            }
                        }
                    }
                    if(bungalosDisponibles.isEmpty()){
                        System.out.println("No hay ningún bungalo disponible");
                    }
                    else{
                        System.out.println("Seleccione el id del bungalo:");
                        id = MyInput.readString();
                        for(i=0;i<bungalosDisponibles.size();i++){
                            if(bungalosDisponibles.get(i).getId().equals(id)){
                                bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(bungalosDisponibles.get(i), DNI, fechaInicio, fechaFin));
                                System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                flagBungalo = true;
                            }
                        }
                        if(!flagBungalo){
                            System.out.println("Bungalo no encontrado");
                        }

                    }
                }
                else {
                    System.out.println("DNI de cliente no encontrado");
                }
            }

        }
        public void eliminarReserva(){
        int i, j;
        String id;
        Bungalo b = null;
        System.out.println("Introduce el id del bungalo del que se quiere eliminar la reserva:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            if(bungalos.get(i).getId().equals(id)){
                b = bungalos.get(i);
                System.out.println("Reservas disponibles del bungalo:");
                for(j=0;j<b.getReserva_0().getActividades().size();i++){
                    System.out.println(b.getReserva_0().getActividades().get(i).getId());
                }
            }
        }
        System.out.println("Introduzca el id de la reserva que se quiere cancelar:");
        id = MyInput.readString();
        for(i=0;i<b.getReserva_0().getActividades().size();i++){
            if(b.getReserva_0().getActividades().get(i).getId().equals(id)){
                b.getReserva_0().getActividades().remove(i);
                System.out.println("Reserva " + id + " cancelada con éxito");
            }
        }

        }
        public void agregarActividad(){
        int i, j, participantes;
        String id;
        Reserva r = null;
        Bungalo b = null;
        Actividad a = null;
        Date fechaInicio = new Date(), fechaFin = new Date();
        System.out.println("Introduzca el id de la reserva a la que quiere añadir una actividad");
        id = MyInput.readString();
        System.out.println("Introduzca el número de participantes:");
        participantes = MyInput.readInt();
        System.out.println("Introduzca el día de comienzo de la reserva:");
        fechaInicio.setDate(MyInput.readInt());
        System.out.println("Introduzca el mes de comienzo de la reserva:");
        fechaInicio.setMonth(MyInput.readInt());
        System.out.println("Introduzca el año de comienzo de la reserva:");
        fechaInicio.setYear(MyInput.readInt());
        System.out.println("Introduzca el día de fin de la reserva:");
        fechaFin.setDate(MyInput.readInt());
        System.out.println("Introduzca el mes de fin de la reserva:");
        fechaFin.setMonth(MyInput.readInt());
        System.out.println("Introduzca el año de fin de la reserva:");
        fechaFin.setYear(MyInput.readInt());
        for(i=0;i<bungalos.size();i++){
            for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                if(bungalos.get(i).getReserva_0().getActividades().get(i).getId().equals(id)){
                    r = bungalos.get(i).getReserva_0().getActividades().get(i);
                }
            }
        }
        System.out.println("Actividades disponibles:");
        for(i=0;i<actividades.getActividades().size();i++){
            System.out.println(actividades.getActividades().get(i).getId() + ": " + actividades.getActividades().get(i).getDescripcion());
        }
        System.out.println("Introduzca el id de la actividad");
        id = MyInput.readString();
        for(i=0;i<actividades.getActividades().size();i++){
            if(actividades.getActividades().get(i).getId().equals(id)){
                a = actividades.getActividades().get(i);
                r.getActividades().add(new ReservaActividad(a, participantes, fechaInicio, fechaFin));
                System.out.println("Reserva de la actividad " + a.getId() + " realizada con éxito");
            }
        }
        }



    }


