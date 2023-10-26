package kz.sagengaliyev.parser.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "COLUMN_ENTITY")
@Getter
@Setter
@Where(clause = "deleted=false")
public class ColumnEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TABLE_ID", nullable = false)
    private TableEntity table;

    @Column(name = "NAME_", nullable = false)
    private String name;

    @Column(name = "TYPE_", nullable = false)
    private String type;

    @Column(name = "DELETED", nullable = false)
    private Boolean deleted = false;
}
