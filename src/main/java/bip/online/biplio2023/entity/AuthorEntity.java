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
@Table(name = "authors")
@Schema(description = "Инфа о авторе")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
private Long id;
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Фамилия автора", example = "Тест")
    private String lastname;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Имя автора", example = "Тест")
    private String name;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    @Schema(description = "Отчество автора", example = "Тест")
    private String surname;
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
private List<BookEntity> books;
}
