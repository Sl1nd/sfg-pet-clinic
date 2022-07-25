package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.core.support.SurroundingTransactionDetectorMethodInterceptor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private  final VetService vetService;

  private final PetTypeService petTypeService;
  private final SpecialtyService specialtyService;

  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialtyService = specialtyService;
  }



  @Override
  public void run(String... args) throws Exception {
  int count = petTypeService.findAll().size();
    if(count == 0) {
      loadData();
    }
  }

  private void loadData() {
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = this.petTypeService.save(dog);

    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = this.petTypeService.save(cat);

    Specialty radialogy = new Specialty();
    radialogy.setDescription("BLABLA");
    Specialty surgery = new Specialty();
    surgery.setDescription("DADDADAD");

    Specialty savedRadialoy = specialtyService.save(radialogy);
    Specialty savedSurgery = specialtyService.save(surgery);

    Owner owner1 = new Owner();
    owner1.setFistName("Michael");
    owner1.setFistName("Weston");
    owner1.setAddress("1234 Hauptstraße");
    owner1.setCity("Miami");
    owner1.setTelephone("4321");

    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthday(LocalDate.now());
    owner1.getPets().add(mikesPet);
    ownerService.save(owner1);

    Owner owner2 = new Owner();
    owner2.setFistName("Fiona");
    owner2.setFistName("Glenner");
    owner2.setAddress("1234 Hauptstraße");
    owner2.setCity("Miami");
    owner2.setTelephone("4321");

    Pet fionasPet = new Pet();
    fionasPet.setPetType(savedCatPetType);
    fionasPet.setOwner(owner1);
    fionasPet.setBirthday(LocalDate.now());
    owner2.getPets().add(fionasPet);
    ownerService.save(owner2);


    System.out.println("Loading owners...");

    Vet vet1 = new Vet();
    vet1.setFistName("Sam");
    vet1.setFistName("Axe");
    vet1.getSpecialties().add(savedRadialoy);
    vetService.save(vet1);

    Vet vet2 = new Vet();
    vet2.setFistName("Jessie");
    vet2.setFistName("Porter");
    vet2.getSpecialties().add(surgery);
    vetService.save(vet2);

    System.out.println("Loading vets...");
  }
}
