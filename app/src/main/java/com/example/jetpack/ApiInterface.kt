import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response

data class DogImageResponse(
    val message: String,
    val status: String
)

interface DogApiService {
    @GET("breeds/image/random")
    fun getRandomDogImage(): Call<DogImageResponse>
}

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: DogApiService by lazy {
        retrofit.create(DogApiService::class.java)
    }
}



class DogViewModel : ViewModel() {
    private val _dogImageUrl = MutableLiveData<String>()
    val dogImageUrl: LiveData<String> get() = _dogImageUrl

    init {
        fetchRandomDogImage()
    }

    fun fetchRandomDogImage() {
        viewModelScope.launch(Dispatchers.IO) {
            RetrofitInstance.api.getRandomDogImage().enqueue(object : Callback<DogImageResponse> {
                override fun onResponse(call: Call<DogImageResponse>, response: Response<DogImageResponse>) {
                    if (response.isSuccessful) {
                        _dogImageUrl.postValue(response.body()?.message)
                    }
                }

                override fun onFailure(call: Call<DogImageResponse>, t: Throwable) {
                    // Handle failure
                }
            })
        }
    }
}
