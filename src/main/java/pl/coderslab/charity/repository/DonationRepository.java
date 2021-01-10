package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT coalesce( SUM(d.quantity), 0) FROM Donation d")
    long sumAllGivenBags();

    @Query("SELECT COUNT(d) FROM Donation d")
    long countAllDonations();
}
