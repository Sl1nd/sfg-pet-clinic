package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.CRUDService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CRUDService<Owner, Long> {
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
    return super.save(obj.getId(), obj);
  }

  @Override
  public Owner findById(Long id) {
    return super.findById(id);
  }
}