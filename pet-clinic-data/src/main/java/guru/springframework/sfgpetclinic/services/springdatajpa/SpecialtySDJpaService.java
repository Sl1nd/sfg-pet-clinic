package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {
  public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
    this.specialtyRepository = specialtyRepository;
  }

  private final SpecialtyRepository specialtyRepository;

  @Override
  public Set<Specialty> findAll() {
    Set<Specialty> specials = new HashSet<>();
    specialtyRepository.findAll().forEach(specials::add);
    return specials;
  }

  @Override
  public Specialty findById(Long aLong) {
    return specialtyRepository.findById(aLong).orElse(null);
  }

  @Override
  public Specialty save(Specialty obj) {
    return specialtyRepository.save(obj);
  }

  @Override
  public void delete(Specialty obj) {
    specialtyRepository.delete(obj);
  }

  @Override
  public void deleteById(Long aLong) {
      specialtyRepository.deleteById(aLong);
  }
}
