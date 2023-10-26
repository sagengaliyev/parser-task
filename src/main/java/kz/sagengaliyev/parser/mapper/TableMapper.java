package kz.sagengaliyev.parser.mapper;

import kz.sagengaliyev.parser.dto.TableDTO;
import kz.sagengaliyev.parser.model.TableEntity;
import kz.sagengaliyev.parser.request.TableCreationRequest;
import kz.sagengaliyev.parser.request.UpdateTableRequest;
import kz.sagengaliyev.parser.service.ColumnService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {
        ColumnMapper.class,
        ColumnService.class
})
public interface TableMapper {
    TableDTO toDto(TableEntity tableEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    TableEntity toEntity(TableCreationRequest tableCreationRequest);

    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TableEntity update(@MappingTarget TableEntity table, UpdateTableRequest dto);
}
