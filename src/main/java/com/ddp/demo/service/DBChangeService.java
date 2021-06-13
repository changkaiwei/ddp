package com.ddp.demo.service;

import com.ddp.demo.entity.DataSource;

import java.util.List;

/**
 * @author kevin
 */
public interface DBChangeService {

    List<DataSource> get();

    boolean changeDb(String datasourceId) throws Exception;
}
