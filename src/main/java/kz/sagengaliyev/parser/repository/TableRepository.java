package kz.sagengaliyev.parser.repository;

import kz.sagengaliyev.parser.model.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableEntity, Long> {
}
