package com.dosorme.lights.demo.mapper

import com.dosorme.lights.demo.model.UserProfile
import org.apache.ibatis.annotations.*

@Mapper
interface HelloMapper {
    @Select("SELECT * FROM UserProfile WHERE id = #{id}")
    fun getUserProfile(@Param("id") id: String): UserProfile

    @Select("SELECT * FROM UserProfile")
    fun getUserProfileList(): List<UserProfile>

    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{address})")
    fun putUserProfile(
        @Param("id") id: String,
        @Param("name") name: String,
        @Param("address") address: String
    )

    @Update("UPDATE UserProfile SET name = #{name}, address = #{address} WHERE id = #{id}")
    fun postUserProfile(
        @Param("id") id: String,
        @Param("name") name: String,
        @Param("address") address: String
    )

    @Delete("DELETE FROM UserProfile WHERE id = #{id}")
    fun deleteUserProfile(@Param("id") id:String)
}