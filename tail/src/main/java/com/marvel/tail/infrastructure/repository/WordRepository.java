package com.marvel.tail.infrastructure.repository;

import com.marvel.tail.domain.Word;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface WordRepository extends PagingAndSortingRepository<Word, Long> {
}