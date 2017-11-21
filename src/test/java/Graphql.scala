import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Graphql extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("application/json")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9,ru;q=0.8,uk;q=0.7")
		.contentTypeHeader("application/json")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36")

	val headers_0 = Map("Origin" -> "http://localhost:8080")

    val uri1 = "http://localhost:8080/graphql"

	val scn = scenario("Graphql")
		.repeat(200){
			exec(http("request_0")
			.post("/graphql")
			.headers(headers_0)
			.body(RawFileBody("Graphql_0000_request.txt")))
		}
	setUp(scn.inject(atOnceUsers(2000))).protocols(httpProtocol)
}