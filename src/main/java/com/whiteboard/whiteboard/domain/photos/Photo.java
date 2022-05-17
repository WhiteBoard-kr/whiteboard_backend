package com.whiteboard.whiteboard.domain.photos;

import javax.persistence.Column;

public class Photo {
    
    @Column(length = 250, nullable = true)
    private String photo_url;
}
