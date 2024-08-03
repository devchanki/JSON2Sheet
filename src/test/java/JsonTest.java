import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.chanki.JsonParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class JsonTest {

  @Test
  @DisplayName("JSON 키 목록 테스트/ 파일 경로로 Get")
  void getJsonKeyListByFilePath() throws Exception {
    JsonParser jsonParser = new JsonParser().builder().path("./test.json").build().initialize();

    ArrayList<String> keyList = jsonParser.getJsonObjectKeyList();

    ArrayList<String> resultKeyList = new ArrayList<>(Arrays.asList("name", "age"));
    assertEquals(keyList, resultKeyList);
  }

  @Test
  @DisplayName("JSON 키 목록 테스트 / URL 에서 가지고 오기")
  void getJsonKeyListByUrl() throws Exception {
    JsonParser jsonParser = new JsonParser().builder().url("https://jsonplaceholder.typicode.com/comments").build().initialize();

    ArrayList<String> keyList = jsonParser.getJsonObjectKeyList();

    ArrayList<String> resultKeyList = new ArrayList<>(Arrays.asList("postId", "id", "name", "email", "body"));
    assertEquals(keyList, resultKeyList);
  }
}
