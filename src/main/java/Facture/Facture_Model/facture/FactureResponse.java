package Facture.Facture_Model.facture;

import Facture.Facture_Model.client.Client;
import Facture.Facture_Model.ligneFacture.LigneFacture;
import Facture.Facture_Model.ligneFacture.LigneFactureResponse;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FactureResponse {

    private Long id;
    private Long clientId;
    private LocalDate date;
    private List<LigneFactureResponse> lignesFactures;
    private double totaleHT;
    private double totaleTVA;
    private double totaleTTC;
}
