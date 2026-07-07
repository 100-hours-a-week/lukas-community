package com.ktb.lukas.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"user_Id", "post_Id"})})
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Postlike extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_Id", nullable = false)
    private Post post;



}
