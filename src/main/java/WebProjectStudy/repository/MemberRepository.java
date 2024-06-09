package WebProjectStudy.repository;
import WebProjectStudy.dto.MemberDTO;
import WebProjectStudy.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findById(Long id);
}
