package kz.sagengaliyev.parser.repository;

import kz.sagengaliyev.parser.model.ColumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColumnRepository extends JpaRepository<ColumnEntity, Long> {
}
