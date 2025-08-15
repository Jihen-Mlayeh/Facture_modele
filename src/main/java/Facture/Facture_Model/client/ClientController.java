package Facture.Facture_Model.client;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {
    private final ClientService clientService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(
            @RequestBody @Valid ClientRequest clientRequest
    ){
        clientService.createClient(clientRequest);

    }
    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClient(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        List<ClientResponse> clients = clientService.getAllClients(page, size);
        return ResponseEntity.ok(clients);
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponse> getClient(
            @PathVariable("clientId") Long clientId
    ){
        ClientResponse clientResponse= clientService.detailClient(clientId);
        return ResponseEntity.ok(clientResponse);

    }

}
