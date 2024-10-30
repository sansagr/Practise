package org.example.webcrawler;

import java.util.List;

public class Website {
    public List<Webpage> webpages;

    public Website(List<Webpage> webpages){
        this.webpages = webpages;
    }

    public List<Webpage> getWebpages() {
        return webpages;
    }


}
