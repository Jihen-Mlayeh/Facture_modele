package Facture.Facture_Model.client;

import org.springframework.stereotype.Service;

@Service
public class ClientMapper {
    public Client mapToClientEntity(ClientRequest clientRequest) {
        return Client.builder()
                .nom(clientRequest.getNom())
                .date(clientRequest.getDate())
                .email(clientRequest.getEmail())
                .siret(clientRequest.getSiret())
                .build();
    }
    public ClientResponse mapToClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .nom(client.getNom())
                .date(client.getDate())
                .email(client.getEmail())
                .siret(client.getSiret())
                .build();
    }

}
