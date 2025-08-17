package Facture.Facture_Model.facture;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    Facture findByDate(LocalDate factureDate);
}
