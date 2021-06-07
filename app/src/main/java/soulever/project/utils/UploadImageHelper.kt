package soulever.project.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Blob
import com.google.cloud.storage.BucketInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.file.Files

object UploadImageHelper {
    fun setCredentials(credentialFile: InputStream?): Storage? {
        var credentialsStream: InputStream? = null
        var credentials: GoogleCredentials? = null
        try {
            credentialsStream = credentialFile
            credentials = GoogleCredentials.fromStream(credentialsStream)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return StorageOptions.newBuilder()
            .setProjectId("packing-314306").setCredentials(credentials)
            .build().service as Storage
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    fun transmitImageFile(storage: Storage, srcFileName: String, newName: String): String? {
        val file = File(srcFileName)
        var fileContent: ByteArray? = null
        fileContent = try {
            Files.readAllBytes(file.toPath())
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        if (fileContent == null) return null
        if (fileContent.size == 0) return null
        val newBuilder = Blob.newBuilder(BucketInfo.of("packing-bucket"), newName)
        val blobInfo = newBuilder.setContentType("image/jpeg").build()
        val blob = storage.create(blobInfo, fileContent)
        val bucket = blob.bucket
        val contentType = blob.contentType
        Log.e("TAG", "transmitImageFile: $contentType $bucket")
        println("File $srcFileName uploaded to bucket $bucket as $newName")
        return newName
    }

}