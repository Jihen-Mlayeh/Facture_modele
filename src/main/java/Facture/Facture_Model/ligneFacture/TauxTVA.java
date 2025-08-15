package Facture.Facture_Model.ligneFacture;

import lombok.Getter;


@Getter
public enum TauxTVA {
    TVA_0(0.0),
    TVA_5(5.5),
    TVA_10(10.0),
    TVA_20(20.0);
     private final double valeurTVA;
    TauxTVA(double valeurTVA) {
        this.valeurTVA = valeurTVA;
    }

}
