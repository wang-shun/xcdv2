package com.batch.linv.reader;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.util.ClassUtils;

import com.framework.batch.item.database.MybatisItemReader;
import com.framework.boot.base.BaseService;
import com.github.pagehelper.PageHelper;

/**
 * Created by wangfan on 2017/2/21.
 */
public abstract class MyServiceItemReader<I> extends AbstractPagingItemReader<I> {
    private BaseService baseService;

    public MyServiceItemReader() {
        super.setName(ClassUtils.getShortName(MybatisItemReader.class));
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
    }

    protected void doReadPage() {
        if(this.results == null) {
            this.results = new CopyOnWriteArrayList();
        } else {
            this.results.clear();
        }

      //  super.setPageSize(this.pageSize());
      //  PageHelper.startPage(super.getPage(), super.getPageSize());
        List items = this.query();
        this.results.addAll(items);
    }

    protected int pageSize() {
        return 100;
    }

    protected abstract List<I> query();

    protected void doJumpToPage(int itemIndex) {
    }
}
