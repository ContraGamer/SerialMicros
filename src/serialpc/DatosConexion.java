/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialpc;

import com.fazecast.jSerialComm.SerialPort;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;

/**
 *
 * @author Contr
 */
public class DatosConexion {

    private SerialPort comPort;
    private Timer timer = new Timer();
    private InputStream in;
    private OutputStream out;

    public DatosConexion() {

    }

    public DatosConexion(SerialPort comPort) {
        this.comPort = comPort;
    }

    public SerialPort getComPort() {
        return comPort;
    }

    public void setComPort(SerialPort comPort) {
        this.comPort = comPort;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

}
