package Facture.Facture_Model.facture;

import Facture.Facture_Model.ligneFacture.LigneFacture;
import Facture.Facture_Model.ligneFacture.LigneFactureMapper;
import Facture.Facture_Model.ligneFacture.LigneFactureResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FactureMapper {
    // mapper une ligne facteur request en ligne facteur
    private final LigneFactureMapper ligneFactureMapper;
    public Facture mapToFactureEntity(FactureRequest factureRequest){
        List<LigneFacture> lignes=factureRequest.getLignesFactures()
                .stream()
                .map(ligneFactureMapper::mapToLigneFactureEntity)
                .collect(Collectors.toList());
        return Facture.builder()
                .date(factureRequest.getDate())
                .lignesFactures(lignes)
                .build();
    }
    // mapper une facture en facture response
    public FactureResponse mapToFactureResponse(Facture facture){
        List<LigneFactureResponse> lignes =facture.getLignesFactures().stream().map(
                l->new LigneFactureResponse(
                        l.getId(),
                        l.getDescription(),
                        l.getQuantite(),
                        l.getPrixUnitaireHT(),
                        l.getTauxTVA()))
                .collect(Collectors.toList());

        return FactureResponse.builder()
                .id(facture.getId())
                .clientId(facture.getClient().getId())
                .date(facture.getDate())
                .lignesFactures(lignes)
                .totaleHT(facture.getTotaleHT())
                .totaleTTC(facture.getTotaleTTC())
                .totaleTVA(facture.getTotaleTVA())
                .build();
    }
}
