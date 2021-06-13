package com.marvel.tail.repository;

import java.util.List;

import com.marvel.tail.domain.Text;
import com.marvel.tail.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface TextRepository extends PagingAndSortingRepository<Text, Long>{

    List<Text> findTextByWords(@Param("words") Word word);
    Text findTextById(@Param("id") long id);

}
