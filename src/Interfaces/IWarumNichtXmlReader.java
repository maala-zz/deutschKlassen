/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ASUS
 */
public interface IWarumNichtXmlReader {

    String getRootName() throws Exception;

    ArrayList getLessonsLinksWithTag(String tag) throws IOException,SAXException, ParserConfigurationException;
}
