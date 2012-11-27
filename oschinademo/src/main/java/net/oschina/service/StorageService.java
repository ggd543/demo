/*
 * 
 * User: 刘永健
 * Date: 12-11-18
 * Time: 下午1:31
 * To change this template use File | Settings | File Templates.
 */
package net.oschina.service;

import my.mvc.RequestContext;
import my.util.Storage;

/**
 * 文件存储服务
 * @author Winter Lau
 * @date 2010-9-2 上午11:35:56
 */
public class StorageService extends Storage {

    public final static StorageService FILES = new StorageService("files");
    public final static StorageService CODE = new StorageService("code");

    private String file_path;

    private StorageService(String ext){
        this.file_path = RequestContext.root() +
                "uploads" + java.io.File.separator +
                ext + java.io.File.separator;
    }

    @Override
    protected String getBasePath() {
        return file_path;
    }

}
