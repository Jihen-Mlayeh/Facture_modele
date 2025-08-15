package Facture.Facture_Model.ligneFacture;

import org.springframework.stereotype.Service;

@Service
public class LigneFactureMapper {
    public LigneFacture mapToLigneFactureEntity(LigneFactureRequest ligneFactureRequest){
        return LigneFacture.builder()
                .description(ligneFactureRequest.getDescription())
                .prixUnitaireHT(ligneFactureRequest.getPrixUnitaireHT())
                .tauxTVA(ligneFactureRequest.getTauxTVA())
                .quantite(ligneFactureRequest.getQuantite())
                .build();
    }
    public LigneFactureResponse mapToLigneFactureResponse(LigneFacture ligneFacture){
        return LigneFactureResponse.builder()
                .id(ligneFacture.getId())
                .description(ligneFacture.getDescription())
                .prixUnitaireHT(ligneFacture.getPrixUnitaireHT())
                .quantite(ligneFacture.getQuantite())
                .tauxTVA(ligneFacture.getTauxTVA())
                .build();
    }
}
