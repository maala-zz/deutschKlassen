/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deutschklassen;

import Interface.IDownloader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author ASUS
 */
public class Downloader implements IDownloader {

    //<editor-fold defaultstate="collapsed" desc="Proprties">
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Downloader() {

    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Methods">

    @Override
    public void downloadHtmlPage(String webPage, String downloadedFileName) throws MalformedURLException, IOException {
        try {

            // Create URL object 
            URL url = new URL(webPage);

            BufferedReader readr
                    = new BufferedReader(new InputStreamReader(url.openStream()));

            // Enter filename in which you want to download 
            BufferedWriter writer
                    = new BufferedWriter(new FileWriter("downloads/"+downloadedFileName + ".html"));

            // read each line from stream till end 
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        } // Exceptions 
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        } catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

//</editor-fold>
}
