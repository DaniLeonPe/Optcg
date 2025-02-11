package es.system.danileonpe.springboot.service.interfaces;

import java.util.List;

public interface IService<T> {

    public boolean add(T t);
    public boolean update(int id, T t) throws Exception;
    public List<T> getAll();
    public T getById(int id);
    public boolean delete(int id);

    
}
