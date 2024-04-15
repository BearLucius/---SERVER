package bip.online.biplio2023.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "books")
public class    BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank()
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String bookName;
    @NotNull
    @ManyToOne
    @JoinColumn(name ="author_id")
    private AuthorEntity author;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;//:Жанр
    private String year;
}
