package main;

import java.sql.SQLException;

import controller.Controller;
import model.Model;
import view.View;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws SQLException {
        final int WidthMap = 20;
        final int HeightMap = 12;
        final Model model = new Model(WidthMap, HeightMap);
        final Controller Controller = new Controller(model);
        final ViewFacade View = new ViewFacade(Controller, model, model);
        
        
        Controller.play();
        }
    }


