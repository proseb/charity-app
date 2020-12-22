package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Institution;

import java.util.List;
@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    //    Institution findOneByName(String institution);
//    Institution findAllByNameLike(String institution);

}
