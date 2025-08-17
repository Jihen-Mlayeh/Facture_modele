package Facture.Facture_Model.client;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequest { // ClientRequest : recevoir les données envoyées par le client
    @NotBlank(message = "Le nom ne doit pas étre vide")
    private String nom;
    @NotBlank(message = "Le siret ne doit pas étre vide")
    private String siret;
    @Email(message = "Email n'est pas valide")
    private String email;
    @NotNull(message = "la date ne doit pas étre vide")
    private LocalDate date;
}
