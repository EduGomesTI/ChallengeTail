package com.marvel.tail.repository;

import com.marvel.tail.domain.Word;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface WordRepository extends PagingAndSortingRepository<Word, Long> {
}
