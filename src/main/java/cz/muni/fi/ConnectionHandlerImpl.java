package cz.muni.fi;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

/**
 * Created by V.Mecko on 22.6.2017.
 */
public class ConnectionHandlerImpl implements ConnectionHandler{
    private Properties prop;

    public ConnectionHandlerImpl(){
        prop = getProperties();
    }

    private Properties getProperties(){
        Properties properties = new Properties();
        try(InputStream in = getClass().getClassLoader().getResourceAsStream("conf.properties"))
        {
            properties.load(in);
        } catch(IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public void communicate() {
        try(Socket tcpSocket = new Socket(prop.getProperty("tcp.server"),Integer.parseInt(prop.getProperty("tcp.port")));
            PrintWriter tcpOut = new PrintWriter(tcpSocket.getOutputStream(),true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader tcpIn = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()))
        ) {
            String stdInData;
            while((stdInData = stdIn.readLine()) != null){
                tcpOut.println(stdInData);
                System.out.println(tcpIn.readLine());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

