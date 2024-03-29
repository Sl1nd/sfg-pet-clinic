package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{
  @Column(name = "first_name")
  private String fistName;
  @Column(name="last_name")
  private String lastName;

  public Person(Long id, String firstName, String lastName) {
    super(id);
    this.fistName = firstName;
    this.lastName = lastName;
  }
}
