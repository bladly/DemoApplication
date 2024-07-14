package com.example.demo.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.vm.BookVM;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    public Book toEntity(BookVM vm);

    public void toEntity(BookVM vm, @MappingTarget Book book);

    @Named("toDto")
    public BookDto toDto(Book book);

    @IterableMapping(qualifiedByName = "toDto")
    public List<BookDto> toDtoList(Collection<Book> book);
}
