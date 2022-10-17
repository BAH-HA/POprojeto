package prr.core.exception;

import java.io.Serial;

/**
 * Exception for unknown clients.
 */
public class UnknownClientKeyException extends Exception {

  /** Serial number (serialization) */
  @Serial
  private static final long serialVersionUID = 202208091753L;

  /** Search key */
  private String key;

  public UnknownClientKeyException(String key) {
    this.key = key;
  }

  public String key() {
    return key;
  }
}