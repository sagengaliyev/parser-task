package kz.sagengaliyev.parser.service;

import kz.sagengaliyev.parser.model.ColumnEntity;
import kz.sagengaliyev.parser.model.TableEntity;
import kz.sagengaliyev.parser.pagination.PageableFactory;
import kz.sagengaliyev.parser.repository.TableRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public void save(TableEntity table) {
        tableRepository.save(table);
    }

    public TableEntity findById(Long id) {
        return tableRepository.findById(id).orElseThrow();
    }

    public Page<TableEntity> findAll(Pageable pageable) {
        return tableRepository.findAll(pageable);
    }
}
