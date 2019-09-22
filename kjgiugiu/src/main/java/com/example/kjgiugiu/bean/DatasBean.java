package com.example.kjgiugiu.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class DatasBean {
    @Id(autoincrement = true)
    private Long id;
    @Property
    @NotNull
    private String title;
    private String thumbnail;
    private String author;
    @Generated(hash = 1672659204)
    public DatasBean(Long id, @NotNull String title, String thumbnail,
            String author) {
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.author = author;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
