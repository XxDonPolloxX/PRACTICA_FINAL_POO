import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Factura implements java.io.Serializable{
    private String id;
    private float costeTotal;
    private LocalDate fechaFacturacion;
    private Cliente cliente;
    private Reserva reservas;

    public Factura(Cliente c, float precio, LocalDate fecha_factura, Reserva reservas, int numFactura){
        id = calcular_id(numFactura);
        cliente = c;
        this.reservas = reservas;
        costeTotal = precio;
        fechaFacturacion = fecha_factura;


    }
    public String getId(){return id;}
    public Cliente getCliente(){return cliente;}
    public LocalDate getFechaFacturacion(){return fechaFacturacion;}
    public Reserva getReservas(){return reservas;}
    public float getCosteTotal(){return costeTotal;}
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

}
