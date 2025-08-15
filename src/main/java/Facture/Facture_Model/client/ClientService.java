package Facture.Facture_Model.client;

import java.util.List;

public interface ClientService {
    void createClient(ClientRequest clientRequest);
    List<ClientResponse> getAllClients(int page,int size);
    ClientResponse detailClient(Long clientId);


}
