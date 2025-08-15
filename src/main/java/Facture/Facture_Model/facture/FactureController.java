package Facture.Facture_Model.facture;

import Facture.Facture_Model.client.ClientResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/factures")
public class FactureController {
    private final FactureService factureService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createFacture(
            @RequestBody @Valid FactureRequest factureRequest
    ){
        factureService.createFacture(factureRequest);
    }
    @GetMapping("/{factureId}")
    public ResponseEntity<FactureResponse> factureDetails(
            @PathVariable("factureId") Long factureId
    ){
        FactureResponse factureResponse= factureService.factureDetails(factureId);
        return ResponseEntity.ok(factureResponse);

    }


}
