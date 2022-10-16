package prr.core;

import java.io.Serializable;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import prr.core.exception.UnrecognizedEntryException;
import prr.core.Client;
import prr.core.Terminal;

// FIXME add more import if needed (cannot import from pt.tecnico or prr.app)

/**
 * Class Store implements a store.
 */
public class Network implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202208091753L;
  private List<Client> _clients;
  private List<Terminal> _terminals;

  // FIXME define attributes
  // FIXME define contructor(s)
  // FIXME define methods
  public Network(){
    _clients = new ArrayList<>();
    _terminals = new ArrayList<>();
  }
  
  /**
   * Read text input file and create corresponding domain entities.
   * 
   * @param filename name of the text input file
   * @throws UnrecognizedEntryException if some entry is not correct
   * @throws IOException if there is an IO erro while processing the text file
   */
  void importFile(String filename) throws UnrecognizedEntryException, IOException /* FIXME maybe other exceptions */  {
    //FIXME implement method
  }

  /**
   * Registers a client
   */
  public void registerClient(String name, int taxNumber, String key) {
    Client c = new Client(name, taxNumber, key);
    //System.out.println(c.toString());
    _clients.add(c);
  }

  /**
   * returns a list of all clients
   * @return
   */ 
  public List<Client> getClients(){
    return Collections.unmodifiableList(_clients);
  }
 

  /**
   * Starts a Text Communication
   *
   public void sendTextCommunication(form:Terminal from, String toKey, String msg)
  */

  /**
   * Starts an Interactive Communication
   *
  public void startInteractiveCommunication(from:Terminal, String toKey, String type) {
  */
}

