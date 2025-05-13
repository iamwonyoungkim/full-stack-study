package builder.builder1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class HTMLBuilder extends Builder {
  private String filename = "untitled.html";
  private StringBuilder sb = new StringBuilder();

  @Override
  public void makeTitle(String title) {
    filename = title + ".html";
    sb.append("<!DOCTYPE html>\n");
    sb.append("<html>\n");
    sb.append("<head><title>");
    sb.append(title);
    sb.append("</title></head>\n");
    sb.append("<body>\n");
    sb.append("<h1>");
    sb.append(title);
    sb.append("</h1>\n\n");
  }

  @Override
  public void makeString(String str) {
    sb.append("<p>");
    sb.append(str);
    sb.append("</p>\n\n");
  }

  @Override
  public void makeItems(String[] items) {
    sb.append("<ul>\n");
    for(String s: items) {
      sb.append("<li>");
      sb.append(s);
      sb.append("</li>\n");
    }
    sb.append("</ul>\n\n");
  }

  @Override
  public void close() {
    sb.append("</body>\n");
    sb.append("</html>\n");
    // String builder에서 다 만들고 마지막에 파일에 쓴다.
    // 입출력의 횟수에 따라 성능 차이가 갈리기 때문이다.
    try(Writer writer = new FileWriter(filename)) {
      writer.write(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getHTMLResult() {
    return filename;
  }
}
