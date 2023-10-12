import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    int n = Integer.parseInt(in.readLine());
    Person[] persons = new Person[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      persons[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
    }

    Arrays.sort(persons, (p1, p2) -> {
      return p1.age - p2.age;
    });

    StringBuilder sb = new StringBuilder();
    for (Person p : persons) {
      sb.append(p.age).append(" ").append(p.name).append("\n");
    }

    System.out.print(sb);
    in.close();
  }

  static class Person {
    int age;
    String name;

    Person(int age, String name) {
      this.age = age;
      this.name = name;
    }
  }
}
