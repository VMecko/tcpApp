package cz.muni.fi;

/**
 * Created by V.Mecko on 22.6.2017.
 */
public class AppMain {
    public static void main(String [] args){
        ConnectionHandlerImpl conn = new ConnectionHandlerImpl();
        conn.communicate();
    }
}
