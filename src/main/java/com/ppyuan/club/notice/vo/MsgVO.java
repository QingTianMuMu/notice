package com.ppyuan.club.notice.vo;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="msg")
public class MsgVO {

    @Id
    @GeneratedValue
    private int id;

    @Column(name ="title")
    private String title;

    @Column(name ="date")
    private Date date;

    @Column(name ="phone")
    private String phone;

    @Column(name ="content")
    private String content;

    @Column(name ="count")
    private int count;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MsgVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", phone='" + phone + '\'' +
                ", content='" + content + '\'' +
                ", count=" + count +
                '}';
    }
}
