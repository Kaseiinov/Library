package org.example.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String avatar;
    private Boolean available;
    @Column(name = "return_date")
    private LocalDate returnDate;

    @OneToOne(fetch = FetchType.LAZY)
    private History history;

    @ManyToMany
    private List<User> users;

    @ManyToOne
    private Category category;

}
