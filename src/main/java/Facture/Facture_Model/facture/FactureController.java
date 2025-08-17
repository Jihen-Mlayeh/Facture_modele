package Facture.Facture_Model.facture;

import Facture.Facture_Model.export.JsonExportService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/factures")
public class FactureController {
    private final FactureService factureService;
    private final JsonExportService jsonExportService;
     // création d'une nouvelle facture
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // retourne un code http 201 created
    public void createFacture(
            @RequestBody @Valid FactureRequest factureRequest
    ){
        factureService.createFacture(factureRequest); // appelle le service pour créer la facture
    }
    @GetMapping("/{factureId}")// récupérer une facture par son ID
    public ResponseEntity<FactureResponse> factureDetails(
            @PathVariable("factureId") Long factureId
    ){
        FactureResponse factureResponse= factureService.factureDetails(factureId);
        return ResponseEntity.ok(factureResponse);

    }// récupérer une facture par une date
    @GetMapping("/factureByDate/{factureDate}")
    public ResponseEntity<FactureResponse> factureDetailsByDate(
            @PathVariable("factureDate") LocalDate factureDate
    ){
        FactureResponse factureResponse= factureService.factureDetailsByDate(factureDate);
        return ResponseEntity.ok(factureResponse);

    } // exporter un fichier en json
    @GetMapping("/{factureId}/export-json")
    public ResponseEntity<?> factureExportJson(
            @PathVariable("factureId") Long factureId
    ) {
        try {
            FactureResponse facture =factureService.factureDetails(factureId);
            File jsonFile=jsonExportService.exportFactureToJson(facture);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachement; filename="+jsonFile.getName())
                    .body(org.springframework.util.FileCopyUtils.copyToByteArray(jsonFile));

        }catch (Exception e){
            return ResponseEntity.status(500).body("Erreur lors de l'export : "+e.getMessage());
        }

    }



}
