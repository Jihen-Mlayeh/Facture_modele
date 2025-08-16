package Facture.Facture_Model.client;

import java.util.List;

public interface ClientService { // le contrat qui définit les methodes nécessaire a implementer
    void createClient(ClientRequest clientRequest);
    List<ClientResponse> getAllClients(int page,int size);
    ClientResponse detailClient(Long clientId);


}
