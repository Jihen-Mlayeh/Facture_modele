package Facture.Facture_Model.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


public class ClientServiceImplTest {
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ClientMapper clientMapper;
    @InjectMocks
    private ClientServiceImpl clientService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void Should_create_client_successfully() {
        final ClientRequest clientRequest = new ClientRequest();
        final Client mappedClient = buildMapperClient();
        when(clientMapper.mapToClientEntity(clientRequest)).thenReturn(mappedClient);
        when(clientRepository.save(mappedClient)).thenReturn(mappedClient);
        clientService.createClient(clientRequest);
        verify(clientRepository, times(1)).save(mappedClient);
    }

    private static Client buildMapperClient() {
        return Client.builder()
                .nom("user")
                .email("user@email.com")
                .siret("123456789")
                .date(LocalDate.now())
                .build();
    }

}
