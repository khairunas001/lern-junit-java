package learn.junit.anas.javaunittest.service;


import learn.junit.anas.javaunittest.data.Person;
import learn.junit.anas.javaunittest.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLOutput;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
         personService.get("not found");
        });
        System.out.println("Person id not found");
    }

    @Test
    void testGetPersonSucces(){
        // menambah behavior ke mock object
        Mockito.when(personRepository.selectById("Joko")).thenReturn(new Person("Joko", "WiWok"));

        var person = personService.get("Joko");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Joko", person.getId());
        Assertions.assertEquals("WiWok", person.getName());

        var showData = person.toString();
        System.out.println("nilai\n"+showData+"\nsudah sesuai");
    }

    @Test
    void testRegisterSuccesss(){
        var person = personService.regiter("Hahowo");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("Hahowo",person.getName());
        Assertions.assertNotNull(person.getId());

        // khususnya pada fungsi void seharunya diberikan Mockito Verify untuk mengetahui fungsi dipanggil atau tidak
        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), person.getName()));
    }

}
