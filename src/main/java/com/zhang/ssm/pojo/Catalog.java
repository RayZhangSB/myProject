package com.zhang.ssm.pojo;

public class Catalog {
    private Byte id;

    private Byte parentId;

    private String name;

    private Boolean isParent;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public Byte getParentId() {
        return parentId;
    }

    public void setParentId(Byte parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }
}