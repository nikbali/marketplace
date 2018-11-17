package com.example.polls.repository;

import com.example.polls.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT v FROM Product v where v.tag.title = :tag")
      List<Product> findByTag(@Param("tag") String tag);

    @Query("SELECT v FROM Product v where v.tag.title in :tags")
     List<Product> findByTags(@Param("tags") List<String> tags);

//    @Query("SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id in :pollIds GROUP BY v.choice.id")
//    List<ChoiceVoteCount> countByPollIdInGroupByChoiceId(@Param("pollIds") List<Long> pollIds);
//
//    @Query("SELECT NEW com.example.polls.model.ChoiceVoteCount(v.choice.id, count(v.id)) FROM Vote v WHERE v.poll.id = :pollId GROUP BY v.choice.id")
//    List<ChoiceVoteCount> countByPollIdGroupByChoiceId(@Param("pollId") Long pollId);
//
//    @Query("SELECT v FROM Vote v where v.user.id = :userId and v.poll.id in :pollIds")
//    List<Vote> findByUserIdAndPollIdIn(@Param("userId") Long userId, @Param("pollIds") List<Long> pollIds);
//
//    @Query("SELECT v FROM Vote v where v.user.id = :userId and v.poll.id = :pollId")
//    Vote findByUserIdAndPollId(@Param("userId") Long userId, @Param("pollId") Long pollId);
//
//    @Query("SELECT COUNT(v.id) from Vote v where v.user.id = :userId")
//    long countByUserId(@Param("userId") Long userId);
//
//    @Query("SELECT v.poll.id FROM Vote v WHERE v.user.id = :userId")
//    Page<Long> findVotedPollIdsByUserId(@Param("userId") Long userId, Pageable pageable);
}

