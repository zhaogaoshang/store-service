package top.zhaogaoshang.store.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 赵高尚
 * 2020/10/13 0013
 */
@Component
public class Paging {
    Boolean isNext;
    Integer count;
    ArrayList list;

    public Boolean getNext() {
        return isNext;
    }

    public Paging setNext(Boolean next) {
        isNext = next;
        return this;
    }

    public ArrayList getList() {
        return list;
    }

    public Paging setList(ArrayList list) {
        this.list = list;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public Paging setCount(Integer count) {
        this.count = count;
        return this;
    }

    public void result(Integer count, ArrayList list, Integer page) {
        this.setCount(count);
        this.setNext(page * 10 < count);
        this.setList(list);
    }
}
