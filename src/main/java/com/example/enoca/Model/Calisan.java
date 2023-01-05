package com.example.enoca.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="calisan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calisan {
    @Id
    @Column(name="calisan_id",nullable = false,length = 15)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String calisan_id;

    @Column(name = "calisan_adi",nullable = false,length = 20)
    private String calisan_adi;

    @Column(name = "calisan_soyadi", nullable = false,length = 20)
    private String calisan_soyadi;

    @Column(name="calisan_mail",nullable = false, length = 30)
    private String calisan_mail;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sirket_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sirket sirket;
}
