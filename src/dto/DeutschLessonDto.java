/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ASUS
 */
public class DeutschLessonDto {

//<editor-fold defaultstate="collapsed" desc="Proprties">
    public String mp3FileLink;
    public String pdfFileLink;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructors">
    public DeutschLessonDto() {

    }

    public DeutschLessonDto(String mp3, String pdf) {
        this.mp3FileLink = mp3;
        this.pdfFileLink = pdf;
    }
//</editor-fold>

}
