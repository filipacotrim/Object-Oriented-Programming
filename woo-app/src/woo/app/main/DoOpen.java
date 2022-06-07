package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;
import woo.exceptions.UnavailableFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import woo.app.exceptions.FileOpenFailedException;



/**
 * Open existing saved state.
 */
public class DoOpen extends Command<Storefront> {

  private Input<String> _filename;

  /** @param receiver */
  public DoOpen(Storefront receiver) {
    super(Label.OPEN, receiver);
    _filename = _form.addStringInput(Message.openFile());
  }

  /**
   * @throws DialogException
   */
  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.load(_filename.value());
    } catch (UnavailableFileException ufe) {
      throw new FileOpenFailedException(ufe.getFilename());
    } catch (ClassNotFoundException e) {
      throw new FileOpenFailedException(_filename.value());
    } catch (FileNotFoundException e) {
      throw new FileOpenFailedException(_filename.value());
    } catch (IOException e) {
      throw new FileOpenFailedException(_filename.value());
    }
  }

}
