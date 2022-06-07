package woo.app.main;

import java.io.IOException;

import java.io.File;

import pt.tecnico.po.ui.Command;                                                          
import pt.tecnico.po.ui.DialogException;                                                                                                      
import pt.tecnico.po.ui.Input;                                                                                                                
import woo.Storefront;
import woo.exceptions.MissingFileAssociationException;                                                                                                                        
                                                                                                          
/**
 * Save current state to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Storefront> {

  private Input<String> _filename;

  /** @param receiver */
  public DoSave(Storefront receiver) {
    super(Label.SAVE, receiver);
    //if file does not exist 
    if (_receiver.getFileName() == "") {
      _filename = _form.addStringInput(Message.newSaveAs());
    }
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    if (_receiver.getSave()) {
      try {
      if (_receiver.getFileName() == "") {
         _form.parse();
         _receiver.setFileName(_filename.value());
         _receiver.save();
      }
      else {
        _receiver.saveAs(_receiver.getFileName());
      }
     } catch (IOException | MissingFileAssociationException e) {
      e.printStackTrace();
    }
    }
  }
}