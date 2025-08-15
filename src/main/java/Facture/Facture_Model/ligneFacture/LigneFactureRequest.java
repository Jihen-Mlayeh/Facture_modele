package Facture.Facture_Model.ligneFacture;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneFactureRequest {
    private String description;
    private int quantite;
    private double prixUnitaireHT;
    private TauxTVA tauxTVA;
}
