package Facture.Facture_Model.facture;

import Facture.Facture_Model.ligneFacture.LigneFacture;

import java.util.List;

public interface FactureService {
     void createFacture(FactureRequest factureRequest);
    void calculeFacture(Facture facture);
     double calculerTotalHT(List<LigneFacture> lignes);
     double calculerTotalTVA(List<LigneFacture> lignes);
     double calculerTotalTTC(List<LigneFacture> lignes);
     FactureResponse factureDetails(Long factureId);


}
