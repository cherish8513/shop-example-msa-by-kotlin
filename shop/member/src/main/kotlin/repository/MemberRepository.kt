package shop.member.main.repository;

import org.springframework.data.jpa.repository.JpaRepository
import shop.member.main.entity.Member
import java.util.*


interface MemberRepository : JpaRepository<Member, Long> {
    fun findByUuid(uuid : String) : Member?
}