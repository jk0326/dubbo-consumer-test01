package com.aaa.cjk.dubbo.model;

import java.io.Serializable;

public class Book implements Serializable {
    private Long id;

    private String bookName;

    private Double bookPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) {
            return false;
        }
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) {
            return false;
        }
        return bookPrice != null ? bookPrice.equals(book.bookPrice) : book.bookPrice == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookPrice != null ? bookPrice.hashCode() : 0);
        return result;
    }
}