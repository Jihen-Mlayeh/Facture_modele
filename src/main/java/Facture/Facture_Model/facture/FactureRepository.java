package Facture.Facture_Model.facture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    @Query("SELECT DISTINCT f FROM Facture f LEFT JOIN FETCH f.lignesFactures WHERE f.id = :id")
    Optional<Facture >findByIdWithLignes(@Param("id") Long id);

    Facture findByDate(LocalDate factureDate);
}
