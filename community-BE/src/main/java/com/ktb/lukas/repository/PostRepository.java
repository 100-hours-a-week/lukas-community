package com.ktb.lukas.repository;
import com.ktb.lukas.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("""
    SELECT p
    FROM Post p
    JOIN FETCH p.author
    ORDER BY p.id DESC
""")
    List<Post> findPostsWithAuthor(Pageable pageable);


}
