package bip.online.biplio2023.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "receipt")
public class ReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String bookName;
    @NotNull
    @ManyToOne
    @JoinColumn(name ="client_id")
    private ClientEntity client;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "serviceCost_id")
    private ServiceCostEntity serviceCost;
    private String year;
}
