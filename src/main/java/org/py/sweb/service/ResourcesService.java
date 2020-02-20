package org.py.sweb.service;

import org.py.sweb.model.Resources;

public interface ResourcesService extends BaseService<Resources> {
    Resources selectById(long id);
}
