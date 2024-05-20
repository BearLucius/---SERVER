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
@Table(name = "clients")
@Schema(description = "Инфа о клиенте")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
private Long id;
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Фамилия клиента", example = "Тест")
    private String lastname;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Имя клиента", example = "Тест")
    private String name;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Отчество клиента", example = "Тест")
    private String surname;
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
private List<ReceiptEntity> clients;
}
