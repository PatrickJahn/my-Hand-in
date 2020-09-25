/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Patrick
 */
public class PersonStyleDTO {
    
    
    private String name;
    private int year;
    private String swimStyle;

    public PersonStyleDTO(String name, int year, String styleName) {
        this.name = name;
        this.year = year;
        this.swimStyle = styleName;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getSwimStyle() {
        return swimStyle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setSwimStyle(String swimStyle) {
        this.swimStyle = swimStyle;
    }
    
    
    
}
