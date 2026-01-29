package dsa.other

fun main(){
    val posts = arrayListOf(Post(100001, "22nd", "User1"),
        Post(100003, "22nd", "User2"),
        Post(100000, "22nd", "User1"),
        Post(100002, "22nd", "User5"),
    )

    val topXPosts = getXLatestPost(posts, 10, "User2")
    println(topXPosts)
}

data class Post(val timestamp: Long, val postData: String, val userName: String)

fun getXLatestPost(posts: ArrayList<Post>, topX: Int=1, fromUser: String): ArrayList<Post> {
    val finalList = ArrayList<Post>()

    val filteredList = posts.filter { it.userName == fromUser }
    filteredList.sortedByDescending { it.timestamp }

    val endCondition = if(topX>filteredList.size) filteredList.size else topX
    for (i in 0 until endCondition){
        finalList.add(filteredList[i])
    }
    return finalList
}