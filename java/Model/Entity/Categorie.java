/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Entity;

/**
 *
 * @author isi
 */
public class Categorie {
    String idCatagorie;
    String titleCatg;
    String descriptionCatg;

    public Categorie() {
    }

    public Categorie(String idCatagorie, String titleCatg, String descriptionCatg) {
        this.idCatagorie = idCatagorie;
        this.titleCatg = titleCatg;
        this.descriptionCatg = descriptionCatg;
    }

    public String getIdCatagorie() {
        return idCatagorie;
    }

    public void setIdCatagorie(String idCatagorie) {
        this.idCatagorie = idCatagorie;
    }

    public String getTitleCatg() {
        return titleCatg;
    }

    public void setTitleCatg(String titleCatg) {
        this.titleCatg = titleCatg;
    }

    public String getDescriptionCatg() {
        return descriptionCatg;
    }

    public void setDescriptionCatg(String descriptionCatg) {
        this.descriptionCatg = descriptionCatg;
    }

}
