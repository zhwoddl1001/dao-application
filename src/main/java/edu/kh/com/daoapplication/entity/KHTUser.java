package edu.kh.com.daoapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class KHTUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false) // nullable = false -> null 값 허용안함
    private String username;

    // unique = false -> 똑같은 값을 허용할것인가? 허용함
    @Column(unique = false, nullable = false)
    private String password;

    // 이미지 경로 설정
    private String imagePath;
}
