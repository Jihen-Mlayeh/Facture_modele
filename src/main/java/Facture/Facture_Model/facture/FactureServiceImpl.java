package Facture.Facture_Model.facture;

import Facture.Facture_Model.client.Client;
import Facture.Facture_Model.client.ClientRepository;
import Facture.Facture_Model.ligneFacture.LigneFacture;
import Facture.Facture_Model.ligneFacture.LigneFactureMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {
    private final FactureRepository factureRepository;
    private final FactureMapper factureMapper;
    private final ClientRepository clientRepository;
    private final LigneFactureMapper ligneFactureMapper;
    @Override
    public void createFacture(FactureRequest factureRequest) {
        if(!clientRepository.existsById(factureRequest.getClientId())){ // verification de l'existance de client avec clientID
            throw new RuntimeException("Client non existent");
        }
        Client client = clientRepository.getOne(factureRequest.getClientId()); // recuperation de le clientID
        Facture facture=factureMapper.mapToFactureEntity(factureRequest); // mapper la facture request en facture
        facture.setClient(client);
       List< LigneFacture> ligneFacture=factureRequest.getLignesFactures().stream() // mapper chaque ligne de facture request en ligne facture
                       .map(ligneReq->{
                           LigneFacture ligne=ligneFactureMapper.mapToLigneFactureEntity(ligneReq);
                           ligne.setFacture(facture);
                           return ligne;
                       }).collect(Collectors.toList());
       facture.setLignesFactures(ligneFacture);
        calculeFacture(facture);

        factureRepository.save(facture);
    }

    @Override
    public void calculeFacture(Facture facture) {
        double totalHT=calculerTotalHT(facture.getLignesFactures());
        double totalTVA=calculerTotalTVA(facture.getLignesFactures());
        double totalTTC=calculerTotalTTC(facture.getLignesFactures());
        facture.setTotaleHT(totalHT);
        facture.setTotaleTTC(totalTTC);
        facture.setTotaleTVA(totalTVA);
    }

    @Override
    public double calculerTotalHT(List<LigneFacture> lignes) {
        return lignes.stream()
                .mapToDouble(ligne->ligne.getQuantite()* ligne.getPrixUnitaireHT())
                .sum();
    }

    @Override
    public double calculerTotalTVA(List<LigneFacture> lignes) {
        return lignes.stream()
                .mapToDouble(ligne->
                        (ligne.getQuantite()* ligne.getPrixUnitaireHT())
                        *(ligne.getTauxTVA().getValeurTVA()/100))
                .sum();
    }

    @Override
    public double calculerTotalTTC(List<LigneFacture> lignes) {
        return calculerTotalHT(lignes)+calculerTotalTVA(lignes);
    }

    @Override
    public FactureResponse factureDetails(Long factureId) {
        Facture facture =factureRepository.findById(factureId).get();
        facture.getLignesFactures().size();
        return factureMapper.mapToFactureResponse(facture);
    }

    @Override
    public FactureResponse factureDetailsByDate(LocalDate factureDate) {
        Facture facture =factureRepository.findByDate(factureDate);
        facture.getLignesFactures().size();
        return factureMapper.mapToFactureResponse(facture);
    }

}
