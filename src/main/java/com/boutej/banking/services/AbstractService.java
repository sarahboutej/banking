package com.boutej.banking.services;

import java.util.List;

public interface AbstractService<T> {
  Integer save(T dto);

  T findById(Integer id);

  List<T> findAll();

  void delete(Integer id);

}
