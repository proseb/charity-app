package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "categoriesList")
    private List<Donation> donationsList = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
