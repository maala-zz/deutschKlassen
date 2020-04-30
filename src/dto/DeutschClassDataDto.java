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
public class DeutschClassDataDto {

    //<editor-fold defaultstate="collapsed" desc="Proprties">
    public String url;
    public String title;
    public String desc;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public DeutschClassDataDto() {

    }

    public DeutschClassDataDto(String url, String title, String desc) {
        this.url = url;
        this.desc = desc;
        this.title = title;
    }
//</editor-fold>
}
