package shop.member.main.vo

data class MemberResponse (
    var email : String,
    var name : String,
    var userId : String,

    val orderResponses : List<ResponseOrder>
)