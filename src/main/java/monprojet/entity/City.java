package monprojet.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class City {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 100)
    @NonNull
    private String name;

    @Column(unique = true)
    @NonNull
    private Integer population;

    @ManyToOne
    @NonNull
    private Country country;
}
