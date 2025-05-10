package practical.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class IOStream_01 {
  public static void main(String[] args) {
    try (
        FileInputStream fis = new FileInputStream("./src/practical/io/data.txt");
        // 한글 파일을 읽어보는 경우 아래가 필요하다
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
    ) {
      String line;
      while ((line=br.readLine()) != null) {
        System.out.println(line);
      }
      // close는 열린 순서와 반대 순서로 닫는다.
      // br.close();
      // isr.close();
      // fis.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // try ()를 사용하면 finally로 close를 안해줘도 된다!
    try (FileOutputStream fos = new FileOutputStream("./src/practical/io/output.txt")) {
      String text = "Hello World!";
      byte[] bytes = text.getBytes();
      fos.write(bytes);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
