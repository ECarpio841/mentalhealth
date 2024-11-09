package com.mentalhealth.mentalhealth.response

data class JSendResponse(
    val status: String,
    val message: String?,
    val data: Any? = null,
    val code: Int? = null
) {
    companion object {
        fun success(data: Any?, message: String? = null, code: Int?): JSendResponse {
            return JSendResponse(status = "success", message = message, data = data, code = code)
        }

        fun fail(data: Any?, message: String? = null, code: Int?): JSendResponse {
            return JSendResponse(status = "fail", message = message, data = data, code = code)
        }

        fun error(message: String, code: Int? = null): JSendResponse {
            return JSendResponse(status = "error", message = message, data = null, code = code)
        }
    }
}