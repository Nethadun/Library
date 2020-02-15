package com.ijse.libSystem.service.commen;

import java.util.List;

public interface CrudService<T>  {
    public Long add(T t);
    public Long update(T t);
    public List<T> searchLike(String searchText, Integer count, Integer page);
    public T get(Long id);
    public Long delete(Long id);

}
