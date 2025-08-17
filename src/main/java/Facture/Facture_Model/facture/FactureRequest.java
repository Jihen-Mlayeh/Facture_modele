package Facture.Facture_Model.facture;


import Facture.Facture_Model.ligneFacture.LigneFacture;
import Facture.Facture_Model.ligneFacture.LigneFactureRequest;
import Facture.Facture_Model.ligneFacture.LigneFactureResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactureRequest { // FactureRequest : recevoir les données envoyées par le client
   private Long clientId;
    @NotNull(message = "la date ne doit pas étre vide")
    private LocalDate date;
    @Size(min=1)
    private List<LigneFactureRequest> lignesFactures;
}
