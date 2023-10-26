package kz.sagengaliyev.parser.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "TABLE_ENTITY")
@Getter
@Setter
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_", nullable = false)
    private String name;

    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY)
    private List<ColumnEntity> columns;

    @Column(name = "DELETED", nullable = false)
    private Boolean deleted = false;
}
