package com.cSmithSwim.Cullenary.businessLayer;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipe")
public class Recipe {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Long id;

        @NotBlank(message = "Name is mandatory")
        private String name;

        @NotBlank(message = "Category is mandatory")
        private String category;

        private LocalDateTime date;

        @NotBlank(message = "Description is mandatory")
        private String description;

        @NotNull(message = "Ingredients shouldn't be null")
        @Size(min = 1, message = "Minimal size should be 1")
        @ElementCollection
        private List<String> ingredients;

        @NotNull(message = "Directions shouldn't be null")
        @Size(min = 1, message = "Minimal size should be 1")
        @ElementCollection
        private List<String> directions;

}
