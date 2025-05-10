package practical.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOStream_02 {

  public static void main(String[] args) {
    try (
        FileReader fr = new FileReader("./src/practical/io/data.txt");
        BufferedReader br = new BufferedReader(fr);
    ) {
      String line;
      while ((line=br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    // try ()를 사용하면 finally로 close를 안해줘도 된다!
    try (
        FileWriter fw = new FileWriter("./src/practical/io/output.txt");
        ) {
      fw.write("토요일에 만나서");
      fw.write("반갑습니다.");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

}
