package com.dmitrenko.userstorage.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, S> {
	T from(S source);

	default List<T> from(Collection<S> sources) {
		return sources
			.stream()
			.map(this::from)
			.collect(Collectors.toList());
	}
}
