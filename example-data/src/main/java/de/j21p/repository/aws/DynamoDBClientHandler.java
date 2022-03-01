package de.j21p.repository.aws;

import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamoDBClientHandler {

  private static final Map<String, DynamoDbClient> instanceMap = new ConcurrentHashMap();

  private DynamoDBClientHandler() {}

  public static synchronized DynamoDbClient getInstance(String region) {
    if (!instanceMap.containsKey(region) || instanceMap.get(region) == null) {
      instanceMap.put(
          region,
          DynamoDbClient.builder()
              .httpClient(UrlConnectionHttpClient.create())
              .region(Region.of(region))
              .build());
    }
    return instanceMap.get(region);
  }

  //  static final DynamoDbEnhancedClient dynamoDbEnhancedClient =
  //      DynamoDbEnhancedClient.builder()
  //          .dynamoDbClient(dynamoDbClient)
  //          .extensions(
  //              Stream.concat(
  //                      ExtensionResolver.defaultExtensions().stream(),
  //                      Stream.of(AutoGeneratedTimestampRecordExtension.create()))
  //                  .collect(Collectors.toList()))
  //          .build();
  //  private static final DynamoDBClientHanlder DYNAMO_DB_CLIENT_HANLDER = new
  // DynamoDBClientHanlder();
  //  public final DynamoDbClient DYNAMO_DB_CLIENT;
  //
  //  private DynamoDBClientHanlder() {
  //    this.DYNAMO_DB_CLIENT =
  //          DynamoDbClient.builder()
  //              .httpClient(UrlConnectionHttpClient.create())
  //              .region(Region.EU_CENTRAL_1)
  //              .build();
  //  }
  //
  //  private static DynamoDBClientHanlder getInstance() {
  //    return DYNAMO_DB_CLIENT_HANLDER;
  //  }
}