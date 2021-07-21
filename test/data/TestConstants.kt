package data

object TestConstants {

    // User
    const val TEST_USER_EMAIL = "user1@test.com"
    const val TEST_USER_PASSWORD = "TEST_USER_PASSWORD"
    const val TEST_USER_HASHED_PASSWORD = "c7b05e42bc0a4777fc6699ca2e1a5c2b42404c520fd05dddb602a2f4cf2561e1:88c855955c858b31c36500cc34e77218c83b5005e5b1585b0a2a7eabfd440781"
    const val TEST_USER_USERNAME = "TEST_USER_USERNAME"
    const val TEST_USER_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc19hZG1pbiI6ZmFsc2UsImF1ZCI6InByaW50ZXIgYXVkaWVuY2UiLCJpc3MiOiIzRCBwcmludGluZyBhcGkiLCJlbWFpbCI6InVzZXIxQHRlc3QuY29tIiwidXNlcm5hbWUiOiJ1c2VybmFtZSJ9.XfZkH5c5Sbv0xWx0szaUJf_SG18MYrjuKVUlldbnBZg"
    const val TEST_ADMIN_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc19hZG1pbiI6dHJ1ZSwiYXVkIjoicHJpbnRlciBhdWRpZW5jZSIsImlzcyI6IjNEIHByaW50aW5nIGFwaSIsImVtYWlsIjoidXNlcjFAdGVzdC5jb20iLCJ1c2VybmFtZSI6InVzZXJuYW1lIn0.uMOEFMjUoOqIj8_u868bxM2yw3xDK8KSz4AlKmL5CoM"

    // Object
    const val TEST_CREATED_OBJECT = "TEST_CREATED_OBJECT"
    const val TEST_UNSLICED_OBJECT = "TEST_UNSLICED_OBJECT"
    const val TEST_SLICED_OBJECT = "TEST_SLICED_OBJECT"
    const val TEST_CART_OBJECT = "TEST_CART_OBJECT1"
    const val TEST_TRACKING_OBJECT = "TEST_TRACKING_OBJECT" //similar to pending
    const val TEST_COMPLETED_OBJECT = "TEST_COMPLETED_OBJECT"

    const val TEST_PENDING_OBJECT = "TEST_PENDING_OBJECT" // similar to tracking
    const val TEST_PRINTING_OBJECT = "TEST_PRINTING_OBJECT"
    const val TEST_PRINTED_OBJECT = "TEST_PRINTED_OBJECT"

    const val TEST_OBJECT_NAME = "TEST_OBJECT_NAME"
    const val TEST_OBJECT_FILE_URL = "/static/images/scene.glb"
    const val TEST_OBJECT_EXTENSION = "glb"
    const val TEST_OBJECT_IMAGE_URL = "/static/images/3d-image.jpg"

    // Order
    const val TEST_CREATED_ORDER = "TEST_CREATED_ORDER"
    const val TEST_PLACED_ORDER = "TEST_PLACED_ORDER"
    const val TEST_CONFIRMED_ORDER = "TEST_CONFIRMED_ORDER"
    const val TEST_PROCESSING_ORDER = "TEST_PROCESSING_ORDER"
    const val TEST_PROCESSED_ORDER = "TEST_PROCESSED_ORDER"
    const val TEST_DELIVERING_ORDER = "TEST_DELIVERING_ORDER"
    const val TEST_DELIVERED_ORDER = "TEST_DELIVERED_ORDER"
    const val TEST_UNKNOWN_USER_ORDER = "TEST_UNKNOWN_USER_ORDER"

    // Notifications
    const val TEST_NOTIFICATION_ID = "TEST_NOTIFICATION_ID"
    const val TEST_NOTIFICATION_TITLE = "TEST_NOTIFICATION_TITLE"
    const val TEST_NOTIFICATION_MESSAGE = "TEST_NOTIFICATION_MESSAGE"

    // Invalid
    const val TEST_INVALID_ID = "TEST_INVALID_ID"
}