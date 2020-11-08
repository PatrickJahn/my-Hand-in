/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Patrick
 */
public class dadDTO {
    
    String joke;
    String url;

    public dadDTO(String joke, String url) {
        this.joke = joke;
        this.url =  "https://icanhazdadjoke.com";
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
