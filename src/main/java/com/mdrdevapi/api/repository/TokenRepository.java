package com.mdrdevapi.api.repository;
import com.mdrdevapi.api.entity.TokenEntity;
import com.mdrdevapi.api.requestDtos.tokenRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    @Query(value = "SELECT * FROM restful_api_tokenization u WHERE u.userid = ?1 and u.token = ?1 and u.isvalid = 1", nativeQuery = true)
    public List<TokenEntity> findTokenByParams(tokenRequestDto request);

    @Query(value="SELECT * FROM restful_api_tokenization u WHERE u.userid = ?1", nativeQuery = true)
    public List<TokenEntity> findTokenById(Long userid);
}
