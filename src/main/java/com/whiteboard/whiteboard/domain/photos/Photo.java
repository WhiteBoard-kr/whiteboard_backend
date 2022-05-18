package com.whiteboard.whiteboard.domain.photos;

import com.whiteboard.whiteboard.domain.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "PHOTO")
@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long liked_id;

    //User Id
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @Column(length = 100)
    private long photo_id;

    @Column(length = 250)
    private String photo_url;
}
