# HTTP client

HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))

HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))

## Methods

GET()
POST(BodyPublisher body)
PUT(BodyPublisher body)
DELETE()

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.GET()
.build();

## Version

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.version(HttpClient.Version.HTTP_2)
.GET()
.build();

## Headers

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.headers("key1", "value1", "key2", "value2")
.GET()
.build();

HttpRequest request2 = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.header("key1", "value1")
.header("key2", "value2")
.GET()
.build();

## Timeout

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.timeout(Duration.of(10, SECONDS))
.GET()
.build();

## Body

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/post"))
.POST(HttpRequest.BodyPublishers.noBody())
.build();

- StringProcessor – reads body from a String, created with HttpRequest.BodyPublishers.ofString
```
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/post"))
  .headers("Content-Type", "text/plain;charset=UTF-8")
  .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
  .build();
```
- InputStreamProcessor – reads body from an InputStream, created with HttpRequest.BodyPublishers.ofInputStream
```java
byte[] sampleData = "Sample request body".getBytes();
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/post"))
  .headers("Content-Type", "text/plain;charset=UTF-8")
  .POST(HttpRequest.BodyPublishers
   .ofInputStream(() -> new ByteArrayInputStream(sampleData)))
  .build();
```
- ByteArrayProcessor – reads body from a byte array, created with HttpRequest.BodyPublishers.ofByteArray
```java
byte[] sampleData = "Sample request body".getBytes();
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/post"))
  .headers("Content-Type", "text/plain;charset=UTF-8")
  .POST(HttpRequest.BodyPublishers.ofByteArray(sampleData))
  .build();
```
- FileProcessor – reads body from a file at the given path, created with HttpRequest.BodyPublishers.ofFile
```java
HttpRequest request = HttpRequest.newBuilder()
  .uri(new URI("https://postman-echo.com/post"))
  .headers("Content-Type", "text/plain;charset=UTF-8")
  .POST(HttpRequest.BodyPublishers.fromFile(
    Paths.get("src/test/resources/sample.txt")))
  .build();
```

# HttpClient

HttpRequest request = HttpRequest.newBuilder()
.uri(new URI("https://postman-echo.com/get"))
.version(HttpClient.Version.HTTP_2)
.GET()
.build();
HttpResponse<String> response = HttpClient.newHttpClient()
.send(request, HttpResponse.BodyHandlers.ofString());

## Cookies
HttpClient.newBuilder()
.cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
.build();

## Response headers

HttpResponse<String> response = HttpClient.newHttpClient()
.send(request, HttpResponse.BodyHandlers.ofString());
HttpHeaders responseHeaders = response.headers(); 