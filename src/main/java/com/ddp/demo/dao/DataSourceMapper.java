package com.ddp.demo.dao;

import com.ddp.demo.entity.DataSource;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kevin
 */
public interface DataSourceMapper {

    @Select("SELECT * FROM databasesource")
    List<DataSource> get();
}
