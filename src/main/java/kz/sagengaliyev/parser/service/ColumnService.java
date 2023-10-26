package kz.sagengaliyev.parser.service;

import kz.sagengaliyev.parser.model.ColumnEntity;
import kz.sagengaliyev.parser.model.TableEntity;
import kz.sagengaliyev.parser.repository.ColumnRepository;
import org.springframework.stereotype.Service;

@Service
public class ColumnService {
    private final ColumnRepository columnRepository;

    public ColumnService(ColumnRepository columnRepository) {
        this.columnRepository = columnRepository;
    }

    public void save(ColumnEntity column) {
        columnRepository.save(column);
    }

    public ColumnEntity findById(Long columnId) {
        return columnRepository.findById(columnId).orElseThrow();
    }

    public void delete(Long id) {
        ColumnEntity deletedColumn = findById(id);
        deletedColumn.setDeleted(true);
        columnRepository.save(deletedColumn);
    }
}
