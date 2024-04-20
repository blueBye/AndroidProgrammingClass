package info.navidlabs.androidprogrammingclass.data

import info.navidlabs.androidprogrammingclass.models.Poem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/random")
    suspend fun getRandomPoem(): Response<Poem>
}