package prr.core.exception;

import java.io.Serial;

/** Exception thrown when a client key is duplicated. */
public class DuplicateClientKeyException extends Exception {
  
  private static final long serialVersionUID = 202208091753L;
  
  private final String key;

  public DuplicateClientKeyException(String key) {
    this.key = key;
  }

  public String key() {
    return key;
  }
}
