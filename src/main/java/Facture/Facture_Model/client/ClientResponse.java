package Facture.Facture_Model.client;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
    private Long id;
    private String nom;
    private String siret;
    private String email;
    private LocalDate date;
}
