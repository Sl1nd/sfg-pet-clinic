package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.CRUDService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
  private final SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Vet obj) {
    super.delete(obj);
  }

  @Override
  public Vet save(Vet obj) {
    if(obj.getSpecialties().size() >0) {
      obj.getSpecialties().forEach(specialty -> {
        if (specialty.getId() == null) {
          Specialty savedSpecialty  = specialtyService.save(specialty);
          specialty.setId(savedSpecialty.getId());
        }
      });
    }


    return super.save( obj);
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }
}
