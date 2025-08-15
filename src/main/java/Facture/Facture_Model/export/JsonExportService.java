package Facture.Facture_Model.export;

import Facture.Facture_Model.facture.FactureResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class JsonExportService {
    private final ObjectMapper objectMapper;
    public  File exportFactureToJson(FactureResponse factureResponse) throws IOException {
        File file=new File("facture_"+factureResponse.getId()+".json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, factureResponse);
        return file;
    }
}
