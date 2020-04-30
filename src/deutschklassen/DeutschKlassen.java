/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deutschklassen;

import Interface.IDownloader;
import Interface.IWarumNichtXmlReader;
import Interface.IWebPageHandler;
import dto.DeutschChapterDataDto;
import dto.DeutschLessonDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

public class DeutschKlassen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ExecutorService pool = Executors.newFixedThreadPool(5);
            String xmlFile = ".\\xml\\dk.xml";

            IWarumNichtXmlReader reader = new WarumNichtXmlReader(xmlFile);

            ArrayList<DeutschChapterDataDto> classesData = reader.getLessonsLinksWithTag("item");

//            IDownloader downloader = new Downloader();
//            for (int i = 0; i < classesData.size(); ++i) {
//                DeutschChapterDataDto classData = classesData.get(i);
//                downloader.downloadHtmlPageAsync(classData.url, classData.title);
//            }
            for (int i = 0; i < classesData.size(); ++i) {
                DeutschChapterDataDto chapter = classesData.get(i);
                WebPageHandler classesHandler = new WebPageHandler();
                Document doc = classesHandler.parseHtmlPageToDoc(chapter.url);
                //DeutschLessonDto lesson = classesHandler.fetchPdfAndMp3FilesLinks();
                Future<DeutschLessonDto> lessonResult = pool.submit(classesHandler);
                System.out.println(lessonResult.get());
            }

        } catch (Exception ex) {
            Logger.getLogger(DeutschKlassen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
