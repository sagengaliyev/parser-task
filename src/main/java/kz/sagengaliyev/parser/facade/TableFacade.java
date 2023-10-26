package kz.sagengaliyev.parser.facade;

import kz.sagengaliyev.parser.dto.ColumnDTO;
import kz.sagengaliyev.parser.dto.TableDTO;
import kz.sagengaliyev.parser.pagination.PageDTO;
import kz.sagengaliyev.parser.report.ProcedureReport;
import kz.sagengaliyev.parser.request.ColumnCreationRequest;
import kz.sagengaliyev.parser.request.TableCreationRequest;
import kz.sagengaliyev.parser.request.UpdateColumnRequest;
import kz.sagengaliyev.parser.request.UpdateTableRequest;
import org.springframework.stereotype.Component;

@Component
public interface TableFacade {
    /**
     * Метод для создания таблицы
     * @param tableDTO
     * @return
     */
    TableDTO createTable(TableCreationRequest tableDTO);

    /**
     * Метод для добавления колонки в созданную таблицу
     * @param id
     * @param dto
     * @return
     */
    ColumnDTO addColumnToTable(Long id, ColumnCreationRequest dto);

    /**
     * Метод для вывода всех таблиц
     * @param size
     * @param page
     * @return
     */
    PageDTO<TableDTO> findAll(Integer size, Integer page);

    /**
     * Метод для поиска таблицы по ID
     * @param id
     * @return
     */
    TableDTO findById(Long id);

    /**
     * Метод для обновления таблицы
     * @param id
     * @param dto
     * @return
     */
    ProcedureReport updateTable(Long id, UpdateTableRequest dto);

    /**
     * Метод для обновления колонки таблицы
     * @param id
     * @param columnId
     * @param dto
     * @return
     */
    ProcedureReport updateColumn(Long id, Long columnId, UpdateColumnRequest dto);
}
