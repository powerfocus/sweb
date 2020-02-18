package org.py.sweb.service;

import org.py.sweb.mapper.Sort;
import org.py.sweb.model.Upfiles;

import java.util.List;

public interface UpfileService extends BaseService<Upfiles> {
    Upfiles selectById(long id);
    List<Upfiles> selectEvery(Sort order);
    int delete(long id);
}
