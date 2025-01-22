package edu.kh.com.daoapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KHTBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String author;
    private String genre;
}
