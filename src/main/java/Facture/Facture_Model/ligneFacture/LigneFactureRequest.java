package Facture.Facture_Model.ligneFacture;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneFactureRequest { // LigneFactureRequest : recevoir les données envoyées par le client
    @NotBlank(message = "La description ne doit pas étre vide")
    private String description;
    @NotBlank(message = "La quantité ne doit pas étre vide")
    private int quantite;
    @NotBlank(message = "Le prix ne doit pas étre vide")
    private double prixUnitaireHT;
    @NotBlank(message = "Le tauxTVA ne doit pas étre vide")
    private TauxTVA tauxTVA;
}
