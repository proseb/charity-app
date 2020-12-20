package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    //    Institution findOneByName(String institution);
//    Institution findAllByNameLike(String institution);
    List<Institution> findAll();

    Institution findById(long id);

    void delete(long id);

    void save(Institution institution);
}
// findAll