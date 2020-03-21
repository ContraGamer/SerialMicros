/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialpc;

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.Timer;

/**
 *
 * @author Contr
 */
public class ConexionServicios {
    
    private SerialPort port;
    private InputStream in;
    private OutputStream out;
    public Timer timer;
    public String concat = "";

    /**
     * Servicio que obtiene el puerto selecionado o accede al primer puerto de
     * la lista.
     *
     * @param port
     * @throws IOException
     */
    public void obtenerPuertoSeleccionado(SerialPort port) throws IOException {
        
        if (null == port) {
            this.port = SerialPort.getCommPorts()[0];
        } else {
            this.port = port;
        }
        if (abrirPuerto()) {
            //esta linea setea los parametros principales que debe ir en configuraciones
            //this.port.setComPortParameters(0, 0, 0, 0);
            //this.port.setNumStopBits(0);
            String configuracion = "";
            configuracion = configuracion.concat("Conexion establecida con: " + this.port.getDescriptivePortName());
            configuracion = configuracion.concat("\n Velocidad: " + this.port.getBaudRate());
            configuracion = configuracion.concat("\n Paridad: " + this.port.getParity());
            configuracion = configuracion.concat("\n DataBits: " + this.port.getNumDataBits());
            configuracion = configuracion.concat("\n StopBits: " + this.port.getNumStopBits());
            configuracion = configuracion.concat("\n Tiempo de Lectura: " + this.port.getReadTimeout());
            configuracion = configuracion.concat("\n Tiempo de Escritura: " + this.port.getWriteTimeout());
            configuracion = configuracion.concat("\n CTS: " + this.port.getCTS());
            configuracion = configuracion.concat("\n DSR: " + this.port.getDSR());
            System.out.println(configuracion);
            recibirDatos();
        }
    }

    /**
     * Serivicio que abre el puerto selecionado.
     *
     * @return
     */
    public boolean abrirPuerto() {
        try {
            this.port.openPort();
            this.in = this.port.getInputStream();
            this.out = this.port.getOutputStream();
            if (this.port.isOpen()) {
                return true;
            } else {
                System.out.println("Error: Puerto no encontrado.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
        
    }

    /**
     * Servicio que cierra el puerto Selecionado.
     */
    public void cerrarPuerto() {
        if (null != this.port) {
            this.timer.stop();
            this.port.removeDataListener();
            this.port.closePort();
        }
    }

    /**
     * Servicio que recibe los datos del puerto.
     *
     * @throws IOException
     */
    public String recibirDatos() throws IOException {
        
        String valor;
        while (in.available() > 0) {
            concat = "";
            for (int i = 0; i < this.port.bytesAvailable(); i++) {
                char c = (char) in.read();
                valor = Character.toString(c);
                concat = concat.concat(valor);
                //System.out.println(concat);

            }
            return concat;
        }

        //vista2.pintarAreaTexto(concat);
        return "";
    }

    /**
     * Servicio que envia los datos por el puerto.
     *
     * @param datos
     * @throws IOException
     */
    public void enviarDatos(String datos) throws IOException {
        this.out.write(datos.getBytes());
    }

    /**
     * Servicio que muestra el estado de conexión con el puerto.
     *
     * @return
     */
    public boolean estadoConexion() {
        if (null != this.port) {
            return this.port.isOpen();
        } else {
            return false;
        }
    }
    
}
