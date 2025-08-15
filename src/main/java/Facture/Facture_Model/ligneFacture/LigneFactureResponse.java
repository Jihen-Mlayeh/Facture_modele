package Facture.Facture_Model.ligneFacture;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneFactureResponse {
    private Long id;
    private String description;
    private int quantite;
    private double prixUnitaireHT;
    private TauxTVA tauxTVA;
}
