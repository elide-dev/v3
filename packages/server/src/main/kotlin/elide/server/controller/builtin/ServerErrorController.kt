package elide.server.controller.builtin

import elide.server.RawPayload
import elide.server.RawResponse
import elide.server.annotations.Eager
import elide.server.html
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Error
import io.micronaut.http.annotation.Get
import kotlinx.html.h1
import kotlinx.html.p
import kotlinx.html.tagext.body
import kotlinx.html.tagext.head
import kotlinx.html.title
import java.io.ByteArrayOutputStream

/** Default built-in controller which handles `500 Internal Server Error` events. */
@Eager @Controller public class ServerErrorController : BuiltinController() {
  /** @inheritDoc */
  @Get("/error/internal", produces = [MediaType.TEXT_HTML])
  @Error(status = HttpStatus.INTERNAL_SERVER_ERROR, global = true)
  override suspend fun handle(request: HttpRequest<out Any>): RawResponse {
    val accept = (request.accept() ?: listOf(MediaType.TEXT_HTML)).map { it.toString() }
    return when {
      accept.contains(MediaType.TEXT_HTML) -> serveHTMLError()
      accept.contains(MediaType.APPLICATION_JSON) -> serveJSONError()
      else -> servePlaintext()
    }
  }

  // Serve a 500 in HTML.
  private suspend fun serveHTMLError(): RawResponse = html {
    html {
      head {
        title { +"Uh oh" }
      }
      body {
        h1 { +"Something went wrong" }
        p { +"Please try again later." }
      }
    }
  }

  // Serve a 500 in JSON.
  private fun serveJSONError(): RawResponse {
    return HttpResponse.serverError<RawPayload>().contentType(MediaType.APPLICATION_JSON)
  }

  // Serve a 500 in plaintext.
  private fun servePlaintext(): RawResponse {
    val baos = ByteArrayOutputStream()
    baos.use {
      it.writeBytes("Not found.".toByteArray())
    }
    return HttpResponse.serverError<RawPayload>().contentType(MediaType.TEXT_PLAIN).body(
      baos
    )
  }
}
