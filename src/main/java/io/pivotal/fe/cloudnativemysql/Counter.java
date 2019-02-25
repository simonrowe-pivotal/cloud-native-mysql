package io.pivotal.fe.cloudnativemysql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counter {

    @Id
    private String page;
    private Integer count;


    public Counter() {
        count = 0;
    }

    public Counter(String page) {
        this();
        this.page = page;
    }
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
