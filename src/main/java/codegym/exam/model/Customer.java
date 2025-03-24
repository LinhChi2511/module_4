package codegym.exam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cus")
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "phone")
    @NotBlank

    private String phone;

    @Column(name = "email")
    private String email;
}
