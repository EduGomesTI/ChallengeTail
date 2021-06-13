package com.marvel.tail.application.query;

import java.util.Optional;

public interface Query<T> {

    Iterable<T> handle();
    Optional<T> handle(long id);

}
