/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import dto.DeutschLessonDto;
import org.jsoup.nodes.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ASUS
 */
public interface IWebPageHandler {

    DeutschLessonDto fetchPdfAndMp3FilesLinks();

    Document parseHtmlPageToDoc(String htmlLink);

}
