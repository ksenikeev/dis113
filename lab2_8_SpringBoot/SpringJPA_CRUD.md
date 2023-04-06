# CRUD репозиторий

SpringJPA позволяет работать с базой данных несколькими способами.

Один из них CRUD репозиторий.

Репозиторий создается как интерфейс, который должен наследоваться от интерфейса `CrudRepository<T, E>`
(`T` - класс сущности для которой создается репозиторий,  `E` - класс, который описывает первичный ключ сущности):

```java
import org.springframework.data.repository.CrudRepository;
import ru.itis.lab2_8.model.AccessProtocol;
import java.util.List;
// AccessProtocol - Entity, Long - id type
public interface AccessProtocolRepository
        extends CrudRepository<AccessProtocol, Long> {

}
```

Реализацию этого интерфейса делает Spring Framework

Основные методы:
- `save(S entity)`
- `findById(ID id)`
- `findAll()`
- `count()`
- `deleteById(ID id)`
- `delete(T entity)`

С помощью специальных ключевых слов можно описать свои методы.

| Keyword	  | Sample | JPQL                                                         |
|-----------| ------ |--------------------------------------------------------------|
| And       | findByLastnameAndFirstname | ... where x.lastname = ?1 and x.firstname = ?2               |
| Or        | findByLastnameOrFirstname | ... where x.lastname = ?1 or x.firstname = ?2                  |
| Distinct  | findDistinctByLastnameAndFirstname | select distinct ... where x.lastname = ?1 and x.firstname = ?2 |
| Between | findByStartDateBetween | ... where x.startDate between ?1 and ?2                        |
| LessThan | findByAgeLessThan | ... where x.age < ?1                                           |
| LessThanEqual | findByAgeLessThanEqual | ... where x.age <= ?1                                          |
| GreaterThan | findByAgeGreaterThan | ... where x.age > ?1                                           |
| GreaterThanEqual | findByAgeGreaterThanEqual | ... where x.age >= ?1                                          |
| After | findByStartDateAfter | ... where x.startDate > ?1                                     |
| Before | findByStartDateBefore | ... where x.startDate < ?1                                     |
| IsNull, Null | findByAge(Is)Null | ... where x.age is null                                        |
| IsNotNull, NotNull | findByAge(Is)NotNull | ... where x.age not null                                       |
| Like | findByFirstnameLike | ... where x.firstname like ?1                                  |
| NotLike | findByFirstnameNotLike | ... where x.firstname not like ?1                              |
| Containing | findByFirstnameContaining | ... where x.firstname like ?1 (parameter bound wrapped in %)   |
| OrderBy | findByAgeOrderByLastnameDesc | ... where x.age = ?1 order by x.lastname desc                  |
| Not | findByLastnameNot | ... where x.lastname <> ?1                                     |
| In | findByAgeIn(Collection<Age> ages) | ... where x.age in ?1                                          |
| NotIn | findByAgeNotIn(Collection<Age> ages) | ... where x.age not in ?1                                      |
| True | findByActiveTrue() | ... where x.active = true                                      |
| False | findByActiveFalse() | ... where x.active = false                                     |
| IgnoreCase | findByFirstnameIgnoreCase | ... where UPPER(x.firstname) = UPPER(?1)                       |

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

Добавим в наш интерфейс метод:

```java
import org.springframework.data.repository.CrudRepository;
import ru.itis.lab2_8.model.AccessProtocol;
import java.util.List;
// AccessProtocol - Entity, Long - id type
public interface AccessProtocolRepository
        extends CrudRepository<AccessProtocol, Long> {
    List<AccessProtocol> findByUsernameOrSuccess(String username, Boolean success);
}
```

Пример класса, который использует репозиторий AccessProtocolRepository

```java
import org.springframework.beans.factory.annotation.Autowired;

@Service
class AccessProtocolService {
    @Autowired
    private AccessProtocolRepository repository;
    
    public void printProtocol() {
        List<AccessProtocol> logs = findByUsernameOrSuccess("admin", true);
        logs.forEach(System.out::println);
    }
}
```