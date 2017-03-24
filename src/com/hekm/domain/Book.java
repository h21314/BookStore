package com.hekm.domain;

import java.io.Serializable;
/*
 * domain对应的是数据库的pojo，一般来说一张表对应一个domain;
 * Dao对应的是对数据库的操作，比如增删改查之类的，一般而言也是一张表对应一个Dao；
 * Service对应的是业务流程，实现业务逻辑;
 * example:实现文件上传的时候，Dao可能做得操作是把文件的路径，文件名等信息写入数据库，但真正把文件上传的ftp是在service里实现的 ;
 * */
public class Book implements Serializable {

}
