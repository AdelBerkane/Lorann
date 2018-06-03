package controller;

import java.sql.SQLException;
import java.util.List;

import model.Example;
import model.IModel;
import view.IView;

public class ControllerFacade implements IController {

    private final IView  view; /** The view. */
    private final IModel model; /** The model. */

    public ControllerFacade(final IView view, final IModel model) { 
        super();
        this.view = view;                  /** Instantiates a new controller facade */
        this.model = model;
        }
    public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();             
        for (final Example example : examples) {                   /** Start the SQL exception */   
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }
    public IView getView() {      /**Gets the view*/
        return this.view;
    }
    public IModel getModel() {   /** Gets the model  */
        return this.model;
    }
}
