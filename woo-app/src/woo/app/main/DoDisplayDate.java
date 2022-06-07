package woo.app.main;

import pt.tecnico.po.ui.Command;                                                                                                      
import pt.tecnico.po.ui.DialogException;                                                                                                      
import pt.tecnico.po.ui.Input;                                                                                                                
import woo.Storefront;                                                                                                                       

/**
 * Show current date.
 */
public class DoDisplayDate extends Command<Storefront> {

  /**
   * @param receiver
   */
  public DoDisplayDate(Storefront receiver) {
    super(Label.SHOW_DATE, receiver);
    
  }

  /**
   * @throws DialogException
   */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    _display.addLine(Message.currentDate(_receiver.getCurrentDate()));
    _display.display();
  }
}
