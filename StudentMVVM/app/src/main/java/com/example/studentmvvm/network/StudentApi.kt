package com.example.studentmvvm.network

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// 1. Data Transfer Object (DTO)
data class StudentDto(
    @SerializedName("id") val remoteId: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("student_code") val studentCode: String,
    @SerializedName("email") val email: String,
    @SerializedName("gpa") val gpa: Double
)

// 2. Interface ApiService
interface StudentApiService {
    @GET("api/v1/students")
    suspend fun getStudents(): List<StudentDto>

    @POST("api/v1/students")
    suspend fun createStudent(@Body studentDto: StudentDto): StudentDto
}

// 3. Retrofit Client Singleton
// (Mã mẫu Phần 4 - chưa nối vào UI vì BASE_URL chỉ là ví dụ)
object RetrofitClient {
    private const val BASE_URL = "https://api.example.com/"

    val apiService: StudentApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StudentApiService::class.java)
    }
}
