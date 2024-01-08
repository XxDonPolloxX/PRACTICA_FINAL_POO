import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Esta clase representa a el gestor de bungalo.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class GestorBungalos implements Serializable {
    private ArrayList<Bungalo> bungalos;
    private GestorClientes listaClientes;
    private GestorActividades actividades;
    private int numbungalos;
    private int numReservas;

    /**
     * Este es el constructor de la clase.
     * @param clientes es el gestor de clientes.
     * @param actividades es el gestor de actividades.
     */
    public GestorBungalos(GestorClientes clientes, GestorActividades actividades) {
        this.bungalos = new ArrayList<Bungalo>();
        this.listaClientes = clientes;
        this.actividades = actividades;
    }

    /**
     * Este método devuelve el número de bungalos.
     */
    public ArrayList<Bungalo> getBungalos(){
        return bungalos;
    }

    /**
     * Este método agrega un bungalo.
     */
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

        if(opcion.equalsIgnoreCase("s")){
            b = new BungaloAdaptado(nombre, capacidad, precio, numbungalos);
            numbungalos += 1;
        }
        else{

            b = new Bungalo(nombre, capacidad, precio, numbungalos);
            numbungalos += 1;
        }
        bungalos.add(b);
        System.out.println("Bungalo " + b.getId() +  " añadido con éxito!");
    }

    /**
     * Este método elimina un bungalo.
     */
    public void eliminar_bungalo(){ //Aqui falta comprobar si el bungalo tiene reservas
        String id;
        boolean flag = false;
        int i;
        System.out.print("Introduce el id del bungalo a eliminar:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            if(id.equals(bungalos.get(i).getId())){
                flag = true;
                if(bungalos.get(i).getReserva_0().getActividades().isEmpty()){
                    System.out.println("Bungalo " + bungalos.get(i).getId() +  " eliminado con éxito!");
                    bungalos.remove(bungalos.get(i));
                }
                else{
                    System.out.println("Error: No se puede eliminar un bungalo con reservas");
                }

            }
        }
        if(!flag){
            System.out.println("Error: Bungalo no encontrado");
        }

    }

    /**
     * Este método recupera un bungalo.
     */
    public Bungalo recuperar_bungalo(){
        int i;
        String id;
        System.out.println("Introduzca el id del bungalo:");
        id = MyInput.readString();
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

    /**
     * Este método muestra los bungalos.
     */
        public String mostrarBungalos(){
        int i;
        boolean flag = false;
        String opcion="s";
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
            if(cadena_bungalos.equals("")){
                return "No hay bungalos registrados";
            }
        return cadena_bungalos;
        }

    /**
     * Este metodo agrega una reserva en dicho bungalo.
     */
        public void agregarReserva(){
            int i, j;
            boolean flagBungalo = false, flagReserva = true;
            int personas;
            String opcion, opcion2;
            String id, DNI, fechaInicioString, fechaFinString;
            LocalDate fechaInicio;
            LocalDate fechaFin;
            ArrayList<Bungalo> bungalosDisponibles = new ArrayList<Bungalo>();
            System.out.println("¿Desea reservar un bungalo adaptado (s/n)?");
            opcion = MyInput.readString();
            if(opcion.equalsIgnoreCase("s")){


            }
            System.out.println("Introduzca el DNI del cliente");
            DNI = MyInput.readString();
            System.out.println("Introduzca la fecha de comienzo de la reserva (formato AAAA-MM-DD):");
            fechaInicioString = MyInput.readString();
            fechaInicio = LocalDate.parse(fechaInicioString);
            System.out.println("Introduzca la fecha de fin de la reserva (formato AAAA-MM-DD):");
            fechaFinString = MyInput.readString();
            fechaFin = LocalDate.parse(fechaFinString);
            if(fechaInicio.isAfter(fechaFin)){
                System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin");
                return;
            }
            System.out.println("Introduzca el número de personas");
            personas = MyInput.readInt();
            System.out.println("Estos son los bungalos disponibles:");
            for(i=0;i<listaClientes.getClientes().size();i++){
                if(listaClientes.getClientes().get(i).getId().equals(DNI)){
                    if(opcion.equalsIgnoreCase("s")){   // los bungalos adaptados
                        for(i=0;i<bungalos.size();i++){
                            if(bungalos.get(i).getId().substring(0,2).equals("BA")){
                                if(bungalos.get(i).getCapacidad() >= personas) {
                                    if (bungalos.get(i).getReserva_0().getActividades().isEmpty()) {
                                        System.out.println(bungalos.get(i).getId());
                                        bungalosDisponibles.add(bungalos.get(i));
                                    } else {


                                    for (j = 0; j < bungalos.get(i).getReserva_0().getActividades().size(); j++) {
                                        if (bungalos.get(i).getReserva_0().getActividades().get(j).hayHueco(fechaInicio, fechaFin)) {
                                            System.out.println(bungalos.get(i).getId());
                                            bungalosDisponibles.add(bungalos.get(i));
                                        }

                                    }
                                    }

                                }
                            }
                        }
                    }
                    else{     // los bungalos no adaptados
                        for(i=0;i<bungalos.size();i++){
                            if(! bungalos.get(i).getId().substring(0,2).equals("BA")){
                                if(bungalos.get(i).getCapacidad() >= personas){
                                    if(bungalos.get(i).getReserva_0().getActividades().isEmpty()){
                                        System.out.println(bungalos.get(i).getId());
                                        bungalosDisponibles.add(bungalos.get(i));
                                    }
                                    else {
                                        for (j = 0; j < bungalos.get(i).getReserva_0().getActividades().size(); j++) {
                                            if (bungalos.get(i).getReserva_0().getActividades().get(j).hayHueco(fechaInicio, fechaFin)) {
                                                System.out.println(bungalos.get(i).getId());
                                                bungalosDisponibles.add(bungalos.get(i));
                                            }

                                        }

                                    }
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
                                if(opcion.equalsIgnoreCase("s")){
                                    System.out.println("Desea añadir algún servicio especial? ");

                                        System.out.println("Elija el servicio:");
                                        System.out.println("1. Asistente");
                                        System.out.println("2. Catering");
                                        System.out.println("3. Ambos");
                                        System.out.println("4. Ninguno");
                                        opcion2 = MyInput.readString();
                                        switch (opcion2){
                                            case "1":
                                                bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(new ServicioAsistente(bungalosDisponibles.get(i)), DNI, fechaInicio, fechaFin, numReservas) );
                                                numReservas += 1;
                                                System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                                flagBungalo = true;
                                                break;
                                            case "2":
                                                bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(new ServicioCatering(bungalosDisponibles.get(i)), DNI, fechaInicio, fechaFin, numReservas) );
                                                numReservas += 1;
                                                System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                                flagBungalo = true;
                                                break;
                                            case "3":
                                                bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(new ServicioCatering(new ServicioAsistente(bungalosDisponibles.get(i))), DNI, fechaInicio, fechaFin, numReservas) );
                                                numReservas += 1;
                                                System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                                flagBungalo = true;
                                                break;
                                            case "4":  //CORREGIDO AÑADO LA OPCION DE ELEGIR UN BUNGALO ADAPTADO SIN SERVICIOS
                                                bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(bungalosDisponibles.get(i), DNI, fechaInicio, fechaFin, numReservas) );
                                                numReservas += 1;
                                                System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                                flagBungalo = true;
                                                break;

                                            default:
                                                System.out.println("Opción no válida");
                                                break;

                                        }

                                }  else {
                                    bungalosDisponibles.get(i).getReserva_0().getActividades().add(new ReservaBungalo(bungalosDisponibles.get(i), DNI, fechaInicio, fechaFin, numReservas));
                                    numReservas += 1;
                                    System.out.println("Reserva " + bungalosDisponibles.get(i).getReserva_0().getActividades().getLast().getId() + " añadida con éxito");
                                    flagBungalo = true;
                                }

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

    /**
     * Este método elimina una reserva.
     */
        public void eliminarReserva(){
        int i, j;
        String id;
        boolean flag = false;
        Bungalo b = null;
        System.out.println("Introduce el id del bungalo del que se quiere eliminar la reserva:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            if(bungalos.get(i).getId().equals(id)){
                b = bungalos.get(i);
                if(b == null){
                    System.out.println("Error: Bungalo no encontrado");
                    return;
                }
                System.out.println("Reservas disponibles del bungalo " + b.getId() + ":");
                for(j=0;j<b.getReserva_0().getActividades().size();j++){
                    System.out.println(b.getReserva_0().getActividades().get(j).getId());
                }
            }
        }
        System.out.println("Introduzca el id de la reserva que se quiere cancelar:");
        id = MyInput.readString();
        for(i=0;i<b.getReserva_0().getActividades().size();i++){
            if(b.getReserva_0().getActividades().get(i).getId().equals(id)){
                if(b.getReserva_0().getActividades().get(i).getFechaInicio().isAfter(LocalDate.now())){
                    b.getReserva_0().getActividades().remove(i);
                    System.out.println("Reserva " + id + " cancelada con éxito");
                    flag = true;
                }
                else{
                    System.out.println("No se puede cancelar una reserva que ya ha comenzado");
                }

            }
        }
        if(!flag){
            System.out.println("Error: Actividad no encontrada");
        }

        }

    /**
     * Este método agrega una actividad a la reserva.
     */
        public void agregarActividad(){
        int i, j, participantes;
        String id;
        Reserva r = null;
        Bungalo b = null;
        Actividad a = null;
        LocalDate fechaInicio, fechaFin ;
        String fechaInicioString, fechaFinString;
        System.out.println("Reservas disponibles:");
        for(i=0;i<bungalos.size();i++){
            if(!bungalos.get(i).getReserva_0().getActividades().isEmpty()){
                System.out.println(bungalos.get(i).getId() + ":");
                System.out.println();
            }

            for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                System.out.println(bungalos.get(i).getReserva_0().getActividades().get(j).getId());
            }
            System.out.println();
        }
        System.out.println("Introduzca el id de la reserva a la que quiere añadir una actividad");
        id = MyInput.readString();
        System.out.println("Introduzca el número de participantes:");
        participantes = MyInput.readInt();
        System.out.println("Introduzca la fecha de comienzo de la reserva:");
        fechaInicioString = MyInput.readString();
        fechaInicio = LocalDate.parse(fechaInicioString);
        System.out.println("Introduzca la fecha de fin de la reserva:");
        fechaFinString = MyInput.readString();
        fechaFin = LocalDate.parse(fechaFinString);



        for(i=0;i<bungalos.size();i++){
            for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                if(bungalos.get(i).getReserva_0().getActividades().get(j).getId().equals(id)){
                    r = bungalos.get(i).getReserva_0().getActividades().get(j); // EL SEGUNDO GET i ES UN j CORREGIDO
                    if(r.getFechaInicio().isAfter(fechaInicio) || r.getFechaFin().isBefore(fechaFin)){
                        System.out.println("Error: La fecha de la actividad no puede estar fuera de la reserva");
                        return;
                    }
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
        if(a == null){
            System.out.println("Error: Actividad no encontrada");
        }
        }

    /**
     * Este método elimina una actividad de la reserva.
     */
        public void eliminarReservaActividad(){
        int i, j, k;
        boolean flag = false;
        String id;
            System.out.println("Reservas disponibles:");
            for(i=0;i<bungalos.size();i++){
                if(!bungalos.get(i).getReserva_0().getActividades().isEmpty()){
                    for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                        if(!bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().isEmpty()){
                            System.out.println(bungalos.get(i).getReserva_0().getActividades().get(j).getId() + ":");
                            System.out.println();
                            for(k=0;k<bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().size();k++){
                                System.out.println(bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().get(k).getActividad().getId());
                            }
                            System.out.println();
                        }

                    }
                }
            }
            System.out.println("Introduzca la reserva con la actividad a cancelar:");
            id = MyInput.readString();
            for(i=0;i<bungalos.size();i++){
                for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                    if(bungalos.get(i).getReserva_0().getActividades().get(j).getId().equals(id)){
                        flag = true;
                        System.out.println("Introduzca la actividad que desea cancelar:");
                        id = MyInput.readString();
                        for(k=0;k<bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().size();k++){
                            if(bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().get(k).getActividad().getId().equals(id)){
                                if(bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().get(k).getFechaInicio().isAfter(LocalDate.now())){
                                    bungalos.get(i).getReserva_0().getActividades().get(j).getActividades().remove(k);
                                    System.out.println("Actividad cancelada con éxito");
                                }
                                else{
                                    System.out.println("No se puede eliminar una actividad que ya ha comenzado");
                                }

                            }
                        }
                    }
                }
            }
            if(!flag){
                System.out.println("Error: Datos no encontrados");
            }


        }

    /**
     * Este método lista las reservas de un bungalo.
     */
        public void listarReservasBungalo(){
        int i, j;
        String id;
        boolean flagBungalo = false;
        Bungalo b = null;
        System.out.println("Introduzca el id del bungalo:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            if(bungalos.get(i).getId().equals(id)){
                b = bungalos.get(i);
                flagBungalo = true;
                if(b.getReserva_0().getActividades().isEmpty()){
                    System.out.println("El bungalo no tiene reservas");
                }
                else{
                    for(j=0;j<b.getReserva_0().getActividades().size();j++){
                        System.out.println(b.getReserva_0().getActividades().get(j).getId());
                    }
                }

            }
        }
        if(!flagBungalo){
            System.out.println("El bungalo no se ha encontrado");
        }
        }

    /**
     * Este método lista las reservas de un cliente.
     */
        public void listarReservaDNI(){
        int i, j;
        String DNI;
        boolean flag = false;
        System.out.println("Introduzca el DNI del cliente:");
        DNI = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++){
                if(bungalos.get(i).getReserva_0().getActividades().get(j).getCliente().equals(DNI)){
                    System.out.println(bungalos.get(i).getReserva_0().getActividades().get(j).getId());
                }
            }
        }
        if(!flag){
            System.out.println("Error: Cliente no encontrado");
        }
        }

    /**
     * Este método muestra la información de una reserva.
     */
        public void infoReserva(){
        int i, j, k;
        String id;
        Reserva r = null;
        System.out.println("Introduzca el id de la reserva:");
        id = MyInput.readString();
        for(i=0;i<bungalos.size();i++){
            for(j=0;j<bungalos.get(i).getReserva_0().getActividades().size();j++)
            {
                if(bungalos.get(i).getReserva_0().getActividades().get(j).getId().equals(id)){
                    r = bungalos.get(i).getReserva_0().getActividades().get(j);
                    System.out.println("ID: " + r.getId() + " Cliente: " + r.getCliente() + " Fecha inicio: "+ r.getFechaInicio() + " Fecha fin: " + r.getFechaFin());
                    if(!r.getActividades().isEmpty()){
                        System.out.println("Actividades reservadas: ");
                        for(k=0;k<r.getActividades().size();k++){
                            System.out.println(r.getActividades().get(k).getActividad().getId());
                        }
                    }

                }
            }

        }
        if(r == null){
            System.out.println("Error: Reserva no encontrada");
        }
        }

    /**
     * Este método muestra el menú de bungalos.
     */
        public void menuBungalos(){
            String s;
            do{
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Agregar bungalo");
                System.out.println("2. Eliminar bungalo");
                System.out.println("3. Listar bungalos");
                System.out.println("4. Mostrar información bungalo concreto");
                System.out.println("5. Volver al menú principal");
                s = MyInput.readString();
                switch(s){
                    case "1":
                        agregar_bungalo();
                        break;
                    case "2":
                        eliminar_bungalo();
                        break;
                    case "3":
                        System.out.println(mostrarBungalos());
                        break;
                    case "4":
                        recuperar_bungalo();
                        break;
                    case "5":
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }while(!s.equals("5"));
        }

    /**
     * Este método muestra el menú de reservas.
     */
        public void menuReservas(){
    String s;
            do{
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Agregar reserva");
                System.out.println("2. Eliminar reserva");
                System.out.println("3. Listar reservas de un bungalo");
                System.out.println("4. Listar reservas de un cliente");
                System.out.println("5. Mostrar información de una reserva");
                System.out.println("6. Añadir actividad a una reserva");
                System.out.println("7. Eliminar actividad de una reserva");
                System.out.println("8. Volver al menú principal");
                s = MyInput.readString();
                switch(s){
                    case "1":
                        agregarReserva();
                        break;
                    case "2":
                        eliminarReserva();
                        break;
                    case "3":
                        listarReservasBungalo();
                        break;
                    case "4":
                        listarReservaDNI();
                        break;
                    case "5":
                        infoReserva();
                        break;
                    case "6":
                        agregarActividad();
                        break;
                    case "7":
                        eliminarReservaActividad();
                        break;
                    case "8":
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }while(!s.equals("8"));

        }
        }







