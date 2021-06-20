package com.marvel.tail.domain.agregates.text.interfaces.Repository;

import com.marvel.tail.domain.agregates.text.entities.Text;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITextRepository extends PagingAndSortingRepository<Text, Long>{

}
