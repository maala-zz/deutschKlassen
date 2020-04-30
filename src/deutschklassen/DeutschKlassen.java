/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deutschklassen;

import Interface.IDownloader;
import Interface.IWarumNichtXmlReader;
import dto.DeutschClassDataDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class DeutschKlassen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String file = "F:\\Deutsch\\dk.xml";
            IWarumNichtXmlReader reader = new WarumNichtXmlReader(file);
            ArrayList<DeutschClassDataDto> temp = reader.getLessonsLinksWithTag("item");
            IDownloader downloader = new Downloader();
            downloader.downloadHtmlPage("https://www.dw.com/en/chapter-23-whos-that-speaking/a-219694?maca=en-DKpodcast_dwn1_en-2257-xml-mrss", temp.get(0).title);
        } catch (IOException ex) {
            Logger.getLogger(DeutschKlassen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(DeutschKlassen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DeutschKlassen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
