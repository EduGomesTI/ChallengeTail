package com.marvel.tail.domain.agregates.text.interfaces.Repository;

import com.marvel.tail.domain.agregates.text.entities.Word;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IWordRepository extends PagingAndSortingRepository<Word, Long> {
}
