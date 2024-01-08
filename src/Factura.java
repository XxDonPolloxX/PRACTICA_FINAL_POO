import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase representa una factura de un cliente de un bungalo con sus actividades asociadas.
 * @author Adrián Santiuste Gil y Diego García Santos.
 */
public class Factura implements java.io.Serializable{
    private String id;
    //nuevo adri
    private ArrayList<String> conceptos;
    private float costeTotal;
    private LocalDate fechaFacturacion;
    private Cliente cliente;
    private Reserva reservas;

    /**
     * Este es el constructor de la clase.
     * @param c es el cliente al que se le va a facturar.
     * @param precio es el precio de la factura.
     * @param fecha_factura es la fecha de la factura.
     * @param reservas es la reserva asociada a la factura.
     * @param numFactura es el número de factura que se ha creado.
     * @param conceptoInicial es el concepto inicial de la factura.
     */
    public Factura(Cliente c, float precio, LocalDate fecha_factura, Reserva reservas, int numFactura, ArrayList<String> conceptoInicial){
        id = calcular_id(numFactura);
        conceptos = new ArrayList<>();
        cliente = c;
        this.reservas = reservas;
        costeTotal = precio;
        fechaFacturacion = fecha_factura;

        conceptos.add("Factura de reserva: " + reservas.getId() + " cliente: " + cliente.getNombre() +  " con DNI: " + cliente.getId() + " con fecha de facturación: " + fechaFacturacion );
        conceptos.addAll(conceptoInicial);
        for(int i = 0; i < reservas.getActividades().size(); i++){
            conceptos.add("Actividad: " + reservas.getActividades().get(i).getActividad().getDescripcion() + " con precio: " + reservas.getActividades().get(i).getPrecio());
            conceptos.add("Fecha de inicio: " + reservas.getActividades().get(i).getFechaInicio() + " Fecha de fin: " + reservas.getActividades().get(i).getFechaFin());
            conceptos.add("Precio actividad: " + reservas.getActividades().get(i).getPrecio());

        }

        conceptos.add("Precio total: " + costeTotal);
    }

    /**
     * Este método devuelve el id de la factura.
     */
    public String getId(){return id;}

    /**
     * Este método devuelve el cliente de la factura.
     */
    public Cliente getCliente(){return cliente;}

    /**
     * Este método devuelve la fecha de facturación de la factura.
     */
    public LocalDate getFechaFacturacion(){return fechaFacturacion;}

    /**
     * Este método devuelve las reservas de la factura.
     */
    public Reserva getReservas(){return reservas;}

    /**
     * Este método devuelve el coste total de la factura.
     */
    public float getCosteTotal(){return costeTotal;}

    /**
     * Este metodo calcula el id de la factura.
     * @param numFactura es el número de factura que se ha creado.
     */
    public String calcular_id(int numFactura){
        String id, idf = "";
        int i;
        id = Integer.toString(numFactura);
        for (i=0;i<8-id.length();i++){
            idf = idf + "0";
        }
        idf = idf + id;

        return idf;
    }

    /**
     * Este método muestra la factura.
     */
    public void mostrarFactura(){
        int i;
        for(i=0;i<conceptos.size();i++){
            System.out.println(conceptos.get(i));
        }
    }


}
