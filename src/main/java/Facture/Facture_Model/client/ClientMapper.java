package Facture.Facture_Model.client;

import org.springframework.stereotype.Service;

@Service
public class ClientMapper { // le mapper sert a protéger et de n'est pas exposer les ressources et données sensible.
    public Client mapToClientEntity(ClientRequest clientRequest) {//convertir un client request en Client
        return Client.builder()
                .nom(clientRequest.getNom())
                .date(clientRequest.getDate())
                .email(clientRequest.getEmail())
                .siret(clientRequest.getSiret())
                .build();
    }
    public ClientResponse mapToClientResponse(Client client) { // mapper un Client en Client response
        return ClientResponse.builder()
                .id(client.getId())
                .nom(client.getNom())
                .date(client.getDate())
                .email(client.getEmail())
                .siret(client.getSiret())
                .build();
    }

}
