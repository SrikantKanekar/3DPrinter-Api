package com.example.features.`object`.data

import com.example.database.user.UserDataSource
import com.example.features.`object`.domain.*
import com.example.features.`object`.domain.ObjectStatus.*
import kotlinx.coroutines.delay
import kotlin.random.Random

class ObjectRepository(
    private val userDataSource: UserDataSource
) {
    suspend fun createNewObject(fileName: String): Object {
        return userDataSource.createNewObject(fileName)
    }

    suspend fun addUserObject(email: String, obj: Object): Boolean {
        val user = userDataSource.getUser(email)
        user.objects.add(obj)
        return userDataSource.updateUser(user)
    }

    suspend fun getUserObject(email: String, id: String): Object? {
        val user = userDataSource.getUser(email)
        return user.objects.find { it.id == id }
    }

    /**
     * use object ID value to get the object file, slice the file in octoPrint
     */
    suspend fun slice(objectId: String): SlicingDetails? {
        delay(3000)
        val time = "7hr 37min"
        val materialWeight = Random.nextInt(10, 100)
        val materialCost = Random.nextInt(500, 1500)
        val electricityCost = Random.nextInt(100, 300)
        val totalPrice = Random.nextInt(2000, 4000)
        return SlicingDetails(
            time = time,
            materialWeight = materialWeight,
            materialCost = materialCost,
            electricityCost = electricityCost,
            totalPrice = totalPrice
        )
    }

    suspend fun sliceUserObject(email: String, objectId: String): SlicingDetails? {
        val result = slice(objectId)
        result?.let {
            val user = userDataSource.getUser(email)
            user.objects
                .filter { it.status == NONE }
                .find { it.id == objectId }
                ?.apply {
                    slicingDetails.uptoDate = true
                    slicingDetails.time = result.time
                    slicingDetails.materialWeight = result.materialWeight
                    slicingDetails.materialCost = result.materialCost
                    slicingDetails.electricityCost = result.electricityCost
                    slicingDetails.totalPrice = result.totalPrice
                }
            userDataSource.updateUser(user)
        }
        return result
    }

    suspend fun addToCart(email: String, objectId: String): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == NONE }
            .find { it.id == objectId && it.slicingDetails.uptoDate }
            ?.let { it.status = CART } ?: return false
        return userDataSource.updateUser(user)
    }

    suspend fun removeFromCart(email: String, objectId: String): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == CART }
            .find { it.id == objectId }
            ?.let { it.status = NONE } ?: return false
        return userDataSource.updateUser(user)
    }

    suspend fun deleteUserObject(email: String, objectId: String): Boolean {
        val user = userDataSource.getUser(email)
        val deleted = user.objects.removeIf { it.id == objectId && it.status == NONE }
        return userDataSource.updateUser(user) and deleted
    }


    suspend fun updateFilename(email: String, id: String, fileName: String): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == NONE || it.status == CART }
            .find { it.id == id }
            ?.let { it.filename = fileName } ?: return false
        return userDataSource.updateUser(user)
    }

    suspend fun updateBasicSettings(email: String, id: String, basicSetting: BasicSetting): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == NONE || it.status == CART }
            .find { it.id == id }
            ?.let {
                it.basicSetting = basicSetting
                it.slicingDetails.uptoDate = false
            } ?: return false
        return userDataSource.updateUser(user)
    }

    suspend fun updateIntermediateSettings(
        email: String,
        id: String,
        intermediateSetting: IntermediateSetting
    ): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == NONE || it.status == CART }
            .find { it.id == id }
            ?.let {
                it.intermediateSetting = intermediateSetting
                it.slicingDetails.uptoDate = false
            } ?: return false
        return userDataSource.updateUser(user)
    }

    suspend fun updateAdvancedSettings(email: String, id: String, advancedSetting: AdvancedSetting): Boolean {
        val user = userDataSource.getUser(email)
        user.objects
            .filter { it.status == NONE || it.status == CART }
            .find { it.id == id }
            ?.let {
                it.advancedSetting = advancedSetting
                it.slicingDetails.uptoDate = false
            } ?: return false
        return userDataSource.updateUser(user)
    }
}