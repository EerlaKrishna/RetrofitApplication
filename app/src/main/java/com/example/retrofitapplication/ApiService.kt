import com.example.retrofitapplication.Joke
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("jokes/random/10")
    fun getRandomJokes(): Call<List<Joke>>


}
