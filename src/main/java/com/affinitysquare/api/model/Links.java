package com.affinitysquare.api.model;

import java.util.List;

/**
 * This class represents a generic container for a list of links.
 *
 * @param <T> The type of the links to be stored in the list.
 */
public class Links<T> {
    private List<T> linksList;

    public List<T> getLinks() {
        return linksList;
    }

    public void setLinks(List<T> links) {
        this.linksList = links;
    }
}
