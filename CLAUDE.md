# CLAUDE.md

Guidance for working in this repository.

## Project Overview

`bitmart-java-sdk-api` is the official BitMart Exchange Java client for the
BitMart Cloud API. It wraps BitMart's REST endpoints and WebSocket streams
described in the online docs at <https://developer.bitmart.com/spot> (changelog:
<https://developer-pro.bitmart.com/en/spot/#change-log>).

- **GroupId/ArtifactId:** `io.github.bitmartexchange:bitmart-java-sdk-api`
- **Java:** compiled for Java 8 (`maven.compiler.source/target = 8`)
- **Published to:** Maven Central via the Sonatype Central Portal (`release` profile)
- Current version is the `<version>` in [pom.xml](pom.xml) and the `USER_AGENT`
  constant in [Call.java](src/main/java/com/bitmart/api/Call.java). **Keep these
  two in sync when bumping the version.**

## Build & Test

```bash
mvn install            # build + install to local repo
mvn test               # run JUnit 5 tests
mvn package            # build the jar
mvn -Prelease deploy   # sign (GPG) + publish to Central (release only)
```

Tests live under `src/test/java`:
- `com.bitmart.unit.*` — JUnit 5 unit tests grouped by domain (`api`, `websocket`, `data`).
- `com.bitmart.examples.*` — runnable `main()` examples mirroring the README, one
  class per endpoint/stream. These double as living usage documentation.

Many tests/examples need real API credentials (key/secret/memo). They hit live
endpoints, so treat them as integration samples, not pure unit tests.

## Architecture

Two independent subsystems share the auth/key/common code:

### 1. REST client (`com.bitmart.api`)

The flow is **build a Request object → pass it to `Call.callCloud()` → get a `CloudResponse`**.

- [Call.java](src/main/java/com/bitmart/api/Call.java) — the HTTP engine (OkHttp).
  Dispatches GET vs POST based on `request.getMethod()`, builds headers, and
  wraps the result in `CloudResponse` (raw JSON body + HTTP status + rate-limit
  headers `X-BM-RateLimit-*`).
- [CloudContext.java](src/main/java/com/bitmart/api/CloudContext.java) — holds
  the base URL, timeouts, custom headers, and the `CloudKey`. Default URL is
  `GlobalConst.CLOUD_URL`. Construct with a `CloudKey` for authenticated calls,
  or no-arg for public-only.
- [CloudRequest.java](src/main/java/com/bitmart/api/request/CloudRequest.java) —
  base class for **every** request. Subclasses set `path`, `method`, and `auth`
  in their constructor via `super(...)`, and declare parameter fields.
- [Method.java](src/main/java/com/bitmart/api/request/Method.java) — `GET`/`POST`.
- [Auth.java](src/main/java/com/bitmart/api/request/Auth.java) — `NONE` (public),
  `KEYED` (sends `X-BM-KEY` only), `SIGNED` (adds `X-BM-TIMESTAMP` + `X-BM-SIGN`).

### Request parameter mechanism (`@ParamKey` + reflection)

Request classes use Lombok (`@Data @Accessors(chain = true)`) and annotate each
parameter field with
[`@ParamKey(value="...", required=...)`](src/main/java/com/bitmart/api/annotations/ParamKey.java).
At call time,
[`CommonUtils.genRequestMap()`](src/main/java/com/bitmart/api/common/CommonUtils.java)
reflects over the **declared fields of the leaf class only** (it intentionally
does NOT walk superclass fields), builds a sorted `TreeMap` of `key → value`,
skips nulls, and throws `CloudException` if a `required` field is null. Because
only leaf fields are scanned, request subclasses must declare all of their own
params directly — don't push shared params up into a base class expecting them
to be serialized.

- GET: the map becomes a `key=value&...` query string.
- POST: the map is serialized to a JSON body.

The same query/body string is what gets HMAC-signed.

### Signing (`SIGNED` endpoints)

[CloudSignature.java](src/main/java/com/bitmart/api/key/CloudSignature.java)
produces `X-BM-SIGN = HMAC-SHA256(secret, "{timestamp}#{memo}#{payload}")`
(hex-encoded), where `payload` is the query string (GET) or JSON body (POST),
and sets `X-BM-TIMESTAMP` to `System.currentTimeMillis()`.

