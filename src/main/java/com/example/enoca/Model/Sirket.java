package com.example.enoca.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="sirket")
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Sirket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sirket_id",nullable = false,updatable = false,length = 15)
    private String sirket_id;

    private String sirket_adi;
    private String adres;
    private String sirket_mail;
}
