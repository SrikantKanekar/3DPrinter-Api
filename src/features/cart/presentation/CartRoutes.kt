package com.example.features.cart.presentation

import com.example.features.auth.domain.UserPrincipal
import com.example.features.cart.data.CartRepository
import com.example.util.AUTH.USER_SESSION_AUTH
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.freemarker.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.registerCartRoute() {

    val cartRepository by inject<CartRepository>()

    routing {
        authenticate(USER_SESSION_AUTH) {
            getCartRoute(cartRepository)
            updateQuantity(cartRepository)
            removeFromCart(cartRepository)
        }
    }
}

private fun Route.getCartRoute(cartRepository: CartRepository) {
    get("/cart") {
        val principal = call.principal<UserPrincipal>()!!
        val objects = cartRepository.getCartObjects(principal.email)
        call.respond(
            FreeMarkerContent(
                "cart.ftl",
                mapOf("objects" to objects, "user" to principal)
            )
        )
    }
}