package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="visits")
public class Visit extends BaseEntity {
  @Column(name="date")
  private LocalDate date;
  @Column(name="description")
  private String description;
  @ManyToOne
  @JoinColumn(name="pet_id")
  private Pet per;

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Pet getPer() {
    return per;
  }

  public void setPer(Pet per) {
    this.per = per;
  }
}
