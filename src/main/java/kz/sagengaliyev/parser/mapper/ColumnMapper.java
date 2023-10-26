package kz.sagengaliyev.parser.mapper;

import kz.sagengaliyev.parser.dto.ColumnDTO;
import kz.sagengaliyev.parser.model.ColumnEntity;
import kz.sagengaliyev.parser.request.ColumnCreationRequest;
import kz.sagengaliyev.parser.request.UpdateColumnRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ColumnMapper {
    ColumnDTO toDto(ColumnEntity columnEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    ColumnEntity toEntity(ColumnCreationRequest dto);

    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "type", source = "type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ColumnEntity update(@MappingTarget ColumnEntity column, UpdateColumnRequest dto);
}
