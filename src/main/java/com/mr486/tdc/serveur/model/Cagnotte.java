package com.mr486.tdc.serveur.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Cagnotte implements Serializable {

  private static final long serialVersionUID = 4048798961366546485L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nom", length = 150, nullable = false)
  private String nom;

  @Column(name = "est_favorite", nullable = false)
  private Boolean estFavorite;

  @Column(name = "date_creation")
  private Date dateCreation;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Cagnotte cagnotte = (Cagnotte) o;
    return id != null && Objects.equals(id, cagnotte.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
