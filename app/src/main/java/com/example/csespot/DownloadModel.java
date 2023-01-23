package com.example.csespot;

public class DownloadModel {

    String Name,Link;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
    public DownloadModel(String Name, String Link){
        this.Link=Link;
        this.Name=Name;

    }

}
