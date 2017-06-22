package cz.muni.fi;

/**
 * Created by V.Mecko on 22.6.2017.
 */
public interface ConnectionHandler {
    /**
     * @brief serves as the main method for TCP communication
     *        between client and server. Repeatedly reads users input
     *        sends it to server and prints answer.
     */
    void communicate();
}

