package com.example.testdemo.Response


import com.google.gson.annotations.SerializedName

data class ResponseApiUser(
    @SerializedName("data")
    var `data`: Data?,
    @SerializedName("message")
    var message: String?,
    @SerializedName("success")
    var success: Boolean?
) {
    data class Data(
        @SerializedName("app_list")
        var appList: List<App>?,
        @SerializedName("usage_access")
        var usageAccess: Int?
    ) {
        data class App(
            @SerializedName("app_icon")
            var appIcon: String?,
            @SerializedName("app_id")
            var appId: Int?,
            @SerializedName("app_name")
            var appName: String?,
            @SerializedName("app_package_name")
            var appPackageName: String?,
            @SerializedName("fk_kid_id")
            var fkKidId: Int?,
            @SerializedName("kid_profile_image")
            var kidProfileImage: String?,
            @SerializedName("status")
            var status: String?,
            var isSelected: Boolean = false
        )
    }
}