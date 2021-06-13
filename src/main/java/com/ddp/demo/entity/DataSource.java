package com.ddp.demo.entity;

import lombok.Data;

/**
 * @author kevin
 */
@Data
public class DataSource {

    String datasourceId;

    String url;

    String userName;

    String passWord;

    String code;

    String databaseType;
}
