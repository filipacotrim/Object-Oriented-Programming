package woo.app.main;

import java.security.InvalidKeyException;

import pt.tecnico.po.ui.Command;                                                                                              
import pt.tecnico.po.ui.DialogException;                                                                                                     
import pt.tecnico.po.ui.Input;                                                                                                              
import woo.Storefront;       
import woo.exceptions.InvalidDaysException;  

import woo.app.exceptions.InvalidDateException;

/**
 * Advance current date.
 */
public class DoAdvanceDate extends Command<Storefront> {
  
  private Input<Integer> _days;

  /**
   * @param receiver
   */
  public DoAdvanceDate(Storefront receiver) {
    super(Label.ADVANCE_DATE, receiver);
    _days = _form.addIntegerInput(Message.requestDaysToAdvance());
  }

  /**
   * @throws DialogException
   */
  @Override
  public final void execute() throws DialogException {
    _form.parse();
    try {
      _receiver.advanceCurrentDate(_days.value());
    } catch (InvalidDaysException e) {
      throw new InvalidDateException(_days.value());
    }
  }
}
