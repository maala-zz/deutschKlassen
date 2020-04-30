/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deutschklassen;

import Interface.IWebPageHandler;
import dto.DeutschLessonDto;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.concurrent.*;

public class WebPageHandler implements IWebPageHandler, Callable<DeutschLessonDto> {

//<editor-fold defaultstate="collapsed" desc="Properties">
    private Document doc;
    public DeutschLessonDto lesson;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public WebPageHandler() {
        lesson = new DeutschLessonDto();
    }
//</editor-fold>

    @Override
    public DeutschLessonDto fetchPdfAndMp3FilesLinks() {
        DeutschLessonDto res = new DeutschLessonDto();
        res.pdfFileLink = fetchPdfLink();
        res.mp3FileLink = fetchMp3Link();
        System.out.println("pdf " + res.pdfFileLink);
        System.out.println("mp3 " + res.mp3FileLink);
        return res;
    }

    @Override
    public Document parseHtmlPageToDoc(String htmlLink) {
        try {
            doc = Jsoup.connect(htmlLink).get();
            String title = doc.title();
            System.out.println(title);
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String fetchPdfLink() {
        try {
            Element aRef = doc.body().getElementsByAttributeValueEnding("href", ".pdf").first();
            String inspectLink = aRef.attr("href");
            return inspectLink;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private String fetchMp3Link() {
        try {
            Element aRef = doc.body().getElementsByAttributeValueEnding("class", "overlayLink").first();
            String inspectLink = aRef.attr("href");
            return inspectLink;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    @Override
    public DeutschLessonDto call() throws Exception {
        try {
            DeutschLessonDto lesson = fetchPdfAndMp3FilesLinks();
            return lesson;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
