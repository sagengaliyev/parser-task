package kz.sagengaliyev.parser.pagination;

import kz.sagengaliyev.parser.dto.TableDTO;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PageDTO<T> {
    private final List<T> content;
    private final Integer pageNumber;
    private final Integer pageSize;
    private final Integer totalPages;
    private final Long totalElements;

    public PageDTO(Page<T> page) {
        this.content = page.getContent();
        this.pageNumber = page.getPageable().getPageNumber() + 1;
        this.pageSize = page.getPageable().getPageSize();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

    public PageDTO(List<T> content, Integer pageNumber, Integer pageSize, Integer totalPages, Long totalElements) {
        this.content = content;
        this.pageNumber = pageNumber + 1;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

}
