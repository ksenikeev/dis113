package semestrii.gui.services;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import semestrii.gui.repositoryes.CountryRepository;
import java.util.List;
import semestrii.gui.model.Country;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Country> getAllByPageNative(Integer pageSize, Integer pageNumber, String orderingField) {
        return repository.getAllByPage(pageSize, pageNumber, orderingField);
    }

    public List<Country> getAllByPage(Integer pageSize, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("name").ascending());
        return repository.getAllByPage(pageable);
    }
}
