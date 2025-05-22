package practical.set;

import java.util.Objects;

public class Building {
  private String name;
  private String addr;

  public Building(String name, String addr) {
    this.name = name;
    this.addr = addr;
  }

  public String getName() {
    return name;
  }

  public String getAddr() {
    return addr;
  }

  @Override
  public String toString() {
    return "Building [name=" + name + ", addr=" + addr + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Building building)) {
      return false;
    }
    return Objects.equals(name, building.name) && Objects.equals(addr,
        building.addr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, addr);
  }
}
