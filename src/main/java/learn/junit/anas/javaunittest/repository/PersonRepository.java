package learn.junit.anas.javaunittest.repository;

import learn.junit.anas.javaunittest.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);

}
