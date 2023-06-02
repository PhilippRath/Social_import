package de.bbwfi.socialimport;
import com.google.gson.annotations.SerializedName;
public class Schule {
    @SerializedName("BEZEICHNUNG")
    public String bezeichnung;
    @SerializedName("ART")
    public String art;
    @SerializedName("STRASSE")
    public String strasse;
    @SerializedName("PLZ")
    public String plz;
    @SerializedName("ORT")
    public String ort;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
