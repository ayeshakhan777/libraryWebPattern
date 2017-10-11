/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.util.Objects;

/**
 *
 * @author Sean
 */
public class Title {

    private int titleID;
    private String novelName;
    private String author;
    private int stock;
    private int onLoan;
    private String titleDescription;

    public Title(int titleID, String novelName, String author, int stock, int onLoan, String titleDescription) {
        this.titleID = titleID;
        this.novelName = novelName;
        this.author = author;
        this.stock = stock;
        this.onLoan = onLoan;
        this.titleDescription = titleDescription;
    }

    public Title(String novelName, String author, int stock, int onLoan, String titleDescription) {
        this.novelName = novelName;
        this.author = author;
        this.stock = stock;
        this.onLoan = onLoan;
        this.titleDescription = titleDescription;
    }

    public Title() {

    }

    public int getTitleID() {
        return titleID;
    }

    public void setTitleID(int titleID) {
        this.titleID = titleID;
    }

    public String getNovelName() {
        return novelName;
    }

    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getOnLoan() {
        return onLoan;
    }

    public void setOnLoan(int onLoan) {
        this.onLoan = onLoan;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.novelName);
        hash = 29 * hash + Objects.hashCode(this.author);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Title other = (Title) obj;
        if (!Objects.equals(this.novelName, other.novelName)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Title{" + "novelName=" + novelName + ", author=" + author + ", stock=" + stock + ", onLoan=" + onLoan + ", titleDescription=" + titleDescription + '}';
    }

}
