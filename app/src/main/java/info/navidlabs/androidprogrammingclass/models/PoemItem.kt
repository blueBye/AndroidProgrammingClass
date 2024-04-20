package info.navidlabs.androidprogrammingclass.models

data class PoemItem(
    val author: String = "",
    val linecount: String = "",
    val lines: List<String> = List<String>(1){""},
    val title: String = ""
)