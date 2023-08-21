package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    private Integer id;

    @NotNull(message = "Area should be not null")
    @Column(columnDefinition = "varchar(50) not null")
    private String area;

    @NotNull(message = "Street should be not null")
    @Column(columnDefinition = "varchar(50) not null")
    private String street;

    @NotNull(message = "Building number must be not null")
    @Positive(message ="must enter a valid Building number" )
    @Column(columnDefinition = "int not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