### Adding a new REST endpoint

1. Create a `*Request` class in the correct package under
   `com.bitmart.api.request` (see layout below).
2. Extend `CloudRequest`; in the constructor call
   `super("/the/api/path", Method.GET_or_POST, Auth.LEVEL)`.
3. Add fields annotated with `@ParamKey`, plus Lombok annotations
   (`@EqualsAndHashCode(callSuper=true) @Data @ToString @Accessors(chain=true)`).
4. Add an example under `src/test/java/com/bitmart/examples/...` and/or a unit test.

### Request package layout (`src/main/java/com/bitmart/api/request`)

Convention: `<domain>/<pub|prv>[/<version>]`, where `pub` = public/unauthenticated
and `prv` = private/authenticated.

- `spot/pub/market` — spot market data, V3 (`V3TickerRequest`, `V3DepthRequest`, `V3HistoryKlineRequest`, …)
- `spot/prv` — spot trading (`SubmitOrderRequest`, `BatchOrdersRequest`, `CancelOrderRequest`, margin orders, …)
- `spot/prv/v4` — V4 signed query endpoints (`V4QueryOpenOrdersRequest`, `V4QueryHistoryOrdersRequest`, trades, …)
- `contract/pub` — futures market data (`DepthRequest`, `KlineRequest`, `FundingRateRequest`, `LeverageBracketRequest`, …)
- `contract/prv` — futures trading/account (orders, plan/tp-sl/trail orders, positions, leverage, transfers, …)
- `account/pub` — `AccountCurrenciesRequest`
- `account/prv` — wallet, deposit/withdraw, withdraw address, isolated margin transfer, trade-fee
- `margin_loan/prv` — isolated margin borrow/repay + records and pairs
- `system/pub` — `SystemServiceRequest`, `SystemTimeRequest`
- `broker` — `BrokerRebateRequest`

### 2. WebSocket client (`com.bitmart.websocket`)

Netty-based WS client supporting four endpoints defined in
[GlobalConst.java](src/main/java/com/bitmart/api/common/GlobalConst.java):
spot public/private and futures public/private (`CLOUD_*_WS_*_URL`).

- [WebSocketClient.java](src/main/java/com/bitmart/websocket/WebSocketClient.java) /
  [ContractWebSocket.java](src/main/java/com/bitmart/websocket/ContractWebSocket.java) —
  connect, auto-reconnect (replaying subscribed channels + re-login), keepalive
  (`ping` every 10s), and `login()` for private streams.
- Login signs the literal string `"bitmart.WebSocket"` and sends
  `{"op":"login","args":[apiKey, timestamp, sign]}`.
- Subscribe via [OpParam](src/main/java/com/bitmart/websocket/OpParam.java):
  `send(new OpParam().setOp("subscribe").setArgs(ImmutableList.of("spot/ticker:BTC_USDT")))`.
- Implement [WebSocketCallBack](src/main/java/com/bitmart/websocket/WebSocketCallBack.java)
  `onMessage(String)` to receive frames.
- Channel name constants:
  [spot/WebSocketConstant](src/main/java/com/bitmart/websocket/spot/WebSocketConstant.java),
  [contract/ContractWebSocketConstant](src/main/java/com/bitmart/websocket/contract/ContractWebSocketConstant.java).
  Use `createChannel(channel, symbol)` to build `"channel:symbol"` args.

## Conventions

- **Lombok everywhere.** Request/response/data classes rely on `@Data`,
  `@Accessors(chain = true)` (fluent setters return `this`), `@ToString`,
  `@EqualsAndHashCode(callSuper = true)`. Setters are chainable by design.
- **No business logic in request classes** — they are pure parameter holders.
  All serialization/signing is centralized in `Call` + `CommonUtils` + `CloudSignature`.
- Responses are returned as **raw JSON strings** (`CloudResponse.getResponseContent()`);
  the SDK does not deserialize into typed response models.
- Errors surface as `CloudException` (checked).
- Class naming mirrors the API doc endpoint name, with a version prefix
  (`V3`/`V4`) where the API is versioned.

## Key dependencies

OkHttp (REST transport), Netty (WebSocket), Gson (JSON), Guava, Apache Commons
(codec/lang3/collections4), SLF4J (logging API), Lombok (provided). Tests:
JUnit Jupiter 5, Logback.
