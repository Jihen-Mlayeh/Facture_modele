package Facture.Facture_Model.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public void createClient(ClientRequest clientRequest) {
        if(clientRepository.existsBySiret(clientRequest.getSiret())){ // vérifier si le client déja existe avec le siret ou non .
            throw new RuntimeException("Siret already exists");
        }
        Client client=clientMapper.mapToClientEntity(clientRequest); // mapper le client requst en client
        clientRepository.save(client);// save le client

    }

    @Override
    public List<ClientResponse> getAllClients(int page, int size) { // afficher tous les clients.
        PageRequest pageRequest = PageRequest.of(page, size);
        return clientRepository.findAll(pageRequest)
                .getContent()
                .stream()
                .map(clientMapper::mapToClientResponse)
                .toList();
    }

    @Override
    public ClientResponse detailClient(Long clientId) { // afficher un client selon l'ID
        return clientMapper.mapToClientResponse(clientRepository.findById(clientId).get());

    }
}
