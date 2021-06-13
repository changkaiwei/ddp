package com.ddp.demo.service;

import com.ddp.demo.config.DBContextHolder;
import com.ddp.demo.config.DynamicDataSource;
import com.ddp.demo.dao.DataSourceMapper;
import com.ddp.demo.entity.DataSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kevin
 */
@Service
public class DBChangeServiceImpl implements DBChangeService {

    @Resource
    DataSourceMapper dataSourceMapper;
    @Resource
    private DynamicDataSource dynamicDataSource;
    @Override
    public List<DataSource> get() {
        return dataSourceMapper.get();
    }

    @Override
    public boolean changeDb(String datasourceId) throws Exception {

        //默认切换到主数据源,进行整体资源的查找
        DBContextHolder.clearDataSource();

        List<DataSource> dataSourcesList = dataSourceMapper.get();

        for (DataSource dataSource : dataSourcesList) {
            if (dataSource.getDatasourceId().equals(datasourceId)) {
                System.out.println("需要使用的的数据源已经找到,datasourceId是：" + dataSource.getDatasourceId());
                //创建数据源连接&检查 若存在则不需重新创建
                dynamicDataSource.createDataSourceWithCheck(dataSource);
                //切换到该数据源
                DBContextHolder.setDataSource(dataSource.getDatasourceId());
                return true;
            }
        }
        return false;

    }
}
