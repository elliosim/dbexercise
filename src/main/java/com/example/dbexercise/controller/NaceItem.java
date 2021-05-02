package com.example.dbexercise.controller;

import com.opencsv.bean.CsvBindByName;

public class NaceItem {

    @CsvBindByName
    private int order;

    @CsvBindByName
    private int level;

    @CsvBindByName
    private String code;

    @CsvBindByName
    private String parent;

    @CsvBindByName
    private String description;

    @CsvBindByName(column = "This item includes")
    private String thisItemIncludes;

    @CsvBindByName(column = "This item also includes")
    private String thisItemAlsoIncludes;

    @CsvBindByName
    private String rulings;

    @CsvBindByName(column = "This item excludes")
    private String thisItemExcludes;

    @CsvBindByName(column = "Reference to ISIC Rev. 4")
    private String referenceToISICRev4;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThisItemIncludes() {
        return thisItemIncludes;
    }

    public void setThisItemIncludes(String thisItemIncludes) {
        this.thisItemIncludes = thisItemIncludes;
    }

    public String getThisItemAlsoIncludes() {
        return thisItemAlsoIncludes;
    }

    public void setThisItemAlsoIncludes(String thisItemAlsoIncludes) {
        this.thisItemAlsoIncludes = thisItemAlsoIncludes;
    }

    public String getRulings() {
        return rulings;
    }

    public void setRulings(String rulings) {
        this.rulings = rulings;
    }

    public String getThisItemExcludes() {
        return thisItemExcludes;
    }

    public void setThisItemExcludes(String thisItemExcludes) {
        this.thisItemExcludes = thisItemExcludes;
    }

    public String getReferenceToISICRev4() {
        return referenceToISICRev4;
    }

    public void setReferenceToISICRev4(String referenceToISICRev4) {
        this.referenceToISICRev4 = referenceToISICRev4;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "NaceItem{" +
                "order=" + order +
                ", level=" + level +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", description='" + description + '\'' +
                ", thisItemIncludes='" + thisItemIncludes + '\'' +
                ", thisItemAlsoIncludes='" + thisItemAlsoIncludes + '\'' +
                ", rulings='" + rulings + '\'' +
                ", thisItemExcludes='" + thisItemExcludes + '\'' +
                ", referenceToISICRev4='" + referenceToISICRev4 + '\'' +
                '}';
    }
}
