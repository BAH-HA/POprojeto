package prr.core;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import prr.core.exception.ImportFileException;
import prr.core.exception.MissingFileAssociationException;
import prr.core.exception.UnavailableFileException;
import prr.core.exception.UnrecognizedEntryException;

/**
 * Manage access to network and implement load/save operations.
 */
public class NetworkManager {

  /** Name of the file storing the Network */
  private String _filename = "";

  /** The network itself. */
  private Network _network = new Network();
  
  public Network getNetwork() {
    return _network;
  }

  public String getFilename() {
    return _filename;
  }

  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   */
  public void load(String filename) throws UnavailableFileException, ClassNotFoundException {
    _filename = filename;
    try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filename))) {
      _network = (Network)objectIn.readObject();
      _filename = (String)objectIn.readObject();
    } catch (ClassNotFoundException | IOException e) {
      throw new UnavailableFileException(filename);
    }
  }
  
  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened. 
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    if (_filename == null) {
      throw new MissingFileAssociationException();
    }
    try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(_filename))) {
      objectOut.writeObject(_network);
      objectOut.writeObject(_filename);
    }
  }
  
  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to  this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   */
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
     _filename = filename; 
    save();
  }
  
  /**
   * Read text input file and create domain entities..
   * 
   * @param filename name of the text input file
   * @throws ImportFileException
   */
  public void importFile(String filename) throws ImportFileException {
    try {
      _network.importFile(filename);
    } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(filename, e);
    }
  }  
}
