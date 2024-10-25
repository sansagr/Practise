package org.example.stadium;

import java.util.List;

public class Stadium {
    private List<Section> sections;

    public Stadium(List<Section> seactions){
        this.sections = seactions;
    }

    public List<Section> getSections() {
        return sections;
    }
}
