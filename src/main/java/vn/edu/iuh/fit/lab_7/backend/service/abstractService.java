package vn.edu.iuh.fit.lab_7.backend.service;

import org.springframework.data.domain.Page;

public abstract class abstractService<T> {

    public abstract Page<T> findPaginated( int pageNo,int pageSize,String sortBy,String sortDirection);

}
