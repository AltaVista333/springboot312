package com.example.spring311.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Range(min = 1)
    private Long id;

    @Column(name = "name", nullable = false, length = 15)
    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;

    @Column(name = "surname", nullable = false, length = 15)
    @Size(min = 2, message = "name must be min 2 symbols")
    private String surname;

    @Column(name = "age", nullable = false)
    @Min(value = 14)
    @Max(value = 99)
    @NotNull(message = "Can't be null")
    private Integer age;


}