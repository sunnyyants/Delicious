package com.models;

import java.util.Set;

/**
 * Created by Sunny on 4/17/14.
 */

public class Genre {

    private Integer id;
    private String name;
    private Set<Menu> menuSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }
}
