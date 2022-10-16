package prr.app.client;

import prr.core.Network;
import prr.app.exception.DuplicateClientKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Register new client.
 */
class DoRegisterClient extends Command<Network> {

  DoRegisterClient(Network receiver) {
    super(Label.REGISTER_CLIENT, receiver);
    addStringField("key", Message.key());
    addStringField("name", Message.name());
    addIntegerField("taxNumber", Message.taxId());
  }

  @Override
  protected final void execute() throws CommandException {
    int taxNumber = integerField("taxNumber");
    String name = stringField("name");
    String key = stringField("key");

    try {
      _receiver.registerClient(name, taxNumber, key);
    } catch (Exception e) {
      throw new DuplicateClientKeyException(key);
    }
  }
}
