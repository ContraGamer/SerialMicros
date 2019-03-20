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
import java.util.Timer;


/**
 *
 * @author Contr
 */
public class SerialPC {

    SerialPort comPort;

    Timer timer = new Timer();

    public void recibirDatos(String puerto) {
        //DatosConexion datos = abrirPuerto(puerto);
        comPort = null;
        DatosConexion datos = new DatosConexion();
        for (SerialPort conn : SerialPort.getCommPorts()) {
            if (conn.getDescriptivePortName().equalsIgnoreCase(puerto)) {
                comPort = conn;
            } else {
                System.out.println("Error: Puerto no encontrado.");
            }
        }

        comPort.openPort();
        datos.setComPort(comPort);
        datos.setIn(comPort.getInputStream());
        datos.setOut(comPort.getOutputStream());
        
        //System.out.println(comPort.getDescriptivePortName() + " : " + comPort.getPortDescription());
        //System.out.println(datos.getComPort().isOpen());
        //setComPort(comPort);
        //comPort.openPort();
        //comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        InputStream in = datos.getComPort().getInputStream();
        OutputStream out = datos.getComPort().getOutputStream();
        String concat = "";
        //datos.getComPort().closePort();
        //System.out.println(datos.getComPort().isOpen());
        try {

            String valor;
            //for (int i = 0; i < 50; i++) {
            //out.write("1".getBytes());
            while (in.available() > 0) {
                char c = (char) in.read();
                valor = Character.toString(c);
                concat = concat.concat(valor);
            }
            System.out.println(concat);
            //}

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

//        TimerTask comunicaXSeg = new TimerTask() {
//            @Override
//            public void run() {
//                String concat = "";
//
//                try {
//
//                    String valor;
//                    //for (int i = 0; i < 50; i++) {
//                    out.write("1".getBytes());
//                    while (in.available() > 0) {
//                        char c = (char) in.read();
//                        valor = Character.toString(c);
//                        concat = concat.concat(valor);
//                    }
//                    System.out.println(concat);
//                    //}
//
//                } catch (IOException e) {
//                    System.out.println("Error: " + e.getMessage());
//                }
//            }
//        };
//        timer.schedule(comunicaXSeg, 0, 1000);
    }

    public void cerrarConexion() {

    }

    public DatosConexion abrirPuerto(String puerto) {
        comPort = null;
        DatosConexion datos = new DatosConexion();
        for (SerialPort conn : SerialPort.getCommPorts()) {
            if (conn.getDescriptivePortName().equalsIgnoreCase(puerto)) {
                comPort = conn;
            } else {
                System.out.println("Error: Puerto no encontrado.");
            }
        }

        comPort.openPort();
        datos.setComPort(comPort);
        datos.setIn(comPort.getInputStream());
        datos.setOut(comPort.getOutputStream());

        return datos;
    }

}
