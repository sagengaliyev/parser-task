package kz.sagengaliyev.parser.facade.impl;

import kz.sagengaliyev.parser.dto.ColumnDTO;
import kz.sagengaliyev.parser.dto.TableDTO;
import kz.sagengaliyev.parser.facade.TableFacade;
import kz.sagengaliyev.parser.mapper.ColumnMapper;
import kz.sagengaliyev.parser.mapper.TableMapper;
import kz.sagengaliyev.parser.model.ColumnEntity;
import kz.sagengaliyev.parser.model.TableEntity;
import kz.sagengaliyev.parser.pagination.PageDTO;
import kz.sagengaliyev.parser.pagination.PageableFactory;
import kz.sagengaliyev.parser.report.ProcedureReport;
import kz.sagengaliyev.parser.request.ColumnCreationRequest;
import kz.sagengaliyev.parser.request.TableCreationRequest;
import kz.sagengaliyev.parser.request.UpdateColumnRequest;
import kz.sagengaliyev.parser.request.UpdateTableRequest;
import kz.sagengaliyev.parser.service.ColumnService;
import kz.sagengaliyev.parser.service.TableService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class TableFacadeImpl implements TableFacade {
    private final TableService tableService;
    private final ColumnService columnService;
    private final TableMapper tableMapper;
    private final ColumnMapper columnMapper;

    public TableFacadeImpl(TableService tableService, ColumnService columnService, TableMapper tableMapper, ColumnMapper columnMapper) {
        this.tableService = tableService;
        this.columnService = columnService;
        this.tableMapper = tableMapper;
        this.columnMapper = columnMapper;
    }

    @Override
    public TableDTO createTable(TableCreationRequest tableDTO) {
        TableEntity newTable = tableMapper.toEntity(tableDTO);
        tableService.save(newTable);
        return tableMapper.toDto(newTable);
    }

    @Override
    public ColumnDTO addColumnToTable(Long id, ColumnCreationRequest dto) {
        TableEntity table = tableService.findById(id);
        ColumnEntity newColumn = columnMapper.toEntity(dto);
        newColumn.setTable(table);
        columnService.save(newColumn);
        return columnMapper.toDto(newColumn);
    }

    @Override
    public PageDTO<TableDTO> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageableFactory.create(pageNumber, pageSize);
        Page<TableDTO> tables = tableService.findAll(pageable).map(tableMapper::toDto);
        return new PageDTO<>(tables);
    }

    @Override
    public TableDTO findById(Long id) {
        return tableMapper.toDto(tableService.findById(id));
    }

    @Override
    public ProcedureReport updateTable(Long id, UpdateTableRequest dto) {
        TableEntity tableEntity = tableService.findById(id);
        TableEntity updatedTable = tableMapper.update(tableEntity, dto);
        tableService.save(updatedTable);
        return  new ProcedureReport("Таблица успешно обновлена!");
    }

    @Override
    public ProcedureReport updateColumn(Long id, Long columnId, UpdateColumnRequest dto) {
        ColumnEntity column = columnService.findById(columnId);
        ColumnEntity updatedColumn = columnMapper.update(column, dto);
        columnService.save(updatedColumn);
        return new ProcedureReport("Колонка успешно обновлена");
    }
}
