# Pagination (постраничный вывод, разбиение на страницы)

## Уровень СУБД
```sql
select id,name from dict_country order by id limit 10 offset ( 3 - 1) * 10 
```

## Spring Repository
```
@Query("select c from Country c ")
List<Country> getAllByPage(Pageable pageable);

...

Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending());


```