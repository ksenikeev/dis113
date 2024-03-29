# JWT Token

Base64: 

Алфавит: ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/ и = в качестве суффикса выравнивания

Кодировка происходит по 3 байта. Очередные 3 байта размещаются в 24 битный буфер (1-й байт в старшие 8 бит, 
2-й байт в средние 8 бит, 3-й байт в младшие 8 бит). Каждые 6 бит используются как номер символа в алфавите (начиная с 0),
и выходная строка последовательно формируется из этих символов. Если кодируется только один байт, то формируется 2 символа
(1-е 6 бит, 2 оставшихся бита + 0000) и в выходную строку добавляется последовательность символов ==. Если кодируется 2
байта, то формируется 3 символа (1-е 6 бит, 2-е 6 бит, 4 оставшихся бита + 00) и в выходную строку добавляется символ =.

JSON Web Token (RFC 7519):

Токен JWT состоит из трех частей: заголовка (header), полезной нагрузки (payload) и подписи или данных шифрования.
Токены могут быть перекодированы в компактное представление (JWS/JWE Compact Serialization): к заголовку и полезной 
нагрузке применяется алгоритм кодирования Base64-URL, после чего добавляется подпись и все три элемента разделяются точками.

[jwt.io](https://jwt.io)

## Структура токена:
```
HEADER:
{
  "alg": "HS256",
  "typ": "JWT"
}
PAYLOAD:
{
  "sub": "1234567890",
  "name": "John Doe",
  "iat": 1516239022
}
SIGNATURE:
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  your-256-bi1t-secret
) 

token = base64UrlEncode(HEADER) + "." + base64UrlEncode(PAYLOAD) + "." + base64UrlEncode(SIGNATURE)

```