package data;

import java.io.IOException;
import java.util.ArrayList;

public class SampleTest {
public static void main(String[] args) throws IOException {
	DataDriven data = new DataDriven();
	ArrayList<String> listItems = data.getData("PURCHASE");
	listItems.stream().forEach(System.out::println);
}
}
