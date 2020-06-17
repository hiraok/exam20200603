package jp.hiraok.exam20200603.api

import jp.hiraok.exam20200603.api.response.ContributorResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {

    @GET("/repos/android/architecture-components-samples/contributors")
    suspend fun contributors(@Query("page") page: Int, @Query("count") count: Int = 10): List<ContributorResponse>

}
