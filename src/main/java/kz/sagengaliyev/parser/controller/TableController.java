package kz.sagengaliyev.parser.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kz.sagengaliyev.parser.dto.ColumnDTO;
import kz.sagengaliyev.parser.dto.TableDTO;
import kz.sagengaliyev.parser.facade.TableFacade;
import kz.sagengaliyev.parser.pagination.PageDTO;
import kz.sagengaliyev.parser.report.ProcedureReport;
import kz.sagengaliyev.parser.request.ColumnCreationRequest;
import kz.sagengaliyev.parser.request.TableCreationRequest;
import kz.sagengaliyev.parser.request.UpdateColumnRequest;
import kz.sagengaliyev.parser.request.UpdateTableRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/table")
@Tag(name = "Таблица")
@Slf4j
public class TableController {
    private final TableFacade tableFacade;

    public TableController(TableFacade tableFacade) {
        this.tableFacade = tableFacade;
    }

    @PostMapping
    @Operation(summary = "Создать таблицу")
    public ResponseEntity<TableDTO> create(@RequestBody @Valid TableCreationRequest tableDTO) {
        log.info("Создание таблицы с названием: {}", tableDTO.getName());
        return ResponseEntity.ok(tableFacade.createTable(tableDTO));
    }

    @PostMapping("/{id}/column")
    @Operation(summary = "Добавить колонку в созданную таблицу")
    public ResponseEntity<ColumnDTO> addColumnToTable(@PathVariable Long id, @RequestBody @Valid ColumnCreationRequest dto) {
        log.info("Добавление колонки в таблицу с ID: {}", id);
        return ResponseEntity.ok(tableFacade.addColumnToTable(id, dto));
    }

    @GetMapping
    @Operation(summary = "Список таблиц")
    public ResponseEntity<PageDTO<TableDTO>> findAll(
            @RequestParam(name = "page_size", required = false, defaultValue = "10") Integer pageSize,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer pageNumber
    ) {
        log.info("Отображение всех таблицы");
        return ResponseEntity.ok(tableFacade.findAll(pageSize,pageNumber));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Вывод по одному")
    public ResponseEntity<TableDTO> findById(@PathVariable Long id) {
        log.info("Отображение таблицы с ID: {}", id);
        return ResponseEntity.ok(tableFacade.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Поменять данные таблицы")
    public ResponseEntity<ProcedureReport> update(@PathVariable Long id, @RequestBody @Valid UpdateTableRequest dto) {
        log.info("Изменение данных таблицы с ID: {}", id);
        return ResponseEntity.ok(tableFacade.updateTable(id, dto));
    }

    @PutMapping("/{id}/column/{columnId}")
    @Operation(summary = "Поменять колонку таблицы")
    public ResponseEntity<ProcedureReport> update(@PathVariable Long id, @PathVariable Long columnId, @RequestBody UpdateColumnRequest dto) {
        log.info("Изменение колонки таблицы с ID: {}", id);
        return ResponseEntity.ok(tableFacade.updateColumn(id, columnId, dto));
    }

}
