package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CRUDService;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
  private final PetTypeService petTypeService;
  private final PetService petService;
  public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
    this.petTypeService = petTypeService;
    this.petService = petService;
  }

  @Override
  public Set<Owner> findAll() {
    return super.findAll();
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }

  @Override
  public void delete(Owner obj) {
    super.delete(obj);
  }

  @Override
  public Owner save(Owner obj) {

    Owner savedOwner = null;
    if(obj != null) {
      if(obj.getPets() != null) {
        obj.getPets().forEach(pet ->{
          if(pet.getPetType() != null) {
            if(pet.getPetType().getId() == null) {
              pet.setPetType(petTypeService.save(pet.getPetType()));
            }
          } else {
            throw new RuntimeException("Pet Type is required");
          }

          if(pet.getId() == null ){
            Pet savedPet = petService.save(pet);
          }
        });
      }
      return super.save(obj);
    } else {
      return null;
    }
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Owner findByLastName(String lastName) {
    return null;
  }
}
