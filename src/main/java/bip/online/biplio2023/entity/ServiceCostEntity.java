package bip.online.biplio2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "serviceCost")
public class ServiceCostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Schema(description = "Стоимость", example = "Тест")
    private String title;
    @ManyToOne
    @JoinColumn (name = "service_id")
    private ServiceEntity service;
    @JsonIgnore
    @OneToMany(mappedBy = "serviceCost", cascade = CascadeType.ALL)
    private List<ReceiptEntity> clients;


}
