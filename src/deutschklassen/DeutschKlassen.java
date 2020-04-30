/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deutschklassen;

import Interfaces.IWarumNichtXmlReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeutschKlassen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String file = "F:\\Deutsch\\dk.xml";
        IWarumNichtXmlReader reader = new WarumNichtXmlReader(file);
    }

}
