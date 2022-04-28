package shop.member.main.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    var id : Long ?= null
    private set

    @Column(nullable = false, length = 50)
    var name : String ?= null
    private set

    @Column(nullable = false, length = 50)
    var email : String ?= null
    private set

    @Column(nullable = false, unique = true)
    var encryptedPwd : String ?= null
    private set

    @Column(nullable = false, unique = true)
    var uuid : String ?= null
    private set


    fun createMember(name: String, email: String, encryptedPwd: String, uuid: String) : Member{
        val member = Member()
        member.name = name
        member.email = email
        member.encryptedPwd = encryptedPwd
        member.uuid = uuid

        return member
    }
}